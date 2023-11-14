package com.ola.in.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ola.in.entity.Payment;
import com.ola.in.service.IPaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	
	//Add Payment
		@PostMapping("/add")
		public ResponseEntity<Object> addPayment(@RequestBody Payment payment) {
			ResponseEntity<Object> response=null;
			Payment p= paymentService.addPayment(payment);
			response = new ResponseEntity<Object>(p,HttpStatus.CREATED);
			return response;
		}
		//Remove Payment by id
		@DeleteMapping("/remove/{id}")
		public ResponseEntity<Object> removePayment(@PathVariable long id) throws Exception {
			ResponseEntity<Object> response=null;
			Payment p= paymentService.removePayment(id);
			response = new ResponseEntity<Object>(p,HttpStatus.OK);
			return response;
		}
		//Update Payment by id
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updatePayment(@PathVariable long id,@RequestBody Payment payment) throws Exception {
			ResponseEntity<Object> response=null;
			Payment p= paymentService.updatePayment(id, payment);
			response = new ResponseEntity<Object>(p,HttpStatus.OK);
			return response;
		}	
		//Get payment details by id
		@GetMapping("/get/{id}")
		public ResponseEntity<Object> getPaymentDetails(@PathVariable long id)throws Exception {
			ResponseEntity<Object> response=null;
			Payment p= paymentService.getPaymentDetails(id);
			response = new ResponseEntity<Object>(p,HttpStatus.OK);
			return response;
		}
		//Get all payment details
		@GetMapping("/get")
		public ResponseEntity<Object> getAllPaymentDetails(){
			ResponseEntity<Object> response = null;
			List<Payment> lp= paymentService.getAllPaymentDetails();
			response=new ResponseEntity<Object>(lp,HttpStatus.OK);
			return response;
		}
		
		//Get all payment details by customer id
		@GetMapping("/getbycustomer/{custId}")
		public ResponseEntity<Object> getCustomerPaymentDetails(@PathVariable String custId)throws Exception{
			ResponseEntity<Object> response = null;
			List<Payment> lp= paymentService.getCustomerPaymentDetails(custId);
			response=new ResponseEntity<Object>(lp,HttpStatus.OK);
			return response;
		}

}
