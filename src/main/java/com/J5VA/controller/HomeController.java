package com.J5VA.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.customerDao;
import com.J5VA.dao.foodDao;
import com.J5VA.entity.customer;
import com.J5VA.entity.food;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired foodDao fdao;
	@Autowired customerDao cdao;

	@GetMapping
	public String runControll(Model model) {
		//find food
		List<food> food = fdao.findAll();
		model.addAttribute("foods", food);
		//find customer
		List<customer> cust = cdao.findAll();
		model.addAttribute("custs", cust);
		return "/home/index";
	}
	
	
}
