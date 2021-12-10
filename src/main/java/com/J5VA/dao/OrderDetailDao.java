package com.J5VA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.OrderDetail;
import com.J5VA.entity.Report;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {
	// so san pham ban nhieu nhat
	@Query("SELECT new Report(o.food, sum(o.price), sum(o.quantity)) " 
	        + " FROM OrderDetail o "
			+ " GROUP BY o.food"
			+ " HAVING sum(o.quantity) > 20" 
	        + " ORDER BY sum(o.quantity) DESC")
	List<Report> getInventoryByOrder();

	@Query("SELECT o FROM OrderDetail o WHERE o.orders.order_id=?1")
	List<OrderDetail> findByOrderId(Integer orderID);
}
