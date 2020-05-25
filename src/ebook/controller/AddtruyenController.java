package ebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ebook.DAO.AccountDAO;
import ebook.DAO.theloaiDAO;
import ebook.DAO.truyenDAO;
import ebook.entity.Accounts;
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
	AccountDAO accountdao;
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "addtruyen" , method = RequestMethod.POST)
	public String Addtruyen(ModelMap model,@Validated @ModelAttribute("truyen")truyen truyen, BindingResult errors,HttpServletRequest request) {
		String url = "redirect:/inserttruyen/1.htm";
		if(truyen.getTenTruyen().trim().length() == 0) {
			url = "pages/addTruyen";
			errors.rejectValue("tenTruyen","truyen","Vui lòng nhập Tên truyện !");
		}
		if(truyen.getTacGia().trim().length() == 0) {
			url = "pages/addTruyen";
			errors.rejectValue("tacGia","truyen","Vui lòng nhập tác giả !");
		}
		if(truyen.getImage().trim().length() == 0) {
			url = "pages/addTruyen";
			errors.rejectValue("image","truyen","Vui lòng nhập link image !");
		}
		if(request.getParameter("idtTheLoai").trim().length() == 0) {
			url = "pages/addTruyen";
			errors.rejectValue("idTheLoai","truyen","Vui lòng nhập thể loại !");
		}
		if(truyen.getTomTat().trim().length() == 0) {
			url = "pages/addTruyen";
			errors.rejectValue("tomTat","truyen","Vui lòng nhập tóm tắt !");
		}
		int idTheLoai = 1;
		String id = request.getParameter("idtTheLoai");
		if(id.equals("")) {
			
		}
		else {
		idTheLoai = Integer.parseInt(id);
		}
		truyen.setIdTheLoai(theloaidao.returnChiTietTheLoai(idTheLoai));
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(truyen);
			t.commit();
		}
		catch(Exception e) {
			url = "pages/addTruyen";
			t.rollback();
		}
		finally {
			session.close();
		}
		return url;
	}
	@RequestMapping(value = "addtruyen" , method = RequestMethod.GET)
	public String Addtruyen(ModelMap model,HttpSession session) {
		String url = "pages/addTruyen";
		try {
			
			String check = (String) session.getAttribute("username");
			check.isEmpty();
			Accounts x = accountdao.returnRole(check);
			if(x.isRole() != true)
				url = "403page" ;
		}
		catch(Exception e) {
			url = "403page";
		}
		
		truyen truyen = new truyen();
		model.addAttribute("truyen",truyen);
		model.addAttribute("categories", theloaidao.returnTheLoai());
		return url;
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
