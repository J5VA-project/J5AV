package com.J5VA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping(value = "/home/shop")
	public String listByPage(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") Integer currentPage,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(defaultValue = "ASC", name = "key", required = false) String sort,
			@RequestParam(defaultValue = "1", name = "show", required = false) String showPage) {
		
		int count = service.count();
		Page<food> page = service.pageFood(showPage ,search, sort, currentPage);
		
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();

		List<food> food = page.getContent();

		List<foodCategory> cates = cdao.findAll();
		model.addAttribute("cates", cates);

		List<size> size = sdao.findAll();
		
		model.addAttribute("search", search == null ? "" : search);
		model.addAttribute("sort", sort == null ? "" : sort);
		model.addAttribute("showPage", showPage == null ? "" : showPage);
		
		model.addAttribute("sizes", size);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("foods", food);
		model.addAttribute("count", count);


		return "/home/shop-slide";
	}

}
