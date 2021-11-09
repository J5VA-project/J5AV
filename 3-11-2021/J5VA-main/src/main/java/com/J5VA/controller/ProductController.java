package com.J5VA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.J5VA.dao.FoodCategoryDao;
import com.J5VA.dao.FoodDao;
import com.J5VA.dao.SizeDao;
import com.J5VA.entity.Food;
import com.J5VA.entity.FoodCategory;
import com.J5VA.entity.Size;
import com.J5VA.service.FoodService;

@Controller
public class ProductController {

	@Autowired
	FoodDao fdao;
	@Autowired
	FoodCategoryDao cdao;
	@Autowired
	SizeDao sdao;
	@Autowired
	FoodService service;

	@GetMapping(value = "/home/shop")
	public String listByPage(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") Integer currentPage,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "key", required = false, defaultValue = "ASC") String sort,
			@RequestParam(name = "showPageNumber", required = false, defaultValue = "6") Integer showPageNumber
			//@RequestParam(name = "cate", required = false) String cate
			){
		
		int count = service.count();
		
		Page<Food> page;
		
//		if(cate != null) {
//			page = service.pageFoodCate(showPageNumber, cate ,search, sort, currentPage);
//		} else {
			page = service.pageFood(showPageNumber ,search, sort, currentPage);
//		}
		
		

		
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();

		List<Food> food = page.getContent();

		List<FoodCategory> listCate = cdao.findAll();
		model.addAttribute("listCate", listCate);

		List<Size> listSize = sdao.findAll();
		
		model.addAttribute("search", search == null ? "" : search);
		model.addAttribute("sort", sort == null ? "" : sort);
		model.addAttribute("showPageNumber", showPageNumber == null ? "" : showPageNumber);
		//model.addAttribute("cate", cate == null ? "" : cate);
		
//		model.addAttribute("size", size == null ? "" : size);
		model.addAttribute("listSize", listSize);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("foods", food);
		model.addAttribute("count", count);


		return "/home/shop-slide";
	}


}