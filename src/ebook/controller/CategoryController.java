package ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ebook.DAO.theloaiDAO;
import ebook.DAO.truyenDAO;

@Transactional
@Controller
public class CategoryController {
	@Autowired
	theloaiDAO theloaidao;
	@Autowired
	truyenDAO truyendao;
	@RequestMapping(value = "theloai/{idTheLoai}/{numPage}", method = RequestMethod.GET)
	public String category(@PathVariable("numPage")int numPage,@PathVariable("idTheLoai")int idTheLoai,  ModelMap model) {
		
		
		model.addAttribute("categories", theloaidao.returnTheLoai());
		model.addAttribute("truyens",truyendao.truyenTheLoai(idTheLoai, numPage));
		model.addAttribute("num", theloaidao.amountOfTruyen(idTheLoai));
		model.addAttribute("numPage",numPage);
		model.addAttribute("idTheLoai",idTheLoai);
		
		return "category";
	}
}
