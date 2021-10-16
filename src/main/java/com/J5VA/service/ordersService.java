package com.J5VA.service;

import java.util.List;
import java.util.Optional;
import com.J5VA.entity.orders;
import com.fasterxml.jackson.databind.JsonNode;

public interface ordersService {

	orders create(JsonNode orderData);

	void deleteById(Integer id);

	Optional<orders> findById(Integer id);

	List<orders> findAll();

	orders save(orders entity);

	List<Object> findByUsername(String fullname);
	
}
