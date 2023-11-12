package com.ola.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.repositories.ICustomerItemRepository;
import com.ola.in.repositories.ICustomerRepository;



@Service

public class ICustomerItemServiceImpl implements ICustomerItemService  {
	
	@Autowired
	private ICustomerItemRepository customeritemRepository;
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	public CustomerItem addItem(CustomerItem item) {
		customeritemRepository.save(item);
		return(item);
	}	
	public CustomerItem removeItem(long id) throws Exception{
		Optional<CustomerItem> oc = customeritemRepository.findById(id);
		if(oc.isPresent()) {
			CustomerItem c=oc.get();
			customeritemRepository.delete(c);
			return c;
		}
		else
			throw new NotFoundException("Customer item is not valid");
	}
	
	public CustomerItem updateItem(long id, CustomerItem item) throws Exception {	
		Optional<CustomerItem> oc = customeritemRepository.findById(id);
		if(oc.isPresent()) {
			CustomerItem c= oc.get();
			//c.setItemId(item.getItemId());
			c.setCategory(item.getCategory());
			c.setColor(item.getColor());
			//c.setCustomer(item.getCustomer());
			c.setDescription(item.getDescription());
			c.setMaterial(item.getMaterial());
			c.setName(item.getName());
			c.setQuantity(item.getQuantity());
			customeritemRepository.save(c);
			return c;
		}
		else
			throw new NotFoundException("CustomerItem is not valid");
		
	}
	
	public CustomerItem getItem(long id)throws Exception {
		Optional<CustomerItem> oc = customeritemRepository.findById(id);
		if(oc.isPresent()) {
			CustomerItem c = oc.get();
			return c;
		}
		else
			throw new NotFoundException("CustomerItem is not valid");
			
	}
	
	public List<CustomerItem> getItemsByCustomer(String customerId) throws Exception{
		Optional<Customer> oc=customerRepository.findById(customerId);
		if(oc.isPresent()) {
			Customer c = oc.get();
			List<CustomerItem> cItem = customeritemRepository.findByCustomer(c);
			return cItem;
		}
		else 
			throw new NotFoundException("Customerid is not valid");
		}
	
}
