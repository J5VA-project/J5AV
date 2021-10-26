package com.J5VA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {
	@RequestMapping("/admin/login/form")
	public String adminLogin(Model model) {
		return"admin/account/page-login.html";
	}
}
