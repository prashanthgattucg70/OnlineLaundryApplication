package com.ola.in.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ola.in.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Long>{
	@Query("Select o from Order o where o.bookingDetails.customerItem.customer.userId =?1")
	List<Order> findbyCustomer(String custId);
}
