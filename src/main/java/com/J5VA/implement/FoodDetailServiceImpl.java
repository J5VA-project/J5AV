package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.FoodDao;
import com.J5VA.dao.FoodDetailDao;
import com.J5VA.entity.Food;
import com.J5VA.entity.FoodDetail;
import com.J5VA.service.FoodDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FoodDetailServiceImpl implements FoodDetailService {
	@Autowired
	FoodDetailDao foodDetailDao;

	@Autowired
	FoodDao foodDao;

	@Override
	public FoodDetail findById(Integer id) {
		return foodDetailDao.findById(id).get();
	}

	@Override
	public FoodDetail create(FoodDetail foodDetail) {
		return foodDetailDao.save(foodDetail);
	}

	@Override
	public FoodDetail update(JsonNode foodData) {
		ObjectMapper mapper = new ObjectMapper();

		TypeReference<Food> type = new TypeReference<Food>() {};
		Food food = mapper.convertValue(foodData.get("food"), type);
		foodDao.save(food);
		
		FoodDetail foodDetail = mapper.convertValue(foodData, FoodDetail.class);
		return foodDetailDao.save(foodDetail);
	}

	@Override
	public void delete(Integer id) {	
		foodDetailDao.deleteById(id);
	}

	@Override
	public List<FoodDetail> findAll() {
		return foodDetailDao.findAll();
	}
	@Override
	public FoodDetail insert(JsonNode foodData) {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<Food> type = new TypeReference<Food>() {};
		
		Food food = mapper.convertValue(foodData.get("food"), type);
		Integer food_id = Integer.valueOf(foodData.get("food_id").asInt());
		food.setFood_id(food_id);
		foodDao.saveAndFlush(food);
		
		FoodDetail foodDetail = mapper.convertValue(foodData, FoodDetail.class);
		foodDetailDao.save(foodDetail);
		
		return foodDetail;
	}

}
