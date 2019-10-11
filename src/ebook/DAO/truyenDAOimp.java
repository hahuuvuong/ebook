package ebook.DAO;

import java.util.List;

import ebook.entity.truyen;

public interface truyenDAOimp {
	public truyen returnTruyen(int id);
	public List<truyen> randomTruyen(int soluong);
	public List<truyen> truyenTheoTheLoai(int idTheLoai);
	public List<truyen> truyenTheLoai(int idTheLoai,int numPage);
	public List<truyen> searchingTruyen(String keywords);
}
