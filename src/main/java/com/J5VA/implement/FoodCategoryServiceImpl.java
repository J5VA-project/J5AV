package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.FoodCategoryDao;
import com.J5VA.entity.FoodCategory;
import com.J5VA.service.FoodCategoryService;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
	@Autowired
	FoodCategoryDao dao;
	@Override
	public List<FoodCategory> findAll() {
		return dao.findAll();
	}

	@Override
	public FoodCategory findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public FoodCategory create(FoodCategory foodCategory) {
		return dao.save(foodCategory);
	}

	@Override
	public FoodCategory update(FoodCategory foodCategory) {
		return dao.save(foodCategory);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
