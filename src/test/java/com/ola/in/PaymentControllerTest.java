package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ola.in.controller.PaymentController;
import com.ola.in.entity.Card;
import com.ola.in.entity.Payment;
import com.ola.in.exceptions.NotFoundException;

@SpringBootTest
public class PaymentControllerTest {
	
	@Autowired
	private PaymentController paymentController;
	
	
	Payment payment=null;
	Card card=null;
	
	@Test
	public void addPaymentTest01() {
		//"addPaymentTest01 method executed"
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed","7",card);
		assertEquals (paymentController.addPayment(payment).getStatusCode(),HttpStatus.CREATED);
	}
	
	@Test
	public void updatePaymentTest01() throws Exception {
		//"updatePaymentTest01 method executed"
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed","7",card);
		try {
		assertEquals (paymentController.getCustomerPaymentDetails("1").getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getPaymentTest01() throws Exception {
		//"getPaymentTest01 method executed"
		try {
		assertEquals (paymentController.getPaymentDetails(4).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllPaymentDetailsTest01()  {
		//"getAllPaymentDetailsTest01 method executed"
		assertEquals (paymentController.getAllPaymentDetails().getStatusCode(),HttpStatus.OK);
	}
}
