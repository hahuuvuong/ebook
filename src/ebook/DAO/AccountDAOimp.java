package ebook.DAO;

import ebook.entity.Accounts;

public interface AccountDAOimp {
	public boolean checkUsername(String username,String password);
	public String returnNickname(String username);
	public Accounts returnRole(String username);
}
