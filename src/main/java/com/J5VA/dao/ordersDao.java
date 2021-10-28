package com.J5VA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.orders;

@Repository
public interface ordersDao extends JpaRepository<orders, Integer>{

	@Query("SELECT o FROM orders o WHERE o.custo.username_custo=?1")
	orders findByUsername(String username_custo);
}
