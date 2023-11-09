package com.ola.in.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;





public interface ICustomerItemJpa extends JpaRepository<CustomerItem , Long>{
	List<CustomerItem> findByCustomer(Customer customer);

}
