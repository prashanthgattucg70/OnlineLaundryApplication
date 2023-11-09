package com.ola.in.service;

import java.util.List;

import com.ola.in.entity.Order;

public interface IOrderService {
	Order addOrder(Order order);
	Order removeOrder(long id) throws Exception;
	Order updateOrder(long id,Order order) throws Exception;
	Order getOrderDetails(long id) throws Exception;
	List<Order> getAllOrders();
	List<Order> getOrderByCustomer(String id)throws Exception;

}
