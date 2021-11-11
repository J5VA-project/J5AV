package com.J5VA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.entity.account;
import com.J5VA.service.accountService;

@RestController
@RequestMapping("test/home")
public class testREST {
	
	@Autowired accountService dao;
	
	@GetMapping
	public List<account> getall(){
		return dao.findAll();
	}
}
