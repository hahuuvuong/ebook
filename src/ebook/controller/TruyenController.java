package ebook.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import ebook.entity.theloai;
import ebook.entity.truyen;

@Transactional
@Controller
public class TruyenController {
	@Autowired
	theloaiDAO theloaidao;
	@Autowired
	chapterDAO chapterdao;
	@Autowired
	truyenDAO truyendao;
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "truyen/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id,ModelMap model) {
		Session session = factory.openSession();
		
		
		List<chapter> list = chapterdao.returnChapterTruyen(id);
		
		truyen idTruyen = (truyen)session.get(truyen.class, id);
		
		theloai idTheLoai = idTruyen.getIdTheLoai();
		
		model.addAttribute("chapter",list);
		model.addAttribute("categories", theloaidao.returnTheLoai());
		model.addAttribute("truyen",truyendao.returnTruyen(id));
		model.addAttribute("relatedBook", truyendao.truyenTheoTheLoai( idTheLoai.getIdTheLoai()));
		
		return "single-book";
	}
}
