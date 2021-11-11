package com.J5VA.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Food;
import com.J5VA.service.FoodService;

@Controller
@RequestMapping("/home")
public class DetailProductController {
	
	@Autowired FoodService fdao;

	@GetMapping("/shop-details/{id}")
	public String runControll(@PathVariable("id") Integer id, Model model) {
		Food food = fdao.findById(id);
		model.addAttribute("food",food);
		return "user/body/shop-details";
	}
}
