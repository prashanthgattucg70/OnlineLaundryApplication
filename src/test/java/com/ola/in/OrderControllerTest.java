package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ola.in.controller.OrderController;
import com.ola.in.entity.Address;
import com.ola.in.entity.Booking;
import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.entity.Order;
import com.ola.in.exceptions.NotFoundException;

@SpringBootTest
public class OrderControllerTest {
	@Autowired
	private OrderController orderController;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	Order order=null;
	CustomerItem customerItem=null;
	
	@Test
	public void addOrderTest01() {
		//addOrderTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),"Online",LocalTime.parse("05:00:00"), customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),"Online",customer,booking);
		assertEquals (orderController.addOrder(order).getStatusCode(),HttpStatus.CREATED);
	}
	
	@Test
	public void updateOrderTest01() throws Exception{
		//updateOrderTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),"Online",LocalTime.parse("05:00:00"), customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),"Online",customer,booking);
		try {
		assertEquals (orderController.updateOrder(2, order).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getOrderDetailsTest01()	 throws Exception{
		//getOrderDetailsTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","Anand","xyz", LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),"Online",LocalTime.parse("05:00:00"), customerItem);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),"Online",customer,booking);
		try {
		assertEquals (orderController.getOrderDetails(2).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllOrdersTest01(){
		//getAllOrderTest01 method
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),"Online",LocalTime.parse("05:00:00"), customerItem);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),"Online",customer,booking);
		assertEquals (orderController.getAllOrders().getStatusCode(),HttpStatus.OK);
	}
}
