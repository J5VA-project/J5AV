package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.account;

public interface accountService {
	account findById(String username);

	List<account> findAll();

	account create(account account);

	account update(account account);

	void delete(String username);

}
