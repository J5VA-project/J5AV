package com.J5VA.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.J5VA.entity.food;

public interface foodService {

	void delete(food entity);

	food findById(Integer id);

	food save(food entity);
	
	List<food> searchFood(String key);
	
	Page<food> listAll(int pageNumber);
	

}
