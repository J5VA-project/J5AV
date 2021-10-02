package com.J5VA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.food;
import com.J5VA.service.foodService;

@Controller
@RequestMapping("/home")
public class DetailProductController {
	
	@Autowired foodService fdao;

	@GetMapping("/shop-details/{id}")
	public String runControll(@PathVariable("id") Integer id, Model model) {
		food food = fdao.findById(id);
		model.addAttribute("food",food);
		return "/home/shop-details";
	}
}
