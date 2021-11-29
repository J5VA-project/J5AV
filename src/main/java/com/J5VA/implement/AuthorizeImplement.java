package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.AuthorizedDao;
import com.J5VA.entity.Authorized;
import com.J5VA.service.AuthorizedService;

@Service
public class AuthorizeImplement implements AuthorizedService {
	@Autowired
	AuthorizedDao dao;

	@Override
	public List<Authorized> findAll() {
		return dao.findAll();
	}

}
