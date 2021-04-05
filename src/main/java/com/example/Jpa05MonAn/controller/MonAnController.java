package com.example.Jpa05MonAn.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa05MonAn.model.MonAn;
import com.example.Jpa05MonAn.repository.CongThucRepository;
import com.example.Jpa05MonAn.repository.LoaiMonAnRepository;
import com.example.Jpa05MonAn.repository.MonAnRepository;
import com.google.gson.Gson;

@RestController
public class MonAnController {

	@Autowired
	CongThucRepository congThucRepository;
	
	@Autowired
	MonAnRepository monAnRepository;
	
	@Autowired
	LoaiMonAnRepository loaiMonAnRepository;
	
	@PostMapping(value = "/monan/themmon")
	public void ThemMonAn(@RequestBody String monAn) {
		Gson gson = new Gson();
		MonAn maMoi = gson.fromJson(monAn, MonAn.class);
		
		ValidatorFactory valFac = Validation.buildDefaultValidatorFactory();
		Validator val = valFac.getValidator();
		Set<ConstraintViolation<MonAn>> violation = val.validate(maMoi);
		
		if(violation.size() == 0) {
			monAnRepository.save(maMoi);
		}
	}
	
	@GetMapping(value = "/monan/timkiem")
	public Set<MonAn> Get(@RequestParam String tenMon, @RequestParam String tenNguyenLieu){
		Set<MonAn> lst = new HashSet<MonAn>();
		monAnRepository.findAll().forEach(x->{
			if(x.getTenMon().toLowerCase().contains(tenMon.toLowerCase())) {
				x.getCongThucs().forEach(y->{
					if(y.getNguyenLieu().getTenNguyenLieu().toLowerCase().contains(tenNguyenLieu.toLowerCase())
							|| x.getCachLam().toLowerCase().contains(tenNguyenLieu.toLowerCase()))
						lst.add(x);
				});
			}
		});
		return lst;
	}
}
