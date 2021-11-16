package com.J5VA.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.entity.Food;
import com.J5VA.entity.FoodDetail;
import com.J5VA.entity.Orders;
import com.J5VA.service.FoodDetailService;
import com.J5VA.service.FoodService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/food-detail")
public class FoodDetailRestController {
	@Autowired
	FoodDetailService foodDetailService;
	
	@Autowired
	FoodService foodService;

	@GetMapping("/{id}")
	public FoodDetail getOne(@PathVariable("id") Integer id) {
		return foodDetailService.findById(id);
	}

	@PutMapping("/{id}")
	public FoodDetail update(@PathVariable("id") Integer id,@RequestBody JsonNode orderData) {
		return foodDetailService.update(orderData);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		foodDetailService.delete(id);
	}

	@GetMapping()
	public List<FoodDetail> getAll() {
		return foodDetailService.findAll();
	}
	
	@PostMapping
	public FoodDetail insert(@RequestBody JsonNode orderData) {
		return foodDetailService.insert(orderData);
	}
}
