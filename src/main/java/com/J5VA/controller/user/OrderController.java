package com.J5VA.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String orderlist(Model model, HttpServletRequest request,
			@RequestParam(name = "p", required = false, defaultValue = "1") Integer currentPage,
			@RequestParam(name = "show", required = false, defaultValue = "6") Integer show,
			@RequestParam(name = "sort", required = false, defaultValue = "desc") String sort) {
		String username = request.getRemoteUser();
		Page<Orders> page = ordersService.findByUsername(username, currentPage, show, sort);
		List<Orders> orders = page.getContent();
		int totalPages = page.getTotalPages();
		model.addAttribute("orders", orders);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("sort", sort == null ? "" : sort);
		model.addAttribute("show", show == null ? "" : show);
		model.addAttribute("count",ordersService.countOrder(username));
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
