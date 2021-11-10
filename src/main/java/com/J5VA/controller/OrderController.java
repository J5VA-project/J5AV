package com.J5VA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.AccountDao;
import com.J5VA.dao.OrdersDao;
import com.J5VA.entity.Orders;
import com.J5VA.service.OrdersService;

@Controller
@RequestMapping("/home")
public class OrderController {
	
	@Autowired
	OrdersDao orderDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	OrdersService service;
	
	
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
		model.addAttribute("orders",orderDao.findByUsername(username));
		return "home/orderlist";
	}
	
	@RequestMapping("/order-detail/{username}")
	public String detail(@PathVariable("username")Integer id, Model model) {
		model.addAttribute("order", orderDao.findById(id).get());
		return "home/checkout-details";
	}
	@RequestMapping("/order/update")
	public String orderUpdate(Model model) {
		Integer status = Integer.parseInt(request.getParameter("statusOrder"));
		Integer orderId = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(status);
		System.out.println(orderId);
		
		Orders orders = service.findById(orderId);
		orders.setStatus(status);
		service.update(orders);
		return "redirect:/home/order/listorder";
	}
}
