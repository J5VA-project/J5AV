package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.FoodCategory;

public interface FoodCategoryService {

	List<FoodCategory> findAll();

	FoodCategory findById(Integer id);

	FoodCategory create(FoodCategory foodCategory);

	FoodCategory update(FoodCategory foodCategory);

	void delete(Integer id);


}
