package com.J5VA.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.J5VA.entity.BestCustomerBuy;
import com.J5VA.entity.BestSellingProduct;
import com.J5VA.entity.Orders;
import com.J5VA.entity.Report;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrdersService {

	Orders create(JsonNode orderData);

	void deleteById(Integer id);

	List<Orders> findAll();

	Orders save(Orders entity);

	Page<Orders> findByUsername(String username, Integer pageNumber, Integer showPageNumber);

	void delete(Integer id);

	Orders update(Orders order);

	Orders findById(Integer id);

	List<Orders> findAllByStatus(Integer status);

	Integer totalOrders();

	Integer totalOrdersByStatus(Integer status);

	Double findCarsAfterYear(Integer Month);

	List<Report> getInventoryByOrder();

	Integer quantityFoodByMonth(Integer month);

	List<BestSellingProduct> getListBestSellingFoods(Integer month, Integer year);

	List<BestCustomerBuy> getListBestCustomerBuy(Integer month, Integer year);

	List<Orders> findByMonthAndYear(Integer month, Integer year);

}
