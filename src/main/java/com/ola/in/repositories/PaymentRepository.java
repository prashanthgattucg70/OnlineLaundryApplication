package com.ola.in.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ola.in.entity.Payment;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.jpa.IPaymentJpa;


@Repository
public class PaymentRepository implements IPaymentRepository {
	
	@Autowired
	private IPaymentJpa paymentjpa;
	
	public Payment addPayment(Payment payment) {
		paymentjpa.save(payment);
		return payment;
	}
	
	public Payment removePayment(long id) throws Exception{
		Optional<Payment> op = paymentjpa.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			return p;
		}
		else 
			throw new NotFoundException("Payment id is not valid");
	}
	
	public Payment getPaymentDetails(long id) throws Exception{
		Optional<Payment> op = paymentjpa.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			return p;
		}
		else 
			throw new NotFoundException("Payment id is not valid");
	}
	public List<Payment> getCustomerPaymentDetails(String custId) throws Exception{
			List<Payment>  op = paymentjpa.findByCustomerId(custId);
			return op; 
	}
		
	
	public List<Payment> getAllPaymentDetails(){
		List<Payment> p = paymentjpa.findAll();
		return p; 
	}
	
	public Payment updatePayment(long id, Payment payment)throws Exception{
		Optional<Payment> op = paymentjpa.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			p.setPaymentId(payment.getPaymentId());
			p.setCard(payment.getCard());
			p.setStatus(payment.getStatus());
			p.setType(payment.getType());
			paymentjpa.save(p);
			return p;
		}
		else
			throw new NotFoundException("Payment id is not valid");
	}

}
