package com.J5VA.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.account;

@Controller

public class AccountController {
	@RequestMapping("/admin/login")
	public String form() {
//		account acc = new account();
//		model.addAttribute("acc", acc);
		return "admin/account/page-login.html";
	}
}
