package com.J5VA.implement;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.J5VA.dao.OrdersDao;
import com.J5VA.entity.Account;
import com.J5VA.entity.Orders;

@ExtendWith(MockitoExtension.class)
class OrdersImplementTest {
	@Mock
	OrdersDao orderDao;

	@InjectMocks
	OrdersImplement ordersService;

	int testFail = 0;

	@Test
	@Timeout(value = 2000)
	void test_getAllOrders_pass() {
		List<Orders> mockOrderss = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			mockOrderss.add(new Orders());
		}
		when(orderDao.findAll()).thenReturn(mockOrderss);
		List<Orders> actualOrderss = ordersService.findAll();
		assertThat(actualOrderss.size()).isEqualTo(mockOrderss.size());
		verify(orderDao).findAll();
	}

	@Test
	void test_findOrdersById_pass() {
		Integer OrdersdIdInteger = 1;
		Orders mockesOrders = new Orders();
		when(orderDao.findById(OrdersdIdInteger)).thenReturn(Optional.of(mockesOrders));
		Orders actualOrders = ordersService.findById(OrdersdIdInteger);
		assertThat(actualOrders).isEqualTo(mockesOrders);
		verify(orderDao).findById(OrdersdIdInteger);
	}

	@Test
	void test_createOrders_pass() {
		Orders Orders = new Orders();
		Orders.setOrder_id(100);
		when(orderDao.save(Orders)).thenReturn(Orders);

		Orders created = ordersService.save(Orders);
		assertThat(created.getOrder_id()).isSameAs(Orders.getOrder_id());
		verify(orderDao).save(Orders);
	}

	@Test
	void test_deleteOrders_pass() {
		List<Orders> lstOrders = new ArrayList<>();
		lstOrders.add(new Orders(0, null, 0, 0, null, null, null, null));
		lstOrders.add(new Orders(1, null, 0, 0, null, null, null, null));
		lstOrders.add(new Orders(2, null, 0, 0, null, null, null, null));
		lstOrders.add(new Orders(3, null, 0, 0, null, null, null, null));
		ordersService.delete(lstOrders.get(3).getOrder_id());
		verify(orderDao).deleteById(lstOrders.get(3).getOrder_id());
	}

	@Test
	void test_deleteOrders_fail() {
		List<Orders> lstOrders = new ArrayList<>();
		lstOrders.add(new Orders(0, null, 0, 0, null, null, null, null));
		lstOrders.add(new Orders(1, null, 0, 0, null, null, null, null));
		lstOrders.add(new Orders(2, null, 0, 0, null, null, null, null));
		lstOrders.add(new Orders(3, null, 0, 0, null, null, null, null));
		int od = lstOrders.get(4).getOrder_id() == lstOrders.get(4).getOrder_id() ? 0 : lstOrders.get(4).getOrder_id();
		ordersService.delete(od);
		assertFalse((od == testFail));
	}

	@Test
	void test_updateOrders_pass() {
		Orders Orders = new Orders();
		Orders.setOrder_id(1);
		Account account = new Account();
		Orders.setOrder_acc(account);

		Orders OrdersNew = new Orders();
		when(ordersService.findById(Orders.getOrder_id())).thenReturn(Orders);
		ordersService.update(OrdersNew);
		verify(orderDao).save(OrdersNew);
		verify(orderDao).findById(Orders.getOrder_id());
	}
}
