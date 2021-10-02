package com.J5VA.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResiterController {
	

@RequestMapping("/home/register")
	public String runControll(Model model) {
		return "/home/register";
	}
}
