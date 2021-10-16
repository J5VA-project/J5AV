package com.J5VA.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.orderDetailDao;
import com.J5VA.dao.ordersDao;
import com.J5VA.entity.orderDetail;
import com.J5VA.entity.orders;
import com.J5VA.service.ordersService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ordersImplement implements ordersService{
	
	@Autowired ordersDao ordersDao;
	@Autowired orderDetailDao orderDetailDao;
	
	@Override
	public List<Object> findByUsername(String fullname) {
		return ordersDao.findByUsername(fullname);
	}

	@Override
	public orders save(orders entity) {
		return ordersDao.save(entity);
	}

	@Override
	public List<orders> findAll() {
		return ordersDao.findAll();
	}

	@Override
	public Optional<orders> findById(Integer id) {
		return ordersDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		ordersDao.deleteById(id);
	}
	

	@Override
	public orders create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		orders order = mapper.convertValue(orderData, orders.class);
		ordersDao.save(order);
		
		TypeReference<List<orderDetail>> type = new TypeReference<List<orderDetail>>() {};
		List<orderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
		 	.stream().peek(d -> d.setOrders(order)).collect(Collectors.toList());
		orderDetailDao.saveAll(details);
		return order;
	}
}
