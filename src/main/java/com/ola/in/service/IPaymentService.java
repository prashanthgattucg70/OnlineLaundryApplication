package com.ola.in.service;

import java.util.List;

import com.ola.in.entity.Payment;

public interface IPaymentService {
	Payment addPayment(Payment payment);
	Payment removePayment(long id)throws Exception;
	Payment updatePayment(long id,Payment payment)throws Exception;
	Payment getPaymentDetails(long id)throws Exception;
	List<Payment> getPaymentDetails();
	List<Payment> getCustomerPaymentDetails(String custId)throws Exception;

}
