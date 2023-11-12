package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ola.in.controller.CustomerItemController;
import com.ola.in.entity.Address;
import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.exceptions.NotFoundException;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerItemControllerTest {
	@Autowired
	private CustomerItemController customerItemController;
	
	CustomerItem customerItem=null;
	Address address=null;
	Customer customer=null;
	
	@Test
	public void getItemTest01() throws Exception{
		//getItemTest01 method 
		try {
			assertEquals(customerItemController.getItem(1).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("CustomerItem is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void addItemTest01() throws Exception{
		//addItemTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		assertEquals(customerItemController.addItem(customerItem).getStatusCode(),HttpStatus.CREATED);		
	}
	
	@Test
	public void updateItemTest01() throws Exception{
		//updateItemTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		try {
		assertEquals(customerItemController.updateItem(7, customerItem).getStatusCode(),HttpStatus.ACCEPTED);
		}
		catch(NotFoundException ex) {
			assertEquals("CustomerItem is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getItemsByCustomeerTest01() throws Exception{
		//updateItemTest01 method 
		try {
			assertEquals(customerItemController.getItemsByCustomer("7").getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Customerid is not valid",ex.getMessage());
		}
	}
}
