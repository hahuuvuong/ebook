package ebook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chapter")
public class chapter {
	@Id
	@GeneratedValue
	private int idChapter;
	@ManyToOne
	@JoinColumn(name = "idTruyen")
	private truyen idTruyen;
	private String NoiDung;
	private String TenChapter;
	private String linkChapter;
	public int getIdChapter() {
		return idChapter;
	}
	public void setIdChapter(int idChapter) {
		this.idChapter = idChapter;
	}
	public truyen getIdTruyen() {
		return idTruyen;
	}
	public void setIdTruyen(truyen idTruyen) {
		this.idTruyen = idTruyen;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public String getTenChapter() {
		return TenChapter;
	}
	public void setTenChapter(String tenChapter) {
		TenChapter = tenChapter;
	}
	public String getLinkChapter() {
		return linkChapter;
	}
	public void setLinkChapter(String linkChapter) {
		this.linkChapter = linkChapter;
	}
	public chapter(int idChapter, truyen idTruyen, String noiDung, String tenChapter, String linkChapter) {
		super();
		this.idChapter = idChapter;
		this.idTruyen = idTruyen;
		NoiDung = noiDung;
		TenChapter = tenChapter;
		this.linkChapter = linkChapter;
	}
	public chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
