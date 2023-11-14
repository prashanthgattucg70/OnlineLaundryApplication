package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ola.in.controller.BookingController;
import com.ola.in.entity.Address;
import com.ola.in.entity.Booking;
import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.exceptions.BookingNotFoundException;
import com.ola.in.exceptions.NotFoundException;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)

public class BookingControllerTest {

	@Autowired
	private BookingController bookingController;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	CustomerItem customerItem=null;
	
	@BeforeAll
	public  void init() {
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),"Online",LocalTime.parse("05:00:00"), customerItem);
	}
	
	/*@Test
	public void addBookingTest01() {
		//addBookingTest01 method 
		ResponseEntity<Object> response= bookingController.addBooking(booking);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
	}*/
	
	@Test
	public void updateBookingTest01() throws NotFoundException {
		//updateBookingTest01 method 
		try {
			ResponseEntity<Object> response= bookingController.updateBooking(1, booking);
			assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		}
		catch(BookingNotFoundException ex) {
			assertEquals("Booking with ID: "+booking.getBookingId()+" not exist!!",ex.getMessage());
		}
	}
	
	@Test
	public void getBookingTest01() throws Exception {
		//getBookingTest01 method 
		try {
		ResponseEntity<Object> response= bookingController.getBooking(1);
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		}
		catch(BookingNotFoundException ex) {
			assertEquals("Booking with ID: "+booking.getBookingId()+" not exist!!",ex.getMessage());
		}
	}
	
	@Test
	public void getAllBookingTest01() {
		//getAllBookingTest01 method 
		ResponseEntity<Object> response= bookingController.getAllBookings();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		}
	
	@Test
	public void getBookingsByDateTest01() throws Exception {
		//getAllBookingTest01 method 
		ResponseEntity<Object> response= bookingController.getBookingsByDate("2025-03-04");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		}
	
	/*@Test
	public void getBookingsByCustomersTest01() throws Exception {
		//getAllBookingTest01 method 
		ResponseEntity<Object> response= bookingController.getBookingsByCustomer("7");
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		}*/
}
