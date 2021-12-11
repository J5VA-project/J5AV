package com.J5VA.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.J5VA.entity.Food;
import com.fasterxml.jackson.databind.JsonNode;

public interface FoodService {

	int count();

	Food findById(Integer id);

	Food save(Food entity);

	Page<Food> pageFood(Integer showPageNumber, String name, String key, Integer pageNumber);

	Page<Food> pageFoodCate(Integer showPageNumber, String cate, String name, String key, Integer pageNumber);

	Page<Food> pageFoodSize(Integer showPageNumber, String size, String name, String key, Integer pageNumber);

	Page<Food> pageFoodPrice(Integer showPageNumber, Double priceSt, Double priceEn, String name, String key,
			Integer pageNumber);

	List<Food> findAll();

	Food create(Food food);

	Food update(Food food);

	void delete(Integer id);

	Food insert(JsonNode orderData);
}
