package com.J5VA.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.account;
import com.J5VA.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	HttpServletRequest request;

	@GetMapping("/auth/login/form")
	public String login(Model model) {
		account acc = new account();
		model.addAttribute("acc", acc);
		return "home/login";
	}

	@RequestMapping("/auth/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Login success");
<<<<<<< HEAD
		model.addAttribute("user", new customer());
		HttpSession session = request.getSession(true);
		session.setAttribute("AccountId", request.getRemoteUser());
=======
		model.addAttribute("user", new account());
>>>>>>> 112a50db07548bdc29581a2d709173f6935ffc6f
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logoff/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Logout success");
		model.addAttribute("acc", new account());
		return "home/login";
	}
	@RequestMapping("/auth/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Wrong login information");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/access/denied")
	public String denied(Model model) {
		account acc = new account();
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
