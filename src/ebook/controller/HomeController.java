package ebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ebook.DAO.theloaiDAO;
import ebook.DAO.truyenDAO;
import ebook.entity.truyen;

@Transactional
@Controller
public class HomeController {
	@Autowired
	truyenDAO truyendao;
	@Autowired
	theloaiDAO theloaidao;
	@RequestMapping("/home")
	public String index(ModelMap model) 
	{	
		List<truyen> list = new ArrayList<truyen>();
		list.add(truyendao.returnTruyen(94));
		list.add(truyendao.returnTruyen(25));
		list.add(truyendao.returnTruyen(364));
		list.add(truyendao.returnTruyen(334));
		list.add(truyendao.returnTruyen(4));
		list.add(truyendao.returnTruyen(35));
		list.add(truyendao.returnTruyen(77));
		
		model.addAttribute("tieuthuyet", truyendao.truyenTheoTheLoai(23));
		model.addAttribute("kinhte", truyendao.truyenTheoTheLoai(2));
		model.addAttribute("tamly", truyendao.truyenTheoTheLoai(14));
		model.addAttribute("giatuong", truyendao.truyenTheoTheLoai(24));
		model.addAttribute("trinhtham", truyendao.truyenTheoTheLoai(12));
		
		
		model.addAttribute("truyenHot",list );
		model.addAttribute("truyenRandom",truyendao.randomTruyen(8) );
		
		
		model.addAttribute("categories", theloaidao.returnTheLoai() );
		
	
	return "index";
	}

}
