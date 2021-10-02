package com.J5VA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.customer;

@Repository
public interface customerDao extends JpaRepository<customer, Integer>{

	@Query("SELECT o FROM customer o WHERE o.username = ?1")
	customer findByUsername(String username);
}
