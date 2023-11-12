package com.ola.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Order;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.repositories.IOrderRepository;


@Service
public class IOrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderRepository orderRepository;
	
	public Order addOrder(Order order) {
		orderRepository.save(order);
		return order;
	}
	
	public Order removeOrder(long id) throws Exception{
		Optional<Order> oo=orderRepository.findById(id);
		if(oo.isPresent()) {
			Order o = oo.get();
			orderRepository.delete(o);
			return o;
		}
		else
			throw new NotFoundException("Order id is not valid");
		
	}
	
	public Order updateOrder(long id, Order order)throws Exception {
		Optional<Order> oo=orderRepository.findById(id);
		if(oo.isPresent()) {
			Order o=oo.get();
			//o.setOrderId(order.getOrderId());
			o.setAmount(order.getAmount());
			o.setBillingDate(order.getBillingDate());
			//o.setBookingDetails(order.getBookingDetails());
			//o.setCustomer(order.getCustomer());
			o.setPaymentMethod(order.getPaymentMethod());
			orderRepository.save(o);
			return o;
		}
		else
			throw new NotFoundException("Order id is not valid");
		
	}
	
	public Order getOrderDetails(long id)throws Exception {
	    Optional<Order> oo=orderRepository.findById(id);
	    if(oo.isPresent()) {
	    	Order o=oo.get();
	    	return o;
	    }
	    else
	    	throw new NotFoundException("Order id is not valid");
	}
	
	public List<Order> getAllOrders(){
		List<Order> o = orderRepository.findAll();
		return o;
	}
	public List<Order> getOrderByCustomer(String custId){
		List<Order> o = orderRepository.findbyCustomer(custId);
		return o;
	}
}
