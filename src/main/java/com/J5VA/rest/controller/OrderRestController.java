package com.J5VA.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import com.J5VA.entity.Orders;
import com.J5VA.service.OrdersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	
	@Autowired
	OrdersService ordersService;
	
	@PostMapping
	public Orders create(@RequestBody JsonNode orderData) {
		return ordersService.create(orderData);
	}

	@GetMapping("/{id}")
	public Orders getOne(@PathVariable("id") Integer id) {
		return ordersService.findById(id);
	}

	@PatchMapping("{id}")
	public Orders update(@PathVariable("id") Integer id, @RequestBody Orders order) {
		return ordersService.update(order);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		ordersService.delete(id);
	}

	@GetMapping()
	public List<Orders> getAll() {
		return ordersService.findAll();
	}
	
	@GetMapping("/status/{status}")
	public List<Orders> findAllOrdersByStatus(@PathVariable("status") Integer status){
		return ordersService.findAllByStatus(status);
	}
	
	@GetMapping("/total-order")
	public Integer total() {
		return ordersService.totalOrders();
	}
	@GetMapping("/total-status/{status}")
	public Integer totalOrdersByStatus(@PathVariable("status") Integer status) {
		return ordersService.totalOrdersByStatus(status);
	}
	
}
