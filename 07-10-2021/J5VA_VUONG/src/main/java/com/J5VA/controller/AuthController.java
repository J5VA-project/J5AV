package com.J5VA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	
//	//den form dang nhap
//	@RequestMapping("/auth/login/form")
//	public String form() {
//		return "auth/login";
//	}
//	
//	@RequestMapping("/auth/login/success")
//	public String success(Model model) {
//		model.addAttribute("message", "Dang nhap thanh cong");
//		return "forward:/auth/login/form";
//	}
//
//	@RequestMapping("/auth/login/error")
//	public String error(Model model) {
//		model.addAttribute("message", "Sai thong tin dang nhap");
//		return "forward:/auth/login/form";
//	}
//	
//	@RequestMapping("/auth/logoff/success")
//	public String logoff(Model model) {
//		model.addAttribute("message", "Dang xuat thanh cong");
//		return "forward:/auth/login/form";
//	}
//
//	@RequestMapping("/auth/access/denied")
//	public String denied(Model model) {
//		model.addAttribute("message", "Ban khong co quyen truy xuat");
//		return "auth/login";
//	}
}
