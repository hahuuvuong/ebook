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

import ebook.DAO.theloaiDAO;
import ebook.DAO.truyenDAO;
import ebook.entity.theloai;
import ebook.entity.truyen;

@Transactional
@Controller
public class AddtruyenController {
	@Autowired
	truyenDAO truyendao;
	@Autowired
	theloaiDAO theloaidao;
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "addtruyen" , method = RequestMethod.POST)
	public String Addtruyen(ModelMap model,@ModelAttribute("truyen")truyen truyen,HttpServletRequest request) {
		String id = request.getParameter("idtTheLoai");
		int idTheLoai = Integer.parseInt(id);
		truyen.setIdTheLoai(theloaidao.returnChiTietTheLoai(idTheLoai));
		System.out.println(truyen.getIdTruyen());
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(truyen);
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
	@RequestMapping(value = "addtruyen" , method = RequestMethod.GET)
	public String Addtruyen(ModelMap model) {
		truyen truyen = new truyen();
		model.addAttribute("truyen",truyen);
		model.addAttribute("categories", theloaidao.returnTheLoai());
		return "pages/addTruyen";
	}
	@RequestMapping(value = "updateTruyen/{idTruyen}", method = RequestMethod.GET)
	public String updateTruyen(ModelMap model, @PathVariable("idTruyen")int idTruyen) {
		Session session = factory.getCurrentSession();
		truyen truyen = (truyen)session.get(truyen.class,idTruyen);
		theloai idTheLoai = truyen.getIdTheLoai();
		model.addAttribute("categories", theloaidao.returnTheLoai());
		model.addAttribute("truyen", truyen);
		model.addAttribute("idTheLoai", idTheLoai);
		return "pages/addTruyen";
	}
	@RequestMapping(value = "deleteTruyen/{idTruyen}")
	public String deleteTruyen(ModelMap model,@PathVariable("idTruyen")int idTruyen) {
		Session session = factory.openSession();
		truyen truyen = (truyen)session.get(truyen.class,idTruyen);
		Transaction t = session.beginTransaction();
		try {
			session.delete(truyen);
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
	@RequestMapping("inserttruyen/{numPage}")
	public String Inserttruyen(ModelMap model,@PathVariable("numPage") int numPage) {
		
		model.addAttribute("num",truyendao.amountOfTruyens());
		model.addAttribute("numPage",numPage);
		model.addAttribute("truyens",truyendao.allTruyen(numPage));
		
		return "pages/insertTruyen";
	}
}
