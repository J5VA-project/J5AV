package com.J5VA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
	
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping("/home/cart")
	public String cart(Model model) {
		 String message = "Vui lòng đăng nhập trước khi mua hàng";
		 System.out.println(request.getRemoteUser());
		if(request.getRemoteUser() == null) {
			model.addAttribute("message",message);
			return "forward:/auth/login/form";
		}
		else {
			return "home/cart";
		}
	}
}
