package com.J5VA.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.entity.OrderDetail;
import com.J5VA.service.OrderDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderDetail")
public class OrderDetailRestController {
	@Autowired
	OrderDetailService service;

	@GetMapping
	public List<OrderDetail> getAll() {
		return service.list();
	}
	
	@GetMapping("/{orderID}")
	public List<OrderDetail> findAllOrdersByStatus(@PathVariable("orderID") Integer orderID) {
		return service.findByOrderId(orderID);
	}
}
