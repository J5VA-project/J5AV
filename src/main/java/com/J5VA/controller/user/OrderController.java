package com.J5VA.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Orders;
import com.J5VA.service.AccountService;
import com.J5VA.service.OrdersService;

@Controller
@RequestMapping("/home")
public class OrderController {
	@Autowired
	OrdersService ordersService;

	@Autowired
	AccountService accountService;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/checkout")
	public String checkout() {
		return "user/body/checkout";
	}

	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) {
		return "user/body/list";
	}

	@RequestMapping("/order/listorder")
	public String orderlist(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", ordersService.findByUsername(username));
		return "user/body/orderlist";
	}

	@RequestMapping("/order-detail/{username}")
	public String detail(@PathVariable("username") Integer id, Model model) {
		model.addAttribute("order", ordersService.findById(id));
		return "user/body/checkout-details";
	}

	@RequestMapping("/order/update")
	public String orderUpdate(Model model) {
		Integer status = Integer.parseInt(request.getParameter("statusOrder"));
		Integer orderId = Integer.parseInt(request.getParameter("id"));

		System.out.println(status);
		System.out.println(orderId);

		Orders orders = ordersService.findById(orderId);
		orders.setStatus(status);
		ordersService.update(orders);
		return "redirect:/home/order/listorder";
	}
}
