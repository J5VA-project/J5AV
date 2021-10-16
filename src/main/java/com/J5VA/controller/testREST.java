package com.J5VA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.dao.foodDetailDao;

@RestController
@RequestMapping("test/home")
public class testREST {
	
	@Autowired foodDetailDao dao;
	
//	@GetMapping("/{id}")
//	public List<foodDetail> getAll(@PathVariable("id")Integer id){
//		return dao.findByCateID(id);
//	}
}
