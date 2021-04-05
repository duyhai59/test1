package com.example.Jpa05MonAn.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa05MonAn.model.CongThuc;
import com.example.Jpa05MonAn.model.MonAn;
import com.example.Jpa05MonAn.repository.CongThucRepository;
import com.example.Jpa05MonAn.repository.MonAnRepository;
import com.example.Jpa05MonAn.repository.NguyenLieuRepository;
import com.google.gson.Gson;

@RestController
public class CongThucController {

	@Autowired
	NguyenLieuRepository nguyenLieuRepository;
	
	@Autowired 
	CongThucRepository congThucRepository;
	
	@Autowired
	MonAnRepository monAnRepository;
	
	@PostMapping(value = "/congthuc/them")
	public void ThemCongThuc(@RequestBody String congThuc) {
		Gson gson = new Gson();
		CongThuc ctMoi = gson.fromJson(congThuc, CongThuc.class);
		
		ValidatorFactory valFac = Validation.buildDefaultValidatorFactory();
		Validator val = valFac.getValidator();
		Set<ConstraintViolation<CongThuc>> violation = val.validate(ctMoi);
		
		if(violation.size() == 0) {
			congThucRepository.save(ctMoi);
			MonAn maCurrent = monAnRepository.findById(ctMoi.getMonAn().getId()).get();
			maCurrent.setCachLam(maCurrent.getCachLam() + "\n" + 
					nguyenLieuRepository.findById(ctMoi.getNguyenLieu().getId()).get().getTenNguyenLieu() + " : " +
					String.valueOf(ctMoi.getSoLuong()) + " " + ctMoi.getDonViTinh() + " ,"		
					);
			monAnRepository.save(maCurrent);
		}
	}
}
