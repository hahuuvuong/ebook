package ebook.controller;

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
	public String searchFunction(ModelMap model, @RequestParam("searchText") String searchText) {
		
		model.addAttribute("categories", theloaidao.returnTheLoai());
		model.addAttribute("truyens",truyendao.searchingTruyen(searchText));
		model.addAttribute("num", 6);
		model.addAttribute("numPage",1);
		model.addAttribute("idTheLoai",2);
		
		
		return "category";
	}
}
