package com.J5VA.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.customer;

import com.J5VA.service.UserService;

@Controller
public class LoginController {

	@GetMapping("/auth/login/form")
	public String login(Model model) {
		customer acc = new customer();
		model.addAttribute("acc", acc);
		return "home/login";
	}

	@RequestMapping("/auth/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Login success");
		model.addAttribute("user", new customer());
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logoff/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Logout success");
		model.addAttribute("acc", new customer());
		return "home/login";
	}
	@RequestMapping("/auth/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Wrong login information");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/access/denied")
	public String denied(Model model) {
		customer acc = new customer();
		model.addAttribute("acc", acc);
		model.addAttribute("message", "Ban khong co quyen truy xuat");
		return "/home/login";
	}
	
	@Autowired
	UserService userService;

	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		userService.loginFromOAuth2(oauth2);
		return "forward:/auth/login/success";
	}

}
