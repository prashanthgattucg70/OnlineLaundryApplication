package com.ola.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Payment;
import com.ola.in.exceptions.BookingNotFoundException;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.exceptions.PaymentNotFoundException;
import com.ola.in.repositories.IPaymentRepository;
@Service
public class IPaymentServiceImpl implements IPaymentService {
	@Autowired
	private IPaymentRepository paymentRepository;
	
	public Payment addPayment(Payment payment) {
		paymentRepository.save(payment);
		return payment;
	}
	
	public Payment removePayment(long id) {
		Optional<Payment> op = paymentRepository.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			return p;
		}
		else 
			throw new PaymentNotFoundException("Payment with ID: "+id+" not exist!!");
	}
	
	public Payment getPaymentDetails(long id){
		Optional<Payment> op = paymentRepository.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			return p;
		}
		else 
			throw new PaymentNotFoundException("Payment with ID: "+id+" not exist!!");
	}
	public List<Payment> getCustomerPaymentDetails(String custId){
			List<Payment>  op = paymentRepository.findByCustomerId(custId);
			return op; 
	}
		
	
	public List<Payment> getAllPaymentDetails(){
		List<Payment> p = paymentRepository.findAll();
		return p; 
	}
	
	public Payment updatePayment(long id, Payment payment){
		Optional<Payment> op = paymentRepository.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			p.setPaymentId(payment.getPaymentId());
			p.setCard(payment.getCard());
			p.setStatus(payment.getStatus());
			p.setType(payment.getType());
			paymentRepository.save(p);
			return p;
		}
		else
			throw new PaymentNotFoundException("Payment with ID: "+id+" not exist!!");
	}
	

}
