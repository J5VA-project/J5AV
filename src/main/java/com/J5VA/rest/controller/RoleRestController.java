package com.J5VA.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.entity.Role;
import com.J5VA.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/role")
public class RoleRestController {
	@Autowired
	RoleService service;

	@GetMapping()
	public List<Role> findAll() {
		return service.findAll();
	}
}
