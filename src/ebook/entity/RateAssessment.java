package ebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RateAssessment {
	@Id @GeneratedValue
	@Column(name="Id")
	int idAssessment;
	
	int RateScore;
	
	@Column(name="tittle")
	String titleAssessment;
	
	@Column(name="AssessmentContent")
	String contentAssessment;
	
	@ManyToOne
	@JoinColumn(name = "idTruyen")
	private truyen idTruyen;
	
	@ManyToOne
	@JoinColumn(name = "Username")
	private Accounts Username;
	
	public RateAssessment(int idAssessment, int rateScore, String titleAssessment, String contentAssessment,
			truyen idTruyen, Accounts username) {
		super();
		this.idAssessment = idAssessment;
		RateScore = rateScore;
		this.titleAssessment = titleAssessment;
		this.contentAssessment = contentAssessment;
		this.idTruyen = idTruyen;
		Username = username;
	}
	public int getRateScore() {
		return RateScore;
	}
	public void setRateScore(int rateScore) {
		RateScore = rateScore;
	}
	public truyen getIdTruyen() {
		return idTruyen;
	}
	public void setIdTruyen(truyen idTruyen) {
		this.idTruyen = idTruyen;
	}
	public Accounts getUsername() {
		return Username;
	}
	public void setUsername(Accounts username) {
		Username = username;
	}
	public RateAssessment() {
		super();
	}
	public RateAssessment(int idAssessment, String tittleAssessment, String contentAssessment) {
		super();
		this.idAssessment = idAssessment;
		this.titleAssessment = tittleAssessment;
		this.contentAssessment = contentAssessment;
	}
	public int getIdAssessment() {
		return idAssessment;
	}
	public void setIdAssessment(int idAssessment) {
		this.idAssessment = idAssessment;
	}
	public String getTitleAssessment() {
		return titleAssessment;
	}
	public void setTitleAssessment(String tittleAssessment) {
		this.titleAssessment = tittleAssessment;
	}
	public String getContentAssessment() {
		return contentAssessment;
	}
	public void setContentAssessment(String contentAssessment) {
		this.contentAssessment = contentAssessment;
	}
	
	
}
