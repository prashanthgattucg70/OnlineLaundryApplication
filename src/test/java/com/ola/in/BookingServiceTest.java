package com.ola.in;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ola.in.entity.Address;
import com.ola.in.entity.Booking;
import com.ola.in.entity.Customer;
import com.ola.in.entity.CustomerItem;
import com.ola.in.exceptions.BookingNotFoundException;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.IBookingService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)

public class BookingServiceTest {

	@Autowired
	private IBookingService bookingService;
	
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
		assertNotNull (bookingService.addBooking(booking));
	}*/
	
	
	
	/*@Test
	public void updateBookingTest01() throws NotFoundException{
		//updateBookingTest01 method 
		try {
			bookingService.updateBooking(234, booking);
		}
		catch(BookingNotFoundException ex) {
			assertEquals("Booking Id is not valid",ex.getMessage());
		}
	}*/
	
	/*@Test
	public void updateBookingTest02() throws NotFoundException{
		//updateBookingTest02 method 
		try {
		assertNotNull(bookingService.updateBooking(1, booking));
		}
		catch(BookingNotFoundException ex) {
			assertEquals("Booking Id is not valid",ex.getMessage());
		}
		
	}*/
	
	/*@Test
	public void getBookingTest01() throws Exception{
		bookingService.getBooking(123);
	}
	@Test
	public void getBookingTest02() throws Exception{
		assertNotNull(bookingService.getBooking(1));
		
	}*/
	
	@Test
	public void getAllBookingsTest01() {
		//getAllBookingsest01 method 
		assertNotNull (bookingService.getAllBookings());
	}
	
	@Test
	public void getBookingsByDate01() {
		//getBookingsByDate01 method 
			List<Booking> lb=(bookingService.getBookingsByDate(LocalDate.parse("2025-03-04")));
			assertThat(lb, IsEmptyCollection.empty());
			
	}
	
	@Test
	public void getBookingsByDate02() {
		//getBookingsByDate02 method 
			List<Booking> lb=(bookingService.getBookingsByDate(LocalDate.parse("2026-02-05")));
			assertThat(lb, IsEmptyCollection.empty());
			
	}
	
	/*@Test
	public void removeBookingTest01() throws Exception{
		bookingService.removeBooking(678);
	
	}
	/*@Test
	public void removeBookingTest02() throws Exception{
		bookingService.removeBooking(500);
	
	}*/
}
