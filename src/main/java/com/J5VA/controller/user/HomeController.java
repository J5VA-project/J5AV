package com.J5VA.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Account;
import com.J5VA.entity.Report;
import com.J5VA.service.AccountService;
import com.J5VA.service.OrdersService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	AccountService accService;
	@Autowired
	OrdersService service;

	@GetMapping
	public String runControll(Model model) {
		List<Report> items = service.getInventoryByOrder();
		List<Report> top6 = new ArrayList<Report>();
		int i = 0;
		for (i = 0; i <= 5; i++) {
			top6.add(items.get(i));
		}
		
		model.addAttribute("foods", top6);

		List<Account> cust = accService.findAll();
		model.addAttribute("custs", cust);
		return "user/body/index";
	}
}
