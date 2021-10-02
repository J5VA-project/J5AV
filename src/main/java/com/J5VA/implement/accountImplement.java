package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.accountDao;
import com.J5VA.entity.account;
import com.J5VA.service.accountService;

@Service
public class accountImplement implements accountService{
	
	
	@Autowired accountDao dao;

	@Override
	public List<account> findAll() {
		return dao.findAll();
	}
	
	
}
