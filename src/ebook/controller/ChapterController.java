package ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ebook.DAO.chapterDAO;
import ebook.DAO.theloaiDAO;
import ebook.DAO.truyenDAO;
import ebook.entity.chapter;

@Transactional
@Controller
public class ChapterController {
	@Autowired
	theloaiDAO theloaidao;
	@Autowired
	chapterDAO chapterdao;
	@Autowired
	truyenDAO truyendao;
	@RequestMapping(value = "chapter/{idTruyen}/{idChapter}", method = RequestMethod.GET)
	public String contentChapter(@PathVariable("idTruyen") int idTruyen,@PathVariable("idChapter")int idChapter, ModelMap model) {
		
		List<chapter> list = chapterdao.returnChapterTruyen(idTruyen);
		
		
		
		model.addAttribute("chapter",list);
		model.addAttribute("categories", theloaidao.returnTheLoai());
		model.addAttribute("content", chapterdao.returnContentChapter(idChapter));
		model.addAttribute("truyen",truyendao.returnTruyen(idTruyen));
		
		return "single-chapter";
	}
}
