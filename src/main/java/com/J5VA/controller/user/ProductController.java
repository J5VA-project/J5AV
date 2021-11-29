package com.J5VA.controller.user;

import java.util.ArrayList;
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
import com.J5VA.entity.Account;
import com.J5VA.entity.Food;
import com.J5VA.entity.FoodCategory;
import com.J5VA.entity.Report;
import com.J5VA.entity.Size;
import com.J5VA.service.FoodCategoryService;
import com.J5VA.service.FoodService;
import com.J5VA.service.OrdersService;
import com.J5VA.service.SizeService;

@Controller
public class ProductController {
	@Autowired
	FoodService foodService;
	@Autowired
	FoodCategoryService foodCategoryService;
	@Autowired
	SizeService sizeService;
	@Autowired
	OrdersService service;


	@GetMapping(value = "/home/shop")
	public String listByPage(Model model,
			@RequestParam(name = "p", required = false, defaultValue = "1") Integer currentPage,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "sort", required = false, defaultValue = "asc") String sort,
			@RequestParam(name = "show", required = false, defaultValue = "6") Integer showPageNumber,
			@RequestParam(name = "cate", required = false) String cate,
			@RequestParam(name = "size", required = false) String size,
			@RequestParam(name = "priceSt", required = false) Double priceSt,
			@RequestParam(name = "priceEnd", required = false) Double priceEnd) {

		int count = foodService.count();

		Page<Food> page;

		if (cate != null && cate != "") {
			page = foodService.pageFoodCate(showPageNumber, cate, search, sort, currentPage);
		} else if (size != null && size != "") {
			page = foodService.pageFoodSize(showPageNumber, size, search, sort, currentPage);
		} else if (priceSt != null && priceEnd != null)
			page = foodService.pageFoodPrice(showPageNumber, priceSt, priceEnd, search, sort, currentPage);
		else
			page = foodService.pageFood(showPageNumber, search, sort, currentPage);

		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();

		List<Food> food = page.getContent();

		List<FoodCategory> listCate = foodCategoryService.findAll();
		model.addAttribute("listCate", listCate);

		List<Size> listSize = sizeService.findAll();

		model.addAttribute("search", search == null ? "" : search);
		model.addAttribute("sort", sort == null ? "" : sort);
		model.addAttribute("showPageNumber", showPageNumber == null ? "" : showPageNumber);
		model.addAttribute("cate", cate == null ? "" : cate);
		model.addAttribute("size", size == null ? "" : size);

		model.addAttribute("priceSt", priceSt == null ? "" : priceSt);
		model.addAttribute("priceEnd", priceEnd == null ? "" : priceEnd);

		model.addAttribute("listSize", listSize);
		// model.addAttribute("topFive", topFive);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("foods", food);
		model.addAttribute("count", count);
		
		List<Report> items = service.getInventoryByOrder();
		List<Report> top6 = new ArrayList<Report>();
		int i = 0;
		for (i = 0; i <= 5; i++) {
			top6.add(items.get(i));
		}
		model.addAttribute("top6", top6);

		return "user/body/shop-slide";
	}

}