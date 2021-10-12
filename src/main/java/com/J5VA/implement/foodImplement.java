package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Page<food> listAll(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber -1, 6);
		return dao.findAll(pageable);
	}

	@Override
	public food findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(food entity) {
		dao.delete(entity);
	}

	@Override
	public List<food> searchFood(String key) {
		return dao.searchFood(key);
	}


}
