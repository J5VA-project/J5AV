package com.J5VA.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping("/home/chef")
	public String chef() {
		return "user/body/chef";
	}
	
	@RequestMapping("/home/faq")
	public String faq() {
		return "user/body/faq";
	}
	
	@RequestMapping("/home/wishlist")
	public String wishlist() {
		return "user/body/wishlist";
	}
	
	@RequestMapping("/home/about")
	public String about() {
		return "user/body/about";
	}
}
