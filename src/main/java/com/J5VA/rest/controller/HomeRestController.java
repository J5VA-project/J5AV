package com.J5VA.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeRestController {
	
	@RequestMapping("admin")
	public String admin() {
		return "redirect:/admin/main/index.html";
	}
}
