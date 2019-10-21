package ebook.DAO;

import java.util.List;

import ebook.entity.chapter;

public interface chapterDAOimp {
	public List<chapter> returnChapterTruyen(int idTruyen);
	public chapter returnContentChapter(int idChapter);
	public int amountOfChapter();
	public List<chapter> allChapter(int numPage);
}
