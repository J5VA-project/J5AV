package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.Account;

public interface AccountService {
	Account findById(String username);

	List<Account> findAll();

	Account create(Account account);

	Account update(Account account);

	void delete(String username);

	Integer findByAge(Integer age);

	List<Integer> listAge();

	Account findByUsername(String username);

	List<Account> getMostBuy(Integer month, Integer year);

	boolean checkByUsername(String username);

	Account findByEmail(String email);

	boolean checkByEmail(String email);
}
