package com.J5VA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer>{

	@Query("SELECT o FROM Orders o WHERE o.order_acc.username=?1")
	List<Orders> findByUsername(String username);
	
	@Query("SELECT o FROM Orders o WHERE o.status=?1  ORDER BY o.orderdate desc")
	List<Orders> orderStatus(Integer status);
	
	@Query("SELECT count(o) FROM Orders o")
	Integer totalOrders();
	
	@Query("SELECT count(o) FROM Orders o where o.status =?1")
	Integer totalOrdersByStatus(Integer status);
	
}
