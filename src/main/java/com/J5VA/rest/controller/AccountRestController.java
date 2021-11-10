package com.J5VA.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService service;

	@GetMapping
	public List<Integer> getAll() {
		List<Integer> age = service.listAge();
		List<Integer> list = new ArrayList<Integer>();
		for (Integer a : age) {
			Integer sl = service.findByAge(a);
			list.add(sl);
		}
		return list;
	}

	@GetMapping("/list")
	public List<Integer> getList() {
		return service.listAge();
	}
}
