package com.J5VA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.dao.accountDao;
import com.J5VA.dao.customerDao;
import com.J5VA.dao.foodDao;
import com.J5VA.dao.foodDetailDao;
import com.J5VA.entity.account;
import com.J5VA.entity.customer;
import com.J5VA.entity.food;
import com.J5VA.entity.foodDetail;
import com.J5VA.service.accountService;

@RestController
@RequestMapping("test/home")
public class testREST {
	
	@Autowired foodDetailDao dao;
	
//	@GetMapping("/{id}")
//	public List<foodDetail> getAll(@PathVariable("id")Integer id){
//		return dao.findByCateID(id);
//	}
}
