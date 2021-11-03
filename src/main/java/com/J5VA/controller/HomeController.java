package com.J5VA.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.AccountDao;
import com.J5VA.dao.FoodDao;
import com.J5VA.entity.Account;
import com.J5VA.entity.Food;

@Controller
@RequestMapping("/home")
public class HomeController {
	
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
}
