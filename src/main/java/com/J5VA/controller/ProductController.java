package com.J5VA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 941b5a2e234fcec22271f03afd4f39d7e3868c25
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
@RequestMapping("/home")
public class ProductController {
<<<<<<< HEAD

	@Autowired
	foodDao fdao;
	@Autowired
	foodCategoryDao cdao;
	@Autowired
	sizeDao sdao;
	@Autowired
	foodService service;

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

	@RequestMapping("/home/shop")
	public String runControll(Model model, @RequestParam("cid") Optional<String> cid,
			@RequestParam("sid") Optional<String> sid) {
		// find food
		if (cid.isPresent()) {
=======
	
	@Autowired foodDao fdao;
	@Autowired foodCategoryDao cdao;
	@Autowired sizeDao sdao;
	
	@GetMapping("/shop")
	public String runControll(Model model, @RequestParam("cid")Optional<String> cid, @RequestParam("sid")Optional<String> sid, @RequestParam("asc")Optional<String> asc) {
		//find food 
		if(cid.isPresent()) {
>>>>>>> 941b5a2e234fcec22271f03afd4f39d7e3868c25
			List<food> food = fdao.findByCateID(cid.get());
			model.addAttribute("foods", food);
			// cate
			List<foodCategory> cates = cdao.findAll();
			model.addAttribute("cates", cates);
			// size
			List<size> size = sdao.findAll();
			model.addAttribute("sizes", size);
		} else if (sid.isPresent()) {
			List<food> sizef = fdao.findBySize(sid.get());
			model.addAttribute("foods", sizef);
			// cate
			List<foodCategory> cates = cdao.findAll();
			model.addAttribute("cates", cates);
			// size
			List<size> size = sdao.findAll();
			model.addAttribute("sizes", size);
		} else {
			// cate
			List<foodCategory> cates = cdao.findAll();
			model.addAttribute("cates", cates);
			// size
			List<size> size = sdao.findAll();
			model.addAttribute("sizes", size);
			// food

			// -----------------------------------

		}
		return listByPage(model, 1);
	}

	@GetMapping("/home/shop/{pageNumber}")
	public String listByPage(Model model, @PathVariable("pageNumber") int currentPage) {
		
		Page<food> page = service.listAll(currentPage);
		
		// su dung long vi page.getTotalElements() khong chap nhan kieu int
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();

		List<food> food = page.getContent();

		// List<food> food = fdao.findAll();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("foods", food);
		
		return "/home/shop-slide";
	}
}
