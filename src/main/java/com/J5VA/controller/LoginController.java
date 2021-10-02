package com.J5VA.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.dao.customerDao;
import com.J5VA.entity.customer;


@RestController
@RequestMapping("/test")
public class LoginController {
	
	@Autowired customerDao dao;
	
	@GetMapping
	public List<customer> getAll(){
		return dao.findAll();
	}

}
