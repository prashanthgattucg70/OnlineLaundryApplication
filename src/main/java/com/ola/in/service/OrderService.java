package com.ola.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Order;
import com.ola.in.repositories.IOrderRepository;


@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderRepository orderRepository;

	//Add order
	@Override
	public Order addOrder(Order order) {
		return orderRepository.addOrder(order);
	}
	
	//Remove order by id
	@Override
	public Order removeOrder(long id) throws Exception {
		return orderRepository.removeOrder(id);
	}
	
	
	//Update order by id
	@Override
	public Order updateOrder(long id, Order order) throws Exception {
		 
		return orderRepository.updateOrder(id, order);
	}
	
	//Get Order details by id
	@Override
	public Order getOrderDetails(long id) throws Exception {
		return orderRepository.getOrderDetails(id);
	}
	
	@Override
	public List<Order> getOrderByCustomer(String id) {
		return orderRepository.getOrderByCustomer(id);
	}
	//Get all orders
		public List<Order> getAllOrders(){
			return orderRepository.getAllOrders();
		}
	

}
