package com.example.Jpa05MonAn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class LoaiMonAn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Size(max = 20 , message = "ten loai khong vuot qua 20 ky tu")
	String tenLoai;
	
	@Column
	String moTa;
	
	@OneToMany(mappedBy = "loaiMonAn")
	@JsonIgnoreProperties(value = "loaiMonAn")
	Set<MonAn> monAns;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Set<MonAn> getMonAns() {
		return monAns;
	}

	public void setMonAns(Set<MonAn> monAns) {
		this.monAns = monAns;
	}
	
}
