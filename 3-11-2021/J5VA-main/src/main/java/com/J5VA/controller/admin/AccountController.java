package com.J5VA.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Account;

@Controller
@RequestMapping("/admin/login")
public class AccountController {
	@RequestMapping("/index")
	public String form(Model model) {
		Account acc = new Account();
		model.addAttribute("acc", acc);
		return "admin/account/page-login.html";
	}
	
}