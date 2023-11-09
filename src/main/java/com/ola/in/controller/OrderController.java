package com.ola.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ola.in.entity.Order;
import com.ola.in.service.IOrderService;

public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	//Add Order
	@PostMapping("/add")
	public ResponseEntity<Object> addOrder(@RequestBody Order order) {
		ResponseEntity<Object> response=null;
		
		Order o =orderService.addOrder(order);
		response=new ResponseEntity<Object>(o,HttpStatus.CREATED);
		return response;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeOrder(@PathVariable long id)throws Exception {
	
		ResponseEntity<Object> response=null;
		Order o= orderService.removeOrder(id);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	//Update Order by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateOrder(@PathVariable long id,@RequestBody Order order)throws Exception {
		
		ResponseEntity<Object> response=null;
		Order o= orderService.updateOrder(id, order);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	//Get Order by details
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getOrderDetails(@PathVariable long id) throws Exception{
		
		ResponseEntity<Object> response=null;
		Order o =  orderService.getOrderDetails(id);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	@GetMapping("/getbycustomer/{custId}")
	public ResponseEntity<Object> getOrderByCustomer(@PathVariable String custId) throws Exception{
		
		ResponseEntity<Object> response=null;
		List<Order> lo =  orderService.getOrderByCustomer(custId);
		response = new ResponseEntity<Object>(lo,HttpStatus.OK);
		return response;
	}
	//Get all orders
	@GetMapping("/get")
	public ResponseEntity<Object> getAllOrders(){
		ResponseEntity<Object> response=null;
		
		List<Order> lo= orderService.getAllOrders();
		response=new ResponseEntity<Object>(lo,HttpStatus.OK);
		return response;
	}
}
