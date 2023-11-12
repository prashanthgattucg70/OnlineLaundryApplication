package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ola.in.entity.Card;
import com.ola.in.entity.Payment;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.IPaymentService;

@SpringBootTest
public class PaymentServiceTest {
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceTest.class);
	@Autowired
	private IPaymentService paymentService;
	
	
	Payment payment=null;
	Card card=null;
	
	@Test
	public void addPaymentTest01() {
		LOGGER.info("addPaymentTest01 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed","7",card);
		assertNotNull (paymentService.addPayment(payment));
	}
	
	@Test
	public void removePaymentTest01() throws Exception{
		LOGGER.info("removePaymentTest01 method executed");
		try {
			paymentService.removePayment(584);
		}
		catch(NotFoundException ex) {
		assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void removePaymentTest02() throws Exception{
		LOGGER.info("removePaymentTes02 method executed");
		try {
			paymentService.removePayment(450);
		}
		catch(NotFoundException ex) {
		assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updatePaymentTest01() throws Exception{
		LOGGER.info("updatePaymentTest01 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed","7",card);
		try {
		assertNotNull(paymentService.updatePayment(4, payment));
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updatePaymentTest02() throws Exception{
		LOGGER.info("updatePaymentTest02 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed","7",card);
		try {
			paymentService.updatePayment(234, payment);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getPaymentTest01() throws Exception{
		LOGGER.info("getPaymentTest01 method executed");
		try {
			paymentService.getPaymentDetails(356);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	@Test
	public void getPaymentTest02() throws Exception{
		LOGGER.info("getPaymentTest02 method executed");
		try {
			assertNotNull(paymentService.getPaymentDetails(4));
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllPaymentDetailsTest01() {
		LOGGER.info("getAllPaymentDetailsTest01 method executed");
		assertNotNull (paymentService.getAllPaymentDetails());
	}
}
