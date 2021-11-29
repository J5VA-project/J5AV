package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.RoleDao;
import com.J5VA.entity.Role;
import com.J5VA.service.RoleService;

@Service
public class RoleImplement implements RoleService {
	@Autowired
	RoleDao dao;

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

}
