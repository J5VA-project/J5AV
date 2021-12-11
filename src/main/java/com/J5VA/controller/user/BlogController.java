package com.J5VA.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/blog")
public class BlogController {

	@GetMapping
	public String runControll() {
		return "user/body/blog";
	}
}
