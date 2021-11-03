package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.J5VA.dao.FoodDao;
import com.J5VA.entity.Food;
import com.J5VA.service.FoodService;

@Service
public class FoodImplement implements FoodService {
	@Autowired
	FoodDao dao;

	@Override
	public Food save(Food entity) {
		return dao.save(entity);
	}

//	@Override
//	public Page<food> listAll(int pageNumber) {
//		Pageable pageable = PageRequest.of(pageNumber -1, 6);
//		return dao.findAll(pageable);
//	}

	@Override
	public int count() {
		return dao.countFood();
	}

	@Override
	public Food findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Food entity) {
		dao.delete(entity);
	}

	@Override
	public List<Food> findAll() {
		return dao.findAll();
	}

	@Override
	public Food create(Food product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food update(Food product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public Page<food> searchFood(Integer pageNumber, String key) {
//		key = key == null ? "" : key;
//		pageNumber = (pageNumber == null || pageNumber <=0) ? 1 : pageNumber;
//		Pageable pageable = PageRequest.of(pageNumber -1, 6);
//		return dao.findAllFood(key, pageable);
//		
//	}

//	@Override
//	public Page<food> SortFood(Integer pageNumber) {
//		pageNumber = (pageNumber == null || pageNumber <=0) ? 1 : pageNumber;
//		Pageable pageable = PageRequest.of(pageNumber -1, 6);
//		return dao.sortPage(pageable);
//	}
	
	//thêm page=1 vào sort

	@Override
	public Page<Food> pageFood(Integer showPageNumber ,String name, String key, Integer pageNumber) {
		key = key == null ? "" : key;
		name = name == null ? "" : name;
		showPageNumber = showPageNumber == null ? 6 : showPageNumber;
		
		pageNumber = (pageNumber == null || pageNumber <= 0) ? 1 : pageNumber;

		Sort sort;
		
		if (key.equals("ASC"))
			sort = Sort.by("price").ascending();
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
		
		if (key.equals("ASC"))
			sort = Sort.by("price").ascending();
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
		
		if (key.equals("ASC"))
			sort = Sort.by("price").ascending();
		else
			sort = Sort.by("price").descending();
		
		Pageable pageable = PageRequest.of(pageNumber - 1, showPageNumber, sort);

		return dao.findAllFoodSize(size ,name, pageable);
	}

}
