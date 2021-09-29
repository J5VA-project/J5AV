package com.J5VA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.dao.accountDao;
import com.J5VA.entity.account;

@RestController
@RequestMapping("/test")
public class LoginController {

	@Autowired accountDao dao;
	
	@GetMapping
	public List<account> getAll(){
		return dao.findAll();
	}
}
