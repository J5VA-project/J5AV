package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.OrderDetail;

public interface OrderDetailService {
	List<OrderDetail> list();
	
	List<OrderDetail> findByOrderId(Integer orderID);
}
