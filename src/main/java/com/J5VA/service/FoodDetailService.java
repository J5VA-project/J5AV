package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.FoodDetail;
import com.fasterxml.jackson.databind.JsonNode;

public interface FoodDetailService {

	FoodDetail findById(Integer id);

	FoodDetail create(FoodDetail foodDetail);

	FoodDetail update(JsonNode orderData);

	void delete(Integer id);

	List<FoodDetail> findAll();
	
	FoodDetail insert(JsonNode orderData);
}
