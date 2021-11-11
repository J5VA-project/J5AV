package com.J5VA.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceController {
	@RequestMapping("/home/service")
	public String runControll(Model model) {
		return "user/body/services";
	}
}
