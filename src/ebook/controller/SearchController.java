package ebook.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ebook.DAO.theloaiDAO;
import ebook.DAO.truyenDAO;

@Transactional
@Controller
public class SearchController {
	@Autowired
	truyenDAO truyendao;
	@Autowired
	theloaiDAO theloaidao;
	@RequestMapping(value ="/search", method = RequestMethod.POST)
	public String searchFunction(ModelMap model, HttpServletRequest request,@RequestParam("searchText") String searchText) throws UnsupportedEncodingException {
	//	String searchText = new String(request.getParameter("searchText").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(searchText);
		
		model.addAttribute("categories", theloaidao.returnTheLoai());
		model.addAttribute("truyens",truyendao.searchingTruyen(searchText));
		
		model.addAttribute("search", searchText);
		return "search";
	}
}
