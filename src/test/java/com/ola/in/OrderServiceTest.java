package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ola.in.entity.Address;
import com.ola.in.entity.Booking;
import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.entity.Order;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.IOrderService;



@SpringBootTest
public class OrderServiceTest {
	@Autowired
	private IOrderService orderService;
	
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
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),"Online",customer,booking);
		assertNotNull (orderService.addOrder(order));
	}
	
	@Test
	public void removeOrderTest01() throws Exception{
		//removeOrderTest01 method 
		try {
			orderService.removeOrder(586);
		}
		catch(NotFoundException ex) {
		assertEquals("Order id is not valid",ex.getMessage());
		}		
	}
	@Test
	public void removeOrderTest02() throws Exception{
		//removeOrderTest02 method 
		try {
			orderService.removeOrder(200);
		}
		catch(NotFoundException ex) {
		assertEquals("Order id is not valid",ex.getMessage());
		}		
	}
	
	
	@Test
	public void updateOrderTest01() throws Exception{
		//updateOrderTest01 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),"Online",customer,booking);
		try {
			orderService.updateOrder(457, order);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updateOrderTest02() throws Exception{
		//updateOrderTest02 method 
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(15,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),"Online",customer,booking);
		try {
		assertNotNull(orderService.updateOrder(2, order));
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getOrderTest01() throws Exception{
		//getOrderTest01 method 
		try {
			orderService.getOrderDetails(438);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getOrderTest02() throws Exception{
		//getOrderTest02 method 
		try {
		assertNotNull(orderService.getOrderDetails(2));
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllordersTest01() {
		//getAllorders Test01 method 
		assertNotNull (orderService.getAllOrders());
	}
}
