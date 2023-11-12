package com.ola.in;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ola.in.entity.Address;
import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.ICustomerItemService;

@SpringBootTest
public class CustomerItemServiceTest {
	@Autowired
	private ICustomerItemService customerItemService;
	
	CustomerItem customerItem=null;
	Address address=null;
	Customer customer=null;
	
	@Test
	public void removeItemTest01() throws Exception{
		//removeItemTest01 method 
		try {
			customerItemService.removeItem(746);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer item is not valid",ex.getMessage());
		}
	}
	@Test
	public void removeItemTest02() throws Exception{
		//removeItemTest02 method 
		try {
			customerItemService.removeItem(115);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer item is not valid",ex.getMessage());
		}
	}
	
		@Test
		public void getItemTest01() throws Exception{
			//getItemTest01 method 
			try {
				customerItemService.getItem(987);
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		@Test
		public void getItemTest02() throws Exception{
			//getItemTest02 method 
			try {
			assertNotNull(customerItemService.getItem(7));
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void getBookingsByCustomerTest01() throws Exception {
			//getBookingsByCustomerTest01 method 
			try {
			      customerItemService.getItemsByCustomer("789");
			}
			catch(NotFoundException ex) {
				assertEquals("Customerid is not valid",ex.getMessage());
			}	
		}
		@Test
		public void getBookingsByCustomerTest02() throws Exception{
			//getBookingsByCustomerTest02 method 
			try {
			assertThat (customerItemService.getItemsByCustomer("7"),IsEmptyCollection.empty());
			}
			catch(NotFoundException ex) {
				assertEquals("Customerid is not valid",ex.getMessage());
			}	
		}
		
		@Test
		public void updateCustomerItemTest01() throws Exception{
			//updateCustomerItemTest01 method 
			address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			try {
				customerItemService.updateItem(658, customerItem);
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void updateCustomerItemTest02() throws Exception{
			//updateCustomerItemTest02 method 
			address=new Address("d-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("7","xyz","Anand",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			try {
			assertNotNull(customerItemService.updateItem(7, customerItem));
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void addItemTest01() {
			//addItemTest01 method 
			address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			assertNotNull (customerItemService.addItem(customerItem));
		}
		
	}

	
