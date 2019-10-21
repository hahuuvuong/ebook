package ebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ebook.DAO.AccountDAO;
import ebook.entity.Accounts;

@Transactional
@Controller
public class DashboardController {
	@Autowired
	AccountDAO accountdao;
	@RequestMapping("/dashboard")
	public String Dashboard(ModelMap model,HttpSession session) {
		String url = "dashboard";
		try {
			
			String check = (String) session.getAttribute("username");
			check.isEmpty();
			Accounts x = accountdao.returnRole(check);

			if(x.isRole() != true)
				url = "403page" ;
		}
		catch(Exception e) {
			url = "403page";
			System.out.println(e.getMessage());
		}
		return url;
	}
}
