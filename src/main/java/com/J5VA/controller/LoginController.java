package com.J5VA.controller;

<<<<<<< HEAD
import javax.validation.Valid;
=======
import java.util.List;

import javax.servlet.http.HttpServletRequest;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
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
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Account;
import com.J5VA.entity.Authorized;
import com.J5VA.service.UserService;
import com.J5VA.service.AccountService;

@Controller
public class LoginController {
	@Autowired
	HttpServletRequest request;

	@Autowired
	AccountService service;
	
	@GetMapping("/auth/login/form")
	public String login(Model model) {
		Account acc = new Account();
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
		model.addAttribute("acc", acc);
		return "home/login";
	}

	@RequestMapping("/auth/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Login success");
<<<<<<< HEAD
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Wrong login information");
=======
		model.addAttribute("user", new Account());
		
		Account account = service.findById(request.getRemoteUser());
		List<Authorized> authorizeds = account.getAuthorities();
		for(Authorized p:authorizeds) {
			if(p.getRole().getRole_name().equals("Manager")) {
				return "forward:/admin/index";
			}
		}
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logoff/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Logout success");
		model.addAttribute("acc", new Account());
		return "home/login";
	}
	@RequestMapping("/auth/login/error")
	public String error(Model model) {
		model.addAttribute("error", "Username or Password entered wrong!");
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/access/denied")
	public String denied(Model model) {
<<<<<<< HEAD
		customer acc = new customer();
		model.addAttribute("acc", acc);
		model.addAttribute("message", "Ban khong co quyen truy xuat");
		return "/home/login";
=======
		Account acc = new Account();
		model.addAttribute("acc", acc);
		model.addAttribute("error", "Ban khong co quyen truy xuat");
		return "/home/404";
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
	}
	
	@Autowired
	UserService userService;

	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		userService.loginFromOAuth2(oauth2);
		return "forward:/auth/login/success";
	}

}
