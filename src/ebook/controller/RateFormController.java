package ebook.controller;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;

import ebook.DAO.theloaiDAO;
import ebook.entity.Accounts;
import ebook.entity.RateAssessment;
import ebook.entity.truyen;
@Transactional
@Controller
public class RateFormController {
	@Autowired
	theloaiDAO theloaidao;
	
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "rateform", method = RequestMethod.GET)
	public String getRateFrom(ModelMap model) {
		model.addAttribute("categories", theloaidao.returnTheLoai());
		
		return "RateFormSuccess";
	}
	
	@RequestMapping(value = "rateform/{idTruyen}", method = RequestMethod.POST)
	public String postRateForm(ModelMap model,@RequestParam("rating") String rateScore,@ModelAttribute("RateAssessment") RateAssessment rateAssessment,@PathVariable("idTruyen") int idTruyen,HttpSession sessionHttp) {
		Session session = factory.openSession();
		String userName = (String)sessionHttp.getAttribute("username");
		
		rateAssessment.setRateScore(Integer.parseInt(rateScore));
		
		truyen truyen = (truyen)session.get(truyen.class,idTruyen);
		rateAssessment.setIdTruyen(truyen);
		
		Accounts user = (Accounts)session.get(Accounts.class,userName);
		rateAssessment.setUsername(user);
		
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(rateAssessment);
			t.commit();
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			t.rollback();
		}
		finally {
			session.close();
		}
		
		return "rateForm";
	}

}
