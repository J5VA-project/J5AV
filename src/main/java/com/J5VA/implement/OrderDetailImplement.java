package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.OrderDetailDao;
import com.J5VA.entity.OrderDetail;
import com.J5VA.service.OrderDetailService;

@Service
public class OrderDetailImplement implements OrderDetailService {
	@Autowired
	OrderDetailDao dao;

	@Override
	public List<OrderDetail> list() {
		return dao.findAll();
	}

}
