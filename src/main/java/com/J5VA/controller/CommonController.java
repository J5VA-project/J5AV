package com.J5VA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping("/home/chef")
	public String chef() {
		return "home/chef";
	}
	
	@RequestMapping("/home/faq")
	public String faq() {
		return "home/faq";
	}
	
	@RequestMapping("/home/wishlist")
	public String wishlist() {
		return "home/wishlist";
	}
	
	@RequestMapping("/home/about")
	public String about() {
		return "home/about";
	}
}
