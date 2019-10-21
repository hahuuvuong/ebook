package ebook.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ebook.DAO.chapterDAO;
import ebook.DAO.truyenDAO;
import ebook.entity.chapter;
import ebook.entity.truyen;

@Transactional
@Controller
public class AddchapterController {
	@Autowired
	chapterDAO chapterdao;
	@Autowired
	truyenDAO truyendao;
	@Autowired
	SessionFactory factory;
	@RequestMapping("insertchapter/{numPage}")
	public String Insertchapter(ModelMap model,@PathVariable("numPage") int numPage) {
		
		model.addAttribute("num",chapterdao.amountOfChapter());
		model.addAttribute("numPage",numPage);
		model.addAttribute("chapters",chapterdao.allChapter(numPage));
		
		
		return "pages/insertChapter";
	}
	@RequestMapping(value = "addchapter" , method = RequestMethod.GET)
	public String Addtruyen(ModelMap model) {
		chapter chapter = new chapter();
		model.addAttribute("chapter",chapter);
		model.addAttribute("idTruyens", truyendao.returnAllTruyen());
		return "pages/addChapter";
	}
	@RequestMapping(value = "addchapter" , method = RequestMethod.POST)
	public String Addtruyen(ModelMap model,@ModelAttribute("chapter")chapter chapter,HttpServletRequest request) {
		String id = request.getParameter("idtTruyen");
		int idTruyen = Integer.parseInt(id);
		chapter.setIdTruyen(truyendao.returnTruyen(idTruyen));
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(chapter);
			t.commit();
		}
		catch(Exception e) {
			t.rollback();
		}
		finally {
			session.close();
		}
		return "redirect:/inserttruyen/1.htm";
	}
	@RequestMapping(value = "updateChapter/{idChapter}", method = RequestMethod.GET)
	public String updateTruyen(ModelMap model, @PathVariable("idChapter")int idChapter) {
		Session session = factory.getCurrentSession();
		chapter chapter = (chapter)session.get(chapter.class,idChapter);
		truyen idTruyen = chapter.getIdTruyen();
		model.addAttribute("idtruyens", truyendao.returnAllTruyen());
		model.addAttribute("chapter", chapter);
		model.addAttribute("idTruyen", idTruyen);
		return "pages/addChapter";
	}
	@RequestMapping(value = "deleteChapter/{idChapter}")
	public String deleteTruyen(ModelMap model,@PathVariable("idChapter")int idChapter) {
		Session session = factory.openSession();
		chapter chapter = (chapter)session.get(chapter.class,idChapter);
		Transaction t = session.beginTransaction();
		try {
			session.delete(chapter);
			t.commit();
		}
		catch(Exception e) {
			t.rollback();
		}
		finally {
			session.close();
		}
		return "redirect:/insertchapter/1.htm";
	}
}
