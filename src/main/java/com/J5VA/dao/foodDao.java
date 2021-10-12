package com.J5VA.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.food;


@Repository
public interface foodDao extends JpaRepository<food, Integer>,PagingAndSortingRepository<food, Integer>{
	
	@Query("SELECT o FROM food o WHERE o.food_detail.foodCategory.foodcategory_name=?1")
	List<food> findByCateID(String cid);
	
	@Query("SELECT o FROM food o WHERE o.food_detail.food_detail_size.name=?1")
	List<food> findBySize(String sid);
	
	@Query("SELECT o FROM food o WHERE o.food_name like ?1")
	List<food> searchFood(String name);

	@Query("SELECT o FROM food o ORDER BY o.price asc")
	List<food> foodLowPrice();
	
	@Query("SELECT o FROM food o ORDER BY o.price desc")
	List<food> foodHighPrice();


	@Query("SELECT o FROM food o ORDER BY o.food_name ASC")
	List<food> sortNameASC(String name);
}
