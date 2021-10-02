package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.foodDao;
import com.J5VA.entity.food;
import com.J5VA.service.foodService;

@Service
public class foodImplement implements foodService{
	
	@Autowired foodDao dao;

	@Override
	public food save(food entity) {
		return dao.save(entity);
	}

	@Override
	public List<food> findAll() {
		return dao.findAll();
	}

	@Override
	public food findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(food entity) {
		dao.delete(entity);
	}
	
	
}
