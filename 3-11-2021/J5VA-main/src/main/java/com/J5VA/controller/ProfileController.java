package com.J5VA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.J5VA.entity.Account;
import com.J5VA.service.AccountService;

@Controller
public class ProfileController {
	@Autowired
	HttpServletRequest request;

	@Autowired
	AccountService service;
	
	@GetMapping("/home/profile")
	public String profile(Model model) {
		Account acc = service.findById(request.getRemoteUser());
		model.addAttribute("acc", acc);
		return "home/profile";
	}
}
