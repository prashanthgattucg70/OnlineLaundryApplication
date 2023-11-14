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

import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
		
	//Add Custommer
	@PostMapping("/add")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Object> response=null;
		Customer c= customerService.addCustomer(customer);
		response=new ResponseEntity<Object>(c,HttpStatus.CREATED);
		return response;
	}
	
	//Remove customer by customerId
	@DeleteMapping("/remove/{custId}")
	public ResponseEntity<Object> removeCustomer(@PathVariable String custId) throws NotFoundException{
		ResponseEntity <Object>response=null;
		Customer c = customerService.removeCustomer(custId);
		response=new ResponseEntity<Object>(c,HttpStatus.OK);
		return response;
	}
	
	//Update Customer by CustomerId
	@PutMapping("/update/{custId}")
	public ResponseEntity <Object> updateCustomer(@PathVariable String custId,@RequestBody Customer customer)throws NotFoundException {
			ResponseEntity <Object>response=null;		
			Customer c = customerService.updateCustomer(custId, customer);
			response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);
			return response;
	}
	
	//Get customer by customerId
	@GetMapping("/get/{custId}")
	public ResponseEntity <Object> getCustomer(@PathVariable String custId)throws Exception {
		ResponseEntity <Object>response=null;
		Customer c= customerService.getCustomer(custId);
		response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);		
		return response;
	}
	
	//Get all customers
	@GetMapping("/get")
	public ResponseEntity <Object> getAllCustomers(){
		ResponseEntity <Object> response=null;
		List<Customer> lc= customerService.getAllCustomers();
		response=new ResponseEntity <Object>(lc,HttpStatus.OK);
		return response;
	}
}
