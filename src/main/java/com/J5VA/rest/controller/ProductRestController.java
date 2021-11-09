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
import com.J5VA.service.FoodService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/food")
public class ProductRestController {
	@Autowired
	FoodService productService;

	@GetMapping("/{id}")
	public Food getOne(@PathVariable("id") Integer id) {
		return productService.findById(id);
	}

	@PostMapping()
	public Food create(@RequestBody Food product) {
		return productService.create(product);
	}

	@PutMapping("{id}")
	public Food update(@PathVariable("id") Integer id, @RequestBody Food product) {
		return productService.update(product);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}

	@GetMapping()
	public List<Food> getAll() {
		return productService.findAll();
	}
}
