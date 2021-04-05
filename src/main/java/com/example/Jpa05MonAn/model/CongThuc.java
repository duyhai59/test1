package com.example.Jpa05MonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "CongThuc")
@Entity
public class CongThuc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	int soLuong;
	
	@Column
	@Size(max = 10 , message = "Đơn vị tính không quá 10")
	String donViTinh;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguyenLieuID" , foreignKey = @ForeignKey(name = "fk_congthuc_nguyenlieu"))
	@JsonIgnoreProperties(value = "congThucs")
	NguyenLieu nguyenLieu;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "monAnID" , foreignKey = @ForeignKey(name = "fk_congthuc_monan"))
	@JsonIgnoreProperties(value = "congThucs")
	MonAn monAn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public NguyenLieu getNguyenLieu() {
		return nguyenLieu;
	}

	public void setNguyenLieu(NguyenLieu nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}
	
}
