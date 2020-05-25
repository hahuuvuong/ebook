package ebook.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ebook.DAO.AccountDAO;
import ebook.DAO.theloaiDAO;
import ebook.DAO.truyenDAO;
import ebook.entity.Accounts;
import ebook.entity.truyen;

@Transactional
@Controller
public class favBookController {
	@Autowired
	AccountDAO accountdao;
	@Autowired
	truyenDAO truyendao;
	@Autowired
	theloaiDAO theloaidao;
	@Autowired
	SessionFactory factory;
	@RequestMapping("favbook/{idTruyen}")
	public String index(@PathVariable("idTruyen") int idTruyen,HttpSession session,ModelMap model) {
		String url = "redirect:/favbook.htm";
		try {
			String check = (String) session.getAttribute("username");
			check.isEmpty();
			Accounts acc = accountdao.returnRole(check);
			truyen truyen = truyendao.returnTruyen(idTruyen);
			
			acc.getTruyens().add(truyen);
			truyen.getAccounts().add(acc);
			
			accountdao.saveFavBook(acc, truyen);
			
			model.addAttribute("listFavBook",accountdao.returnFavBook(check));
			
			model.addAttribute("categories", theloaidao.returnTheLoai() );
		}
		catch(Exception e) {
			model.addAttribute("message","You need to log in!");
			url = "login";
		}
		return url;
	}
	@RequestMapping("favbook")
	public String index1(HttpSession session,ModelMap model) {
		String check = (String) session.getAttribute("username");
		
		
		model.addAttribute("listFavBook",accountdao.returnFavBook(check));
		
		model.addAttribute("categories", theloaidao.returnTheLoai() );
		return "favbook";
	}
	@RequestMapping("favbook/delete/{idTruyen}")
	public String delete(@PathVariable("idTruyen") int idTruyen,HttpSession session,ModelMap model) {
		String check = (String) session.getAttribute("username");
		accountdao.deleteFavBook(check, idTruyen);

		return "redirect:/favbook.htm";
	}
}
