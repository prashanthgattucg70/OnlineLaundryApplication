package com.ola.in.repositories;

import java.util.List;

import com.ola.in.entity.CustomerItem;



public interface ICustomerItemRepository {
	CustomerItem addItem(CustomerItem item);
	CustomerItem removeItem(long id)throws Exception;
	CustomerItem updateItem(long id, CustomerItem item)throws Exception;
	CustomerItem getItem(long id)throws Exception;
	List<CustomerItem> getItemsByCustomer(String customerId)throws Exception;
}

