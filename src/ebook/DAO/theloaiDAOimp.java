package ebook.DAO;

import java.util.List;

import ebook.entity.theloai;

public interface theloaiDAOimp {
	public List<theloai> returnTheLoai();
	public int amountOfTruyen(int idTheLoai);
}
