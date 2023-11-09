package com.ola.in.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.jpa.ICustomerItemJpa;
import com.ola.in.jpa.ICustomerJpa;
import com.ola.in.exceptions.NotFoundException;

@Repository
public class CustomerItemRepository implements ICustomerItemRepository{
	@Autowired
	private ICustomerItemJpa customeritemjpa;
	
	@Autowired
	private ICustomerJpa customerjpa;
	
	public CustomerItem addItem(CustomerItem item) {
		customeritemjpa.save(item);
		return(item);
	}	
	public CustomerItem removeItem(long id) throws Exception{
		Optional<CustomerItem> oc = customeritemjpa.findById(id);
		if(oc.isPresent()) {
			CustomerItem c=oc.get();
			customeritemjpa.delete(c);
			return c;
		}
		else
			throw new NotFoundException("Customer item is not valid");
	}
	
	public CustomerItem updateItem(long id, CustomerItem item) throws Exception {	
		Optional<CustomerItem> oc = customeritemjpa.findById(id);
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
			customeritemjpa.save(c);
			return c;
		}
		else
			throw new NotFoundException("CustomerItem is not valid");
		
	}
	
	public CustomerItem getItem(long id)throws Exception {
		Optional<CustomerItem> oc = customeritemjpa.findById(id);
		if(oc.isPresent()) {
			CustomerItem c = oc.get();
			return c;
		}
		else
			throw new NotFoundException("CustomerItem is not valid");
			
	}
	
	public List<CustomerItem> getItemsByCustomer(String customerId) throws Exception{
		Optional<Customer> oc=customerjpa.findById(customerId);
		if(oc.isPresent()) {
			Customer c = oc.get();
			List<CustomerItem> cItem = customeritemjpa.findByCustomer(c);
			return cItem;
		}
		else 
			throw new NotFoundException("Customerid is not valid");
		}

	
	

}
