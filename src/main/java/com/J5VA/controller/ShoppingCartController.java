package com.J5VA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
	@RequestMapping("/home/cart")
	public String cart() {
		return "home/cart";
	}
}
