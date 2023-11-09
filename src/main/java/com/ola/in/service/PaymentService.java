package com.ola.in.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Payment;
import com.ola.in.repositories.IPaymentRepository;
@Service
public class PaymentService implements IPaymentService {
	
	@Autowired
	private IPaymentRepository paymentRepository;
	
	//Add payment
	@Override
	public Payment addPayment(Payment payment) {
 
		return paymentRepository.addPayment(payment);
	}
	
	//Remove payment by id
	@Override
	public Payment removePayment(long id) throws Exception {
 
		return paymentRepository.removePayment(id);
	}
	
	//Update payment by id
	@Override
	public Payment updatePayment(long id, Payment payment) throws Exception {
 
		return paymentRepository.updatePayment(id, payment);
	}
    
	//Get payment details by id
	@Override
	public Payment getPaymentDetails(long id) throws Exception {
 
		return paymentRepository.getPaymentDetails(id);
	}
	
	//Get all payment details
	@Override
	public List<Payment> getPaymentDetails() {
 
		return paymentRepository.getAllPaymentDetails();
	}
	
	//Get payment details by customerId
	@Override
	public List<Payment> getCustomerPaymentDetails(String custId) throws Exception {
 
		return paymentRepository.getCustomerPaymentDetails(custId);

	}
	

}
