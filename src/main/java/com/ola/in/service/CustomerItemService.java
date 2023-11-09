package com.ola.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.CustomerItem;
import com.ola.in.repositories.ICustomerItemRepository;



@Service

public class CustomerItemService implements ICustomerItemService  {
	
	@Autowired
	private ICustomerItemRepository customerItemRepository;
	
	//Add item
	public CustomerItem addItem(CustomerItem item) {
		//("customerItem service - addItem method executed");
		return customerItemRepository.addItem(item);
	}
	
	//Remove Item by id
	public CustomerItem removeItem(long id) throws Exception{
		//("customerItem service - removeItem method executed");
		return customerItemRepository.removeItem(id);
	}
	
	//Update item by id
	public CustomerItem updateItem(long id, CustomerItem item)throws Exception {
		//("customerItem service - updateItemr method executed");
		return customerItemRepository.updateItem(id, item);
	}
	
	//Get item by id
	public CustomerItem getItem(long id) throws Exception{
		//("customerItem service - getItem method executed");
		return customerItemRepository.getItem(id);
	}
	
	//Get items by customer
	@Override
	public List<CustomerItem> getItemsByCustomer(String customerId) throws Exception {
		//("customerItem service - getItemsByCustomer Customer method executed");
		return customerItemRepository.getItemsByCustomer(customerId);
	}
}
