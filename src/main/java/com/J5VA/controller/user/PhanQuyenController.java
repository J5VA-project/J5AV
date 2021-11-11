package com.J5VA.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhanQuyenController {
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/home/index")
	public String index(Model model) {
		model.addAttribute("message", "This is home page");
		return "user/body/index";
	}

//	@RequestMapping("/home/about")
//	public String about(Model model) {
//		model.addAttribute("message", "This is introduction page");
//		return "home/index";
//	}

//	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/home/admins")
	public String admins(Model model) {
		if (!request.isUserInRole("1")) {
			return "redirect:/auth/access/denied";
		}
		model.addAttribute("message", "Hello administrator");
		return "user/body/index";
	}

//	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping("/home/users")
	public String users(Model model) {
		if (!(request.isUserInRole("ADMIN") || request.isUserInRole("USER"))) {
			return "redirect:/auth/access/denied";
		}
		model.addAttribute("message", "Hello staff");
		return "user/body/index";
	}

//	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home/authenticated")
	public String authenticated(Model model) {
		if (request.getRemoteUser() == null) {
			return "redirect:/auth/login/form";
		}
		model.addAttribute("message", "Hello authenticated user");
		return "user/body/index";
	}
	
	@RequestMapping("/home/thymeleaf1")
	public String thymeleaf1(Model model) {
		model.addAttribute("message", "Thymeleaf - Without Extras");
		return "user/body/thymeleaf1";
	}
	
	@RequestMapping("/home/thymeleaf2")
	public String thymeleaf2(Model model) {
		model.addAttribute("message", "Thymeleaf - With Extras");
		return "user/body/thymeleaf2";
	}
}
