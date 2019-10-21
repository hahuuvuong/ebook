package ebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ebook.DAO.AccountDAO;
import ebook.entity.Accounts;

@Controller
@RequestMapping(value = "account")
public class LoginController {
	@Autowired
	AccountDAO accountdao;
	@Autowired
	SessionFactory factory;
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session,ModelMap modelMap) {
		
		if(accountdao.checkUsername(username,password)) {
			session.setAttribute("nickname", accountdao.returnNickname(username));
			session.setAttribute("username", username);
			return "redirect:/home.htm";
		} else {
			modelMap.put("error", "Incorrect Username or Password");
			return "login";
		}
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("nickname");
		return "redirect:/home.htm";
	}
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		
		model.addAttribute("account",new Accounts());
		return "register";
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(ModelMap model, @ModelAttribute("account")Accounts account,HttpServletRequest request)
	{
		String repass = request.getParameter("repass");
		if(repass.equals(account.getPassword())) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(account);
				t.commit();
			}
			catch(Exception e) {
				model.put("error", e.getMessage());
				t.rollback();
			}
			finally {
			session.close();
			}
		}
			else {
				model.put("error","Repass incorrect");
				return "register";
			}
		return "redirect:/home.htm";
	}

	@RequestMapping(value ="403")
	public String pageAccessDenied() {
		return "403page";
	}
}
