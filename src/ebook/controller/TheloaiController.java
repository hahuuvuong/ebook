package ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ebook.DAO.theloaiDAO;

@Transactional
@Controller
public class TheloaiController {
	@Autowired
	theloaiDAO theloaidao;
	@RequestMapping("dashboard/theloai")
	public String returnTheLoai(ModelMap model) {
		model.addAttribute("categories", theloaidao.returnTheLoai());
		return "pages/theloai";
	}
}
