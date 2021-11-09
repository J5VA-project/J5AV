package com.J5VA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import com.J5VA.entity.food;
import com.J5VA.service.foodService;
=======
import com.J5VA.entity.Food;
import com.J5VA.service.FoodService;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

@Controller
@RequestMapping("/home")
public class DetailProductController {
	
<<<<<<< HEAD
	@Autowired foodService fdao;

	@GetMapping("/shop-details/{id}")
	public String runControll(@PathVariable("id") Integer id, Model model) {
		food food = fdao.findById(id);
=======
	@Autowired FoodService fdao;

	@GetMapping("/shop-details/{id}")
	public String runControll(@PathVariable("id") Integer id, Model model) {
		Food food = fdao.findById(id);
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
		model.addAttribute("food",food);
		return "/home/shop-details";
	}
}
