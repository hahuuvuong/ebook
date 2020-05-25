package ebook.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Accounts")
public class Accounts {
	@Id
	private String Username;
	private String email;
	private String password;
	private String nickname;
	private boolean role;
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	@JoinTable(
			name = "favBook",
			joinColumns = { @JoinColumn(referencedColumnName = "Username")},
			inverseJoinColumns = {@JoinColumn (referencedColumnName = "idTruyen")}
			)
	Set<truyen> truyens = new HashSet<>(0);
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accounts(String username, String email, String password, String nickname, boolean role) {
		super();
		Username = username;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.role = role;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public Set<truyen> getTruyens() {
		return truyens;
	}
	public void setTruyens(Set<truyen> truyens) {
		this.truyens = truyens;
	}
	
}
