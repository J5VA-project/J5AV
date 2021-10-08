package com.J5VA.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.J5VA.dao.foodCategoryDao;
import com.J5VA.dao.foodDao;
import com.J5VA.dao.sizeDao;
import com.J5VA.entity.food;
import com.J5VA.entity.foodCategory;
import com.J5VA.entity.size;


@Controller
@RequestMapping("/home")
public class ProductController {
	
	@Autowired foodDao fdao;
	@Autowired foodCategoryDao cdao;
	@Autowired sizeDao sdao;
	
	@GetMapping("/shop")
	public String runControll(Model model, @RequestParam("cid")Optional<String> cid, @RequestParam("sid")Optional<String> sid, @RequestParam("asc")Optional<String> asc) {
		//find food 
		if(cid.isPresent()) {
			List<food> food = fdao.findByCateID(cid.get());
			model.addAttribute("foods", food);
			//cate
			List<foodCategory> cates = cdao.findAll();
			model.addAttribute("cates", cates);
			//size
			List<size> size = sdao.findAll();
			model.addAttribute("sizes", size);
		}else if(sid.isPresent()) {
			List<food> sizef = fdao.findBySize(sid.get());
			model.addAttribute("foods", sizef);
			//cate
			List<foodCategory> cates = cdao.findAll();
			model.addAttribute("cates", cates);
			//size
			List<size> size = sdao.findAll();
			model.addAttribute("sizes", size);
		}else{
			//cate
			List<foodCategory> cates = cdao.findAll();
			model.addAttribute("cates", cates);
			//size
			List<size> size = sdao.findAll();
			model.addAttribute("sizes", size);
			//food
			List<food> food = fdao.findAll();
			model.addAttribute("foods", food);
		}
		return "/home/shop-slide";
	}
}
