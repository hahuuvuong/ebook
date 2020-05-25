package ebook.DAO;

import java.util.List;

import ebook.entity.Accounts;
import ebook.entity.truyen;

public interface AccountDAOimp {
	public boolean checkUsername(String username,String password);
	public String returnNickname(String username);
	public Accounts returnRole(String username);
	public int saveFavBook(Accounts acc, truyen truyen);
	public List<truyen> returnFavBook(String username);
	public void deleteFavBook(String username, int id);
	public List<Accounts> returnListUser();
}
