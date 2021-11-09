package com.J5VA.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.customerDao;
import com.J5VA.dao.foodDao;
import com.J5VA.entity.customer;
import com.J5VA.entity.food;
=======
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.AccountDao;
import com.J5VA.dao.FoodDao;
import com.J5VA.entity.Account;
import com.J5VA.entity.Food;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

@Controller
@RequestMapping("/home")
public class HomeController {
	
<<<<<<< HEAD
	@Autowired foodDao fdao;
	@Autowired customerDao cdao;

	@GetMapping
	public String runControll(Model model) {
<<<<<<< HEAD
//		//find food
//		List<food> food = fdao.findAll();
//		model.addAttribute("foods", food);
//		//find customer
//		List<customer> cust = cdao.findAll();
//		model.addAttribute("custs", cust);
		return "/home/index";
=======
		//find food
		List<food> food = fdao.findAll();
		model.addAttribute("foods", food);
		//find customer
		List<customer> cust = cdao.findAll();
		model.addAttribute("custs", cust);
		return "home/index";
>>>>>>> 941b5a2e234fcec22271f03afd4f39d7e3868c25
	}
	
	
=======
	@Autowired FoodDao fdao;
	@Autowired AccountDao cdao;

	@GetMapping
	public String runControll(Model model) {
		//find food
		List<Food> food = fdao.findAll();
		model.addAttribute("foods", food);
		//find customer
		List<Account> cust = cdao.findAll();
		model.addAttribute("custs", cust);
		return "home/index";
	}
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
}
