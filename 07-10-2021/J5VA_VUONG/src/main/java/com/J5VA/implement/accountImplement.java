package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.accountDao;
import com.J5VA.entity.account;
import com.J5VA.service.accountService;

@Service
public class accountImplement implements accountService {
	@Autowired
	accountDao dao;

	@Override
	public List<account> findAll() {
		return dao.findAll();
	}

	@Override
	public account findById(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username).get();
	}

	@Override
	public account create(account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public account update(account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		dao.deleteById(username);
	}

}
