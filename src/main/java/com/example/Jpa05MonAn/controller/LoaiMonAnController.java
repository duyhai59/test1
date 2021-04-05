package com.example.Jpa05MonAn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa05MonAn.repository.CongThucRepository;
import com.example.Jpa05MonAn.repository.LoaiMonAnRepository;
import com.example.Jpa05MonAn.repository.MonAnRepository;

@RestController
public class LoaiMonAnController {
	
	@Autowired
	CongThucRepository congThucRepository;

	@Autowired
	LoaiMonAnRepository loaiMonAnRepository;
	
	@Autowired
	MonAnRepository monAnRepository;
	
	@DeleteMapping(value = "/loaimonan/xoa")
	public void XoaMonAn(@RequestParam int loaiMonAnID) {
		monAnRepository.findAll().forEach(x->{
			if(x.getLoaiMonAn().getId() == loaiMonAnID) {
				congThucRepository.findAll().forEach(y->{
					if(y.getMonAn() == x)
						congThucRepository.delete(y);
				});
				monAnRepository.delete(x);
			}
		});
		loaiMonAnRepository.deleteById(loaiMonAnID);
	}
}
