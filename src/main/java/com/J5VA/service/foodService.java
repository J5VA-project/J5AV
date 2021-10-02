package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.food;

public interface foodService {

	void delete(food entity);

	food findById(Integer id);

	List<food> findAll();

	food save(food entity);

}
