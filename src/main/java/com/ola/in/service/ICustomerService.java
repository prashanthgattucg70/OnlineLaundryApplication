package com.ola.in.service;

import java.util.List;

import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer removeCustomer(String custId)throws NotFoundException;
	Customer updateCustomer(String custId, Customer customer)throws NotFoundException;
	Customer getCustomer(String custId)throws Exception;
	List<Customer> getAllCustomers();
}
