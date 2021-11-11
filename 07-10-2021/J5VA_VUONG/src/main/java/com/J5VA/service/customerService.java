package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.customer;

public interface customerService {

	customer findById(String username_custo);

	List<customer> findAll();

	customer create(customer custo);

	customer update(customer custo);

	void delete(String username_custo);

}
