package com.ola.in.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ola.in.entity.Order;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.jpa.IOrderJpa;


@Repository
public class OrderRepository implements IOrderRepository{
	@Autowired
	private IOrderJpa orderjpa;
	
	public Order addOrder(Order order) {
		orderjpa.save(order);
		return order;
	}
	
	public Order removeOrder(long id) throws Exception{
		Optional<Order> oo=orderjpa.findById(id);
		if(oo.isPresent()) {
			Order o = oo.get();
			orderjpa.delete(o);
			return o;
		}
		else
			throw new NotFoundException("Order id is not valid");
		
	}
	
	public Order updateOrder(long id, Order order)throws Exception {
		Optional<Order> oo=orderjpa.findById(id);
		if(oo.isPresent()) {
			Order o=oo.get();
			//o.setOrderId(order.getOrderId());
			o.setAmount(order.getAmount());
			o.setBillingDate(order.getBillingDate());
			//o.setBookingDetails(order.getBookingDetails());
			//o.setCustomer(order.getCustomer());
			o.setPaymentMethod(order.getPaymentMethod());
			orderjpa.save(o);
			return o;
		}
		else
			throw new NotFoundException("Order id is not valid");
		
	}
	
	public Order getOrderDetails(long id)throws Exception {
	    Optional<Order> oo=orderjpa.findById(id);
	    if(oo.isPresent()) {
	    	Order o=oo.get();
	    	return o;
	    }
	    else
	    	throw new NotFoundException("Order id is not valid");
	}
	
	public List<Order> getAllOrders(){
		List<Order> o = orderjpa.findAll();
		return o;
	}
	public List<Order> getOrderByCustomer(String custId){
		List<Order> o = orderjpa.findbyCustomer(custId);
		return o;
	}

}
