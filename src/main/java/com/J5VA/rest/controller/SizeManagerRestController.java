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

import com.J5VA.entity.Size;
import com.J5VA.service.SizeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/size")
public class SizeManagerRestController {
	@Autowired
	SizeService sizeService;
	
	@GetMapping()
	public List<Size> getAll() {
		return sizeService.findAll();
	}
	
	@GetMapping("{id}")
	public Size getOne(@PathVariable("id") Integer id) {
		return sizeService.findById(id); 
	}
	
	@PostMapping
	public Size create(@RequestBody Size size) {
		return sizeService.create(size);
	}
	@PutMapping("{id}")
	public Size update(@PathVariable("id") Integer id, @RequestBody Size size) {
		return sizeService.update(size);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		sizeService.delete(id);
	}
}
