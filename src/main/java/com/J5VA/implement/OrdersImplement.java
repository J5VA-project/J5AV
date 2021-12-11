package com.J5VA.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.OrderDetailDao;
import com.J5VA.dao.OrdersDao;
import com.J5VA.entity.BestCustomerBuy;
import com.J5VA.entity.BestSellingProduct;
import com.J5VA.entity.OrderDetail;
import com.J5VA.entity.Orders;
import com.J5VA.entity.Report;
import com.J5VA.service.OrdersService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrdersImplement implements OrdersService {
	@Autowired
	OrdersDao ordersDao;

	@Autowired
	OrderDetailDao orderDetailDao;

	@Override
	public List<Orders> findByUsername(String username) {
		return ordersDao.findByUsername(username);
	}

	@Override
	public Orders save(Orders entity) {
		return ordersDao.save(entity);
	}

	@Override
	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	@Override
	public Orders findById(Integer id) {
		return ordersDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		ordersDao.deleteById(id);
	}

	@Override
	public Orders create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();

		Orders order = mapper.convertValue(orderData, Orders.class);
		ordersDao.save(order);

		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type).stream()
				.peek(d -> d.setOrders(order)).collect(Collectors.toList());
		orderDetailDao.saveAll(details);
		return order;
	}

	@Override
	public Orders update(Orders order) {
		return ordersDao.save(order);
	}

	@Override
	public void delete(Integer id) {
		ordersDao.deleteById(id);
	}

	@Override
	public List<Orders> findAllByStatus(Integer status) {
		return ordersDao.orderStatus(status);
	}

	@Override
	public Integer totalOrders() {
		return ordersDao.totalOrders();
	}

	@Override
	public Integer totalOrdersByStatus(Integer status) {
		return ordersDao.totalOrdersByStatus(status);
	}

	@Override
	public Double findCarsAfterYear(Integer month) {
		return ordersDao.findCarsAfterYear(month);
	}

	@Override
	public List<Report> getInventoryByOrder() {
		return orderDetailDao.getInventoryByOrder();
	}

	@Override
	public Integer quantityFoodByMonth(Integer month) {
		return ordersDao.getReport2t(month);
	}

	@Override
	public List<BestSellingProduct> getListBestSellingFoods(Integer month, Integer year) {
		return ordersDao.getListBestSellingFoods(month, year);
	}

	@Override
	public List<BestCustomerBuy> getListBestCustomerBuy(Integer month, Integer year) {
		return ordersDao.getListBestCustomerBuy(month, year);
	}

	@Override
	public List<Orders> findByMonthAndYear(Integer month, Integer year) {
		return ordersDao.findByMonthAndYear(month, year);
	}

}
