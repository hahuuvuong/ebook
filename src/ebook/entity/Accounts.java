package ebook.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Accounts {
	@Id
	private String Username;
	private String email;
	private String password;
	private String nickname;
	private boolean role;
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
	
	
	
}
