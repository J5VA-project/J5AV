package com.J5VA.controller.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceDetailController {
	

@RequestMapping("/home/service-details")
	public String runControll(Model model) {
		return "user/body/service-details";
	}
}
