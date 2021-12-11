package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.J5VA.dao.FoodDao;
import com.J5VA.dao.FoodDetailDao;
import com.J5VA.entity.Food;
import com.J5VA.entity.FoodDetail;
import com.J5VA.service.FoodService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FoodImplement implements FoodService {
	@Autowired
	FoodDao dao;
	
	@Autowired
	FoodDetailDao fdtDao;

	@Override
	public Food save(Food entity) {
		return dao.save(entity);
	}
	
	@Override
	public int count() {
		return dao.countFood();
	}

	@Override
	public Food findById(Integer id) {
		return dao.findById(id).get();
	}


	@Override
	public List<Food> findAll() {
		return dao.findAll();
	}

	@Override
	public Food create(Food food) {
		return dao.save(food);
	}

	@Override
	public Food update(Food food) {
		return dao.save(food);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);

	}

	@Override
	public Page<Food> pageFood(Integer showPageNumber ,String name, String key, Integer pageNumber) {
		key = key == null ? "" : key;
		name = name == null ? "" : name;
		showPageNumber = showPageNumber == null ? 6 : showPageNumber;
		
		pageNumber = (pageNumber == null || pageNumber <= 0) ? 1 : pageNumber;

		Sort sort;
		
		if (key.equals("asc"))
			sort = Sort.by("price").ascending();
		else if (key.equals("az"))
			sort = Sort.by("food_name").ascending();
		else if (key.equals("za"))
			sort = Sort.by("food_name").descending();
		else
			sort = Sort.by("price").descending();
		
		Pageable pageable = PageRequest.of(pageNumber - 1, showPageNumber, sort);

		return dao.findAllFood(name, pageable);
	}

	@Override
	public Page<Food> pageFoodCate(Integer showPageNumber, String cate, String name, String key, Integer pageNumber) {
		key = key == null ? "" : key;
		name = name == null ? "" : name;
		cate = cate == null ? "" : cate;
		
		showPageNumber = showPageNumber == null ? 6 : showPageNumber;
		
		pageNumber = (pageNumber == null || pageNumber <= 0) ? 1 : pageNumber;

		Sort sort;
		
		if (key.equals("asc"))
			sort = Sort.by("price").ascending();
		else if (key.equals("az"))
			sort = Sort.by("food_name").ascending();
		else if (key.equals("za"))
			sort = Sort.by("food_name").descending();
		else
			sort = Sort.by("price").descending();
		
		Pageable pageable = PageRequest.of(pageNumber - 1, showPageNumber, sort);

		return dao.findAllFoodCate(cate ,name, pageable);
	}
	
	@Override
	public Page<Food> pageFoodSize(Integer showPageNumber, String size, String name, String key, Integer pageNumber) {
		key = key == null ? "" : key;
		name = name == null ? "" : name;
		size = size == null ? "" : size;
		
		showPageNumber = showPageNumber == null ? 6 : showPageNumber;
		
		pageNumber = (pageNumber == null || pageNumber <= 0) ? 1 : pageNumber;

		Sort sort;
		
		if (key.equals("asc"))
			sort = Sort.by("price").ascending();
		else if (key.equals("az"))
			sort = Sort.by("food_name").ascending();
		else if (key.equals("za"))
			sort = Sort.by("food_name").descending();
		else
			sort = Sort.by("price").descending();
		
		Pageable pageable = PageRequest.of(pageNumber - 1, showPageNumber, sort);

		return dao.findAllFoodSize(size ,name, pageable);
	}

	@Override
	public Page<Food> pageFoodPrice(Integer showPageNumber, Double priceSt, Double priceEn, String name, String key,
			Integer pageNumber) {
		key = key == null ? "" : key;
		name = name == null ? "" : name;
		priceSt = priceSt == null ? null : priceSt;
		priceEn = priceEn == null ? null : priceEn;
		
		showPageNumber = showPageNumber == null ? 6 : showPageNumber;
		
		pageNumber = (pageNumber == null || pageNumber <= 0) ? 1 : pageNumber;

		Sort sort;
		
		if (key.equals("asc"))
			sort = Sort.by("price").ascending();
		else if (key.equals("az"))
			sort = Sort.by("food_name").ascending();
		else if (key.equals("za"))
			sort = Sort.by("food_name").descending();
		else
			sort = Sort.by("price").descending();
		
		Pageable pageable = PageRequest.of(pageNumber - 1, showPageNumber, sort);

		return dao.findByPrice(priceSt, priceEn, name, pageable);
	}

	@Override
	public Food insert(JsonNode foodData) {
		ObjectMapper mapper = new ObjectMapper();
	
		Food food = mapper.convertValue(foodData, Food.class);
		dao.saveAndFlush(food);

		TypeReference<FoodDetail> type = new TypeReference<FoodDetail>() {};
		FoodDetail foodDetail = mapper.convertValue(foodData.get("food_detail"), type);
		fdtDao.save(foodDetail);

		return food;
	}



}
