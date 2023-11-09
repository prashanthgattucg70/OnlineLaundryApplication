package com.ola.in.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.jpa.ICustomerJpa;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements ICustomerRepository{

	@Autowired
	private ICustomerJpa customerjpa;
	
	public Customer addCustomer(Customer customer) {
		customerjpa.save(customer);
		return customer;
	}
	
	public Customer removeCustomer(String custId) throws NotFoundException {
		Optional<Customer> oc = customerjpa.findById(custId);
		if(oc.isPresent()) {
			Customer c = oc.get();
			customerjpa.delete(c);
			return c;
		}
		else
			throw new NotFoundException("Customer id not found");
			
	}
	
	public Customer updateCustomer(String custId, Customer customer) throws NotFoundException {
		Optional<Customer> oc = customerjpa.findById(custId);
		
		if(oc.isPresent()) {
			
			Customer c = oc.get();
			c.setUserId(customer.getUserId());
			c.setName(customer.getName());
			c.setAddress(customer.getAddress());
			c.setEmail(customer.getEmail());
			c.setDob(customer.getDob());
			c.setContactNo(customer.getContactNo());
			customerjpa.save(c);
			return c;
		}
		else
			throw new NotFoundException("User Id is not valid");
		
	}
	
	public Customer getCustomer(String custId) throws Exception {
		Optional<Customer> oc = customerjpa.findById(custId);
		if(oc.isPresent()) {
			Customer c=oc.get();
			return c;
		}
		else 
			throw new NotFoundException("Customer id is not present");
		
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> listCustomer = customerjpa.findAll();
		return listCustomer;
	}

}
