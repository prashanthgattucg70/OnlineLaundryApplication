package com.ola.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.repositories.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private ICustomerRepository customerRepository;
	
	//add customer
	public Customer addCustomer(Customer customer) {
		//("customer service - addCustomer method executed");
		return customerRepository.addCustomer(customer);
	}
	
	//Remove customer by customerId
	public Customer removeCustomer(String custId)throws NotFoundException{
		//("customer service - removeCustomer method executed");
		return customerRepository.removeCustomer(custId);
	}
	
	//Update customer by customerId
	public Customer updateCustomer(String custId, Customer customer) throws NotFoundException {
		//("customer service - updateCustomer method executed");
		return customerRepository.updateCustomer(custId, customer);
	}
	
	//Get customer by customerId
	public Customer getCustomer(String custId)throws Exception {
		//("customer service - getCustomer method executed");
		return customerRepository.getCustomer(custId);
	}
	
	//Get all customer
	public List<Customer> getAllCustomers(){
		//("customer service - getAllBooking method executed");
		return customerRepository.getAllCustomers();
	}
}
