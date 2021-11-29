package com.J5VA.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.service.OrdersService;
import com.nimbusds.jose.shaded.json.JSONArray;

@RestController
@RequestMapping("/rest/data")
public class DataRestController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping("/chart")
	public List<Object> find() {
		JSONArray chart = new JSONArray();
		int revenue = 0;
		for (int i = 1; i < 13; i++) {
			revenue = revenue + 1;
			String total = String.valueOf(ordersService.findCarsAfterYear(revenue));
			total = total == "null" ? "0" : total;
			chart.add(total);
		}
		return chart;
	}
}