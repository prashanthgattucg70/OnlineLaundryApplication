package com.ola.in.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ola.in.entity.Order;



public interface IOrderJpa extends JpaRepository <Order, Long>{
	@Query("Select o from Order o where o.bookingDetails.customerItem.customer.userId =?1")
	List<Order> findbyCustomer(String custId);

}
