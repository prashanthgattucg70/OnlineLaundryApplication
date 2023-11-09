package com.ola.in.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ola.in.entity.Payment;

public interface IPaymentJpa extends JpaRepository<Payment,Long> {
	List<Payment> findByCustomerId(String custId);
	

}
