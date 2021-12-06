package com.J5VA.rest.controller;

import java.util.ArrayList;
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

import com.J5VA.entity.Account;
import com.J5VA.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService service;

	@GetMapping("/age")
	public List<Integer> getAllAge() {
		List<Integer> age = service.listAge();
		List<Integer> list = new ArrayList<Integer>();
		for (Integer a : age) {
			Integer sl = service.findByAge(a);
			list.add(sl);
		}
		return list;
	}
	
	@GetMapping("/mostBuy") 
	public List<Account> getMostBuy(Integer month, Integer year){
		List<Account> accounts = service.getMostBuy(month, year);
		return accounts;
	}

	@GetMapping("/list")
	public List<Integer> getList() {
		return service.listAge();
	}

	@GetMapping()
	public List<Account> getAll() {
		return service.findAll();
	}

	@GetMapping("/{username}")
	public Account getOne(@PathVariable("username") String username) {
		return service.findById(username);
	}

	@PostMapping
	public Account create(@RequestBody Account account) {
		return service.create(account);
	}

	@PutMapping("/{username}")
	public Account update(@PathVariable("username") String username, @RequestBody Account account) {
		return service.update(account);
	}

	@DeleteMapping("/{username}")
	public void delete(@PathVariable("username") String username) {
		service.delete(username);
	}
}
