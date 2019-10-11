package ebook.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "truyen")
public class truyen {
	@Id
	@GeneratedValue
	private int idTruyen;
	@ManyToOne
	@JoinColumn(name = "idTheLoai")
	private theloai idTheLoai;
	private String TenTruyen;
	private String TacGia;
	private String TomTat;
	private String linkTruyen;
	private String image;
	@OneToMany(mappedBy = "idChapter",fetch = FetchType.LAZY)
	private Collection <chapter> chapters;
	public int getIdTruyen() {
		return idTruyen;
	}
	public void setIdTruyen(int idTruyen) {
		this.idTruyen = idTruyen;
	}
	public theloai getIdTheLoai() {
		return idTheLoai;
	}
	public void setIdTheLoai(theloai idTheLoai) {
		this.idTheLoai = idTheLoai;
	}
	public String getTenTruyen() {
		return TenTruyen;
	}
	public void setTenTruyen(String tenTruyen) {
		TenTruyen = tenTruyen;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}
	public String getTomTat() {
		return TomTat;
	}
	public void setTomTat(String tomTat) {
		TomTat = tomTat;
	}
	public String getLinkTruyen() {
		return linkTruyen;
	}
	public void setLinkTruyen(String linkTruyen) {
		this.linkTruyen = linkTruyen;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Collection<chapter> getChapters() {
		return chapters;
	}
	public void setChapters(Collection<chapter> chapters) {
		this.chapters = chapters;
	}
	public truyen(int idTruyen, theloai idTheLoai, String tenTruyen, String tacGia, String tomTat, String linkTruyen,
			String image, Collection<chapter> chapters) {
		super();
		this.idTruyen = idTruyen;
		this.idTheLoai = idTheLoai;
		TenTruyen = tenTruyen;
		TacGia = tacGia;
		TomTat = tomTat;
		this.linkTruyen = linkTruyen;
		this.image = image;
		this.chapters = chapters;
	}
	public truyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}