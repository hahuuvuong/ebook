package ebook.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "theloai")
public class theloai {
	@Id
	private int idTheLoai;
	
	private String tenTheLoai;

	
	public int getIdTheLoai() {
		return idTheLoai;
	}
	public void setIdTheLoai(int idTheLoai) {
		this.idTheLoai = idTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public theloai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public theloai(int idTheLoai, String tenTheLoai) {
		super();
		this.idTheLoai = idTheLoai;
		this.tenTheLoai = tenTheLoai;
	}
	
}
