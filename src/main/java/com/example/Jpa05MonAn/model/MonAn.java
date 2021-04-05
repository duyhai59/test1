package com.example.Jpa05MonAn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "MonAn")
@Entity
public class MonAn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Size(max = 20 ,message = "tên món không vượt quá 20 ký tự")
	String tenMon;
	
	@Column
	int giaBan;
	
	@Column
	String gioiThieu;
	
	@Column
	String cachLam;
	
	@OneToMany(mappedBy = "monAn")
	@JsonIgnoreProperties(value = "monAn")
	Set<CongThuc> congThucs;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loaiMonAnID" , foreignKey = @ForeignKey(name = "fk_monan_loaimonan"))
	@JsonIgnoreProperties(value = "monAns")
	LoaiMonAn loaiMonAn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public int getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public String getCachLam() {
		return cachLam;
	}

	public void setCachLam(String cachLam) {
		this.cachLam = cachLam;
	}

	public Set<CongThuc> getCongThucs() {
		return congThucs;
	}

	public void setCongThucs(Set<CongThuc> congThucs) {
		this.congThucs = congThucs;
	}

	public LoaiMonAn getLoaiMonAn() {
		return loaiMonAn;
	}

	public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
		this.loaiMonAn = loaiMonAn;
	}
	
}
