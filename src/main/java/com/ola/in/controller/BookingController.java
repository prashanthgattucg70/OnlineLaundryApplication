package com.ola.in.controller;

import java.time.LocalDate;
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

import com.ola.in.entity.Booking;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.IBookingService;

@RestController
@RequestMapping("/bookings")

public class BookingController {
	@Autowired
	private IBookingService bookingService;
	
	
	/*{
	    "bookingId": 3,
	    "bookingDate": "2023-11-15",
	    "bookingTime": "10:20:00",
	    "serviceType": "drycleaning"
	  },
	  "serviceType": "drycleaning",
	  "customerItem": {
	                  "itemId": 2,
			  "name": "puma Tshirt",
			  "color": "white",
			  "category": "shirt",
			  "quantity": 2,
			  "material": "cotton",
			  "description": "na",
	    "customer": {
	          "userId": "2002",
		  "password": "Xyza@1234",
		  "name": "sai kumar",
		  "email": "sai@gmail.com",
		  "contactNo": "1234567890",
		  "dob": "2001-08-13"
	    }
	  }
	}*/
	
	//Add a booking
	@PostMapping("/add")
	public ResponseEntity<Object> addBooking(@RequestBody Booking booking) {
		Booking b=bookingService.addBooking(booking);
		//ResponseEntity<Object> response=new ResponseEntity<Object>(b,HttpStatus.CREATED);
		return new ResponseEntity<Object>(b,HttpStatus.CREATED);
	}
	//Remove all the booking by id
	@DeleteMapping("/remove/{bookingId}")
	public ResponseEntity<Object> removeBooking(@PathVariable long bookingId) throws Exception {
		ResponseEntity<Object> response=null;
		Booking b = bookingService.removeBooking(bookingId);
		response=new ResponseEntity<Object>(b,HttpStatus.OK);
		return response;
	}
	
	//Update all the booking by id
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<Object> updateBooking(@PathVariable long bookingId, @RequestBody Booking booking) throws NotFoundException {
		ResponseEntity<Object>response=null;
		Booking b = bookingService.updateBooking(bookingId, booking);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);
		return response;
}

	//Get by booking id
	@GetMapping("/get/{bookingId}")
	public ResponseEntity <Object> getBooking(@PathVariable long bookingId) throws Exception{
		ResponseEntity <Object>response=null;
		Booking b=bookingService.getBooking(bookingId);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);		
		return response;
	}
	//Get all the bookings
	@GetMapping("/get")
	public ResponseEntity<Object> getAllBookings(){
		ResponseEntity<Object> response=null;
		List<Booking> lb= bookingService.getAllBookings();
		response=new ResponseEntity<Object>(lb,HttpStatus.OK);
		return response;
	}
	
	//Get all the bookings for a specific date
	@GetMapping("/getbydate/{date}")
	public ResponseEntity<Object> getBookingsByDate(@PathVariable String date){
		ResponseEntity<Object> response=null;
		LocalDate myDate=LocalDate.parse(date);
		List<Booking> lb=bookingService.getBookingsByDate(myDate);
		response=new ResponseEntity<Object>(lb,HttpStatus.OK);
		return response;
	}
	
	//Get bookings by customer id
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<Object> getBookingsByCustomer(@PathVariable String customerId) throws Exception{
		ResponseEntity<Object>response=null;
		List<Booking> lb=bookingService.getBookingsByCustomer(customerId);
		response=new ResponseEntity<>(lb, HttpStatus.ACCEPTED);		
		return response;
	}

}
