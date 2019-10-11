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
	@OneToMany(mappedBy = "idTruyen",fetch = FetchType.LAZY)
	private Collection<truyen> truyens;
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
	public Collection<truyen> getTruyens() {
		return truyens;
	}
	public void setTruyens(Collection<truyen> truyens) {
		this.truyens = truyens;
	}
	public theloai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public theloai(int idTheLoai, String tenTheLoai, Collection<truyen> truyens) {
		super();
		this.idTheLoai = idTheLoai;
		this.tenTheLoai = tenTheLoai;
		this.truyens = truyens;
	}
	
}
