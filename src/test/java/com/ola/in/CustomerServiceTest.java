package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ola.in.entity.Address;
import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {
	@Autowired
	private ICustomerService customerService;
	
	Address address=null;
	Customer customer=null;
	
	@BeforeAll
	public static void init() {
	}
	
	/*@Test
	public void addCustomerTest01() {
		//addCustomerTest01 method 
//		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
//		customer=new Customer("7","xyz","Anand",LocalDate.parse("1994-05-12"),address);
//		assertNotNull (customerService.addCustomer(customer));	
		
	}*/
	
	@Test
	public void updateCustomerTest01() throws NotFoundException{
		//updateCustomerTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		try {
			customerService.updateCustomer("234", customer);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	@Test
	public void updateCustomerTest02() throws NotFoundException{
		//updateCustomerTest02 method 
		address=new Address("a-605","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Gaurav",LocalDate.parse("1994-05-12"),address);
		try {
		assertNotNull(customerService.updateCustomer("6", customer));
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void removeCustomerTest01() throws NotFoundException{
		//removeCustomerTest01 method 
		try {
			customerService.removeCustomer("456");
		}
		catch(NotFoundException ex) {
		assertEquals("Customer id not found",ex.getMessage());
		}
		
	}
	@Test
	public void removeCustomerTest02() throws NotFoundException{
		//removeCustomerTest02 method 
		try {
			customerService.removeCustomer("500");
		}
		catch(NotFoundException ex) {
		assertEquals("Customer id not found",ex.getMessage());
		}
		
	}
	
	@Test
	public void getCustomerTest01() throws Exception{
		//getCustomerTest01 method 
		try {
			customerService.getCustomer("345");
		}
		catch(NotFoundException ex) {
			assertEquals("Customer id is not present",ex.getMessage());
		}
	}
	@Test
	public void getCustomerTest02() throws Exception{
		//getCustomerTest02 method 
		try {
		assertNotNull(customerService.getCustomer("7"));
		}
		catch(NotFoundException ex) {
			assertEquals("Customer id is not present",ex.getMessage());
		}
	}
	
	@Test
	public void getAllCustomersTest01() {
		//getAllCustomersTest01 method 
		assertNotNull (customerService.getAllCustomers());
	}
	
	
}
