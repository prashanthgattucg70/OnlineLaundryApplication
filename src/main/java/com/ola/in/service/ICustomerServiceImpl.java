package com.ola.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.repositories.ICustomerRepository;


@Service
public class ICustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	
	public Customer removeCustomer(String custId) throws NotFoundException {
		Optional<Customer> oc = customerRepository.findById(custId);
		if(oc.isPresent()) {
			Customer c = oc.get();
			customerRepository.delete(c);
			return c;
		}
		else
			throw new NotFoundException("Customer id not found");
			
	}
	
	public Customer updateCustomer(String custId, Customer customer) throws NotFoundException {
		Optional<Customer> oc = customerRepository.findById(custId);
		
		if(oc.isPresent()) {
			
			Customer c = oc.get();
			c.setUserId(customer.getUserId());
			c.setName(customer.getName());
			c.setAddress(customer.getAddress());
			c.setEmail(customer.getEmail());
			c.setDob(customer.getDob());
			c.setContactNo(customer.getContactNo());
			customerRepository.save(c);
			return c;
		}
		else
			throw new NotFoundException("User Id is not valid");
		
	}
	
	public Customer getCustomer(String custId) throws Exception {
		Optional<Customer> oc = customerRepository.findById(custId);
		if(oc.isPresent()) {
			Customer c=oc.get();
			return c;
		}
		else 
			throw new NotFoundException("Customer id is not present");
		
	}
	
	public List<Customer> getAllCustomers(){
		/*List<Customer> listCustomer = customerRepository.findAll();
		return listCustomer;*/
		return customerRepository.findAll();
	}
}
