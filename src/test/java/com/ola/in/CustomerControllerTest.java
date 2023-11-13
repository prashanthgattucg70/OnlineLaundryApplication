package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ola.in.controller.CustomerController;
import com.ola.in.entity.Address;
import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerTest {
	@Autowired
	private CustomerController customerController;
	
	Address address=null;
	Customer customer=null;
	
//	@BeforeAll
//	public static void init() {
//	}
	
//	@Test
//	public void addCustomerTest01() {
//		//addCustomerTest01 method 
//		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
//		customer=new Customer("xyz","anand@gmail.com","1234567890", LocalDate.parse("1994-05-12"),address);
//		assertEquals(customerController.addCustomer(null).getStatusCode(), HttpStatus.CREATED);
//	}

	 /*private Address address;
	 private Customer customer;
	   @BeforeAll
	   public void init() {
	       address = new Address("a-210", "Balewadi", "Baner", "Pune", "Maharashtra", 12345);
	       customer = new Customer("7", "xyz", "Anand", LocalDate.parse("1994-01-12"), address);
	   }
	   @Test
	   public void addCustomerTest() {
	       Assertions.assertEquals(customerController.addCustomer(customer).getStatusCode(), HttpStatus.CREATED);
	   }*/

	@Test
	public void updateCustomerTest01() throws NotFoundException{
		//updateCustomerTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		try {
		assertEquals(customerController.updateCustomer("6", customer).getStatusCode(), HttpStatus.ACCEPTED);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getCustomerTest01() throws Exception{
		//getCustomerTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		try {
		assertEquals(customerController.getCustomer("7").getStatusCode(), HttpStatus.ACCEPTED);
		}
		catch(NotFoundException ex) {
			assertEquals("Customer id is not present",ex.getMessage());
		}
	}
	
	@Test
	public void getAllCustomerTest01() {
		//getAllCustomerTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("xyz", "abc@123", "1234567890", LocalDate.parse("1994-05-12"), address);
		assertEquals(customerController.getAllCustomers().getStatusCode(), HttpStatus.OK);
	}
	
}
