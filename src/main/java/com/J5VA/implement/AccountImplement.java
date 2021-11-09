package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.AccountDao;
import com.J5VA.entity.Account;
import com.J5VA.service.AccountService;

@Service
public class AccountImplement implements AccountService {
	@Autowired
	AccountDao dao;

	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}

	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username).get();
	}

	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		dao.deleteById(username);
	}

}
