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

import com.J5VA.entity.FoodCategory;
import com.J5VA.service.FoodCategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class CategoryRestController {
	@Autowired
	FoodCategoryService foodCategoryService;
	
	@GetMapping()
	public List<FoodCategory> getAll() {
		return foodCategoryService.findAll();
	}
	
	@GetMapping("{id}")
	public FoodCategory getOne(@PathVariable("id") Integer id) {
		return foodCategoryService.findById(id);
	}
	
	@PostMapping
	public FoodCategory create(@RequestBody FoodCategory FoodCategory) {
		return foodCategoryService.create(FoodCategory);
	}
	@PutMapping("{id}")
	public FoodCategory update(@PathVariable("id") Integer id, @RequestBody FoodCategory FoodCategory) {
		return foodCategoryService.update(FoodCategory);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		foodCategoryService.delete(id);
	}
}
