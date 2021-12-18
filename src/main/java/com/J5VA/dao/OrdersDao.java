package com.J5VA.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.BestCustomerBuy;
import com.J5VA.entity.BestSellingProduct;
import com.J5VA.entity.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {

	@Query("SELECT o FROM Orders o order by o.order_id desc")
	List<Orders> findAll();

	@Query("SELECT o FROM Orders o WHERE o.order_acc.username=?1")
	Page<Orders> findByUsername(String username, Pageable pageable);

	@Query("SELECT o FROM Orders o WHERE o.status=?1  ORDER BY o.orderdate desc")
	List<Orders> orderStatus(Integer status);

	@Query("SELECT count(o) FROM Orders o")
	Integer totalOrders();

	@Query("SELECT count(o) FROM Orders o where o.status =?1")
	Integer totalOrdersByStatus(Integer status);

	@Query(value = "{CALL sp_FindRevenueByMonth(:month)}", nativeQuery = true)
	Double findCarsAfterYear(@Param("month") Integer Month);

	@Query("select sum(o.quantity) " + "from OrderDetail o " + "where MONTH(o.orders.orderdate)=?1 ")
	Integer getReport2t(Integer month);

	@Query(value = "select new BestSellingProduct(o.food, sum(o.quantity)) from OrderDetail o "
			+ "where year(o.orders.orderdate) =?2 and month(o.orders.orderdate)=?1 " + "group by o.food.food_id "
			+ "order by sum(o.quantity) desc ")
	List<BestSellingProduct> getListBestSellingFoods(Integer month, Integer year);

	@Query(value = "select new BestCustomerBuy(o.order_acc.username, count(o.order_acc.username)) from Orders o "
			+ "where year(o.orderdate) = ?2 and month(o.orderdate) = ?1 " + "group by o.order_acc.username "
			+ "order by count(o.order_acc.username) desc")
	List<BestCustomerBuy> getListBestCustomerBuy(Integer month, Integer year);

	@Query(value = "SELECT o FROM Orders o WHERE MONTH(o.orderdate)=?1 and YEAR(o.orderdate)=?2")
	List<Orders> findByMonthAndYear(Integer month, Integer year);
	
	@Query("SELECT MAX(order_id) FROM Orders")
	int selectMax();
}
