package com.ola.in.repositories;

import java.util.List;

import com.ola.in.entity.Order;

public interface IOrderRepository {
	
		Order addOrder(Order order);
		Order removeOrder(long id)throws Exception;
		Order updateOrder(long id, Order order)throws Exception;
		Order getOrderDetails(long id)throws Exception;
		List<Order> getAllOrders();
		List<Order> getOrderByCustomer(String custId);
}
