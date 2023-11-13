package com.ola.in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ola.in.entity.*;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String>{
	

}
