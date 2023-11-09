package com.ola.in.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;

@Repository

public interface ICustomerJpa extends JpaRepository<Customer, String>{
	
}
