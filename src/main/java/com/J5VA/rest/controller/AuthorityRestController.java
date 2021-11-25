package com.J5VA.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.dao.AuthorizedDao;
import com.J5VA.entity.Authorized;
import com.J5VA.service.AccountService;
import com.J5VA.service.RoleService;

@CrossOrigin("*")
@RestController
public class AuthorityRestController {
	@Autowired
	AuthorizedDao authorityDao;

	@Autowired
	RoleService roleService;

	@Autowired
	AccountService accountService;

	@GetMapping("/rest/authorities")
	public Map<String, Object> getAuthorities() {
		Map<String, Object> data = new HashMap<>();
		data.put("authorities", authorityDao.findAll());
		data.put("roles", roleService.findAll());
		data.put("accounts", accountService.findAll());
		return data;
	}

	@PostMapping("/rest/authorities")
	public Authorized create(@RequestBody Authorized authority) {
		return authorityDao.save(authority);
	}

	@DeleteMapping("/rest/authorities/{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityDao.deleteById(id);
	}
	
}
