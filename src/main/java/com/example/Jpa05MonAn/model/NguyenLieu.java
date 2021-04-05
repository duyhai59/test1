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

@Table(name = "NguyenLieu")
@Entity
public class NguyenLieu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Size(max = 20 , message = "Tên nguyên liệu không vượt quá 20 ký tự")
	String tenNguyenLieu;
	
	@Column
	String ghiChu;
	
	@OneToMany(mappedBy = "nguyenLieu")
	@JsonIgnoreProperties(value = "nguyenLieu")
	Set<CongThuc> congThucs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Set<CongThuc> getCongThucs() {
		return congThucs;
	}

	public void setCongThucs(Set<CongThuc> congThucs) {
		this.congThucs = congThucs;
	}
	
	
}
