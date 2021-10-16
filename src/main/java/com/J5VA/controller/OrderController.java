package com.J5VA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.ordersDao;

@Controller
@RequestMapping("/home")
public class OrderController {
	
	@Autowired
	ordersDao orderDetailDao;
	
	@GetMapping("/checkout")
	public String checkout() {
		return "home/checkout";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) {
		return "order/list";
	}
	
	@RequestMapping("/order/listorder")
	public String orderlist(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders",orderDetailDao.findByUsername(username));
		return "order/orderlist";
	}
	
	@RequestMapping("/checkout-detail/{id}")
	public String detail(@PathVariable("id")Integer id, Model model) {
		model.addAttribute("order", orderDetailDao.findById(id));
		return "home/checkout-details";
	}
}
