package com.J5VA.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.accountDao;
import com.J5VA.dao.ordersDao;

@Controller
@RequestMapping("/home")
public class OrderController {
	
	@Autowired
	ordersDao orderDao;
	
	@Autowired
	accountDao accountDao;
	
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		return "home/checkout";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) {
		return "order/list";
	}
	
	@RequestMapping("/order/listorder")
	public String orderlist(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("order",orderDao.findByUsername(username));
		return "home/orderlist";
	}
	
	@RequestMapping("/checkout-detail/{username}")
	public String detail(@PathVariable("username")Integer id, Model model) {
		model.addAttribute("order", orderDao.findById(id).get());
		return "home/checkout-details";
	}
}
