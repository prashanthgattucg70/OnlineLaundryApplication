package com.ola.in.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ola.in.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{
	List<Payment> findByCustomerId(String custId);
}
