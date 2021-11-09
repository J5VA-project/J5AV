package com.J5VA.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Food;


@Repository
public interface FoodDao extends JpaRepository<Food, Integer>,PagingAndSortingRepository<Food, Integer>{
	@Query("SELECT COUNT(o) FROM Food o")
	int countFood();

	@Query("SELECT o FROM Food o WHERE o.food_name like %:name%")
	Page<Food> findAllFood(String name, Pageable pageable);
	
	@Query("SELECT o FROM Food o WHERE o.food_detail.foodCategory.foodcategory_name like :cate AND o.food_name like %:name%")
	Page<Food> findAllFoodCate(String cate,String name, Pageable pageable);
	
	@Query("SELECT o FROM Food o WHERE o.food_detail.food_detail_size.name like :size AND o.food_name like %:name%")
	Page<Food> findAllFoodSize(String size, String name, Pageable pageable);
	
	@Query("SELECT o FROM Food o WHERE o.food_detail.foodCategory.foodcategory_name=?1")
	List<Food> findByCateID(String cid);

	@Query("SELECT o FROM Food o WHERE o.food_detail.food_detail_size.name=?1")
	List<Food> findBySize(String sid);
	
	@Query("SELECT o FROM Food o WHERE o.price >= :priceSt AND o.price <= :priceEn AND o.food_name like %:name%")
	Page<Food> findByPrice(Double priceSt, Double priceEn, String name, Pageable pageable);
}
