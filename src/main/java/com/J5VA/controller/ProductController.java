package com.J5VA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.J5VA.service.foodService;


@Controller
public class ProductController {

	@Autowired
	foodDao fdao;
	@Autowired
	foodCategoryDao cdao;
	@Autowired
	sizeDao sdao;
	@Autowired
	foodService service;

	@GetMapping("/home/shop")
	public String listByPage(Model model, 
			@RequestParam(name="page", required=false, defaultValue = "1") Integer currentPage,
			@RequestParam(name="search", required=false) String search) {
		
		Page<food> page = service.searchFood(currentPage, search);
		
		// su dung long vi page.getTotalElements() khong chap nhan kieu int
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		int count = service.count();
		
		List<food> food = page.getContent();
		
			
		List<foodCategory> cates = cdao.findAll();
		model.addAttribute("cates", cates);
		// size
		List<size> size = sdao.findAll();
		model.addAttribute("sizes", size);
		
		// List<food> food = fdao.findAll();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("foods", food);
		model.addAttribute("search", search == null ? "" : search);
		model.addAttribute("count", count);
		
		return "/home/shop-slide";
	}

	@RequestMapping("/home/shop/search")
	public String search(Model model, @RequestParam("name") String name) {

		List<food> food = fdao.searchFood("%" + name + "%");
		System.out.println(name);
		model.addAttribute("foods", food);
		List<foodCategory> cates = cdao.findAll();
		model.addAttribute("cates", cates);
		List<size> size = sdao.findAll();
		model.addAttribute("sizes", size);

		return "/home/shop-slide";
	}

	@RequestMapping("/home/shop/low-price")
	public String lowPrice(Model model) {

		List<food> food = fdao.foodLowPrice();
		model.addAttribute("foods", food);
		List<foodCategory> cates = cdao.findAll();
		model.addAttribute("cates", cates);
		List<size> size = sdao.findAll();
		model.addAttribute("sizes", size);

		return "/home/shop-slide";
	}

	@RequestMapping("/home/shop/high-price")
	public String highPrice(Model model) {

		List<food> food = fdao.foodHighPrice();
		model.addAttribute("foods", food);
		List<foodCategory> cates = cdao.findAll();
		model.addAttribute("cates", cates);
		List<size> size = sdao.findAll();
		model.addAttribute("sizes", size);

		return "/home/shop-slide";
	}

	
}
