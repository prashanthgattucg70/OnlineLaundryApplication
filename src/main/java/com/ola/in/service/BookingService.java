package com.ola.in.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Booking;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.repositories.IBookingRepository;


@Service
public class BookingService implements IBookingService {
	
	@Autowired
	private IBookingRepository bookingRepository;
	
	//Add Booking of customers
	public Booking addBooking(Booking booking) {
		//("Booking service - addBooking method executed");
		return bookingRepository.addBooking(booking);
	}
	
	//Remove booking of customers
	public Booking removeBooking(long bookingId) throws Exception{
		//("Booking service - removeBooking method executed");
		return bookingRepository.removeBooking(bookingId);
	}
	
	//Update booking from customer id
	public Booking updateBooking(long bookingId, Booking booking)throws NotFoundException {
		//("Booking service - updateBooking method executed");
		return bookingRepository.updateBooking(bookingId, booking);
	}
	
	//Get bookings from booking id
	public Booking getBooking(long bookingId) throws Exception {
		//("Booking service - getBooking method executed");
		return bookingRepository.getBooking(bookingId);
	}
	
	//List of all bookings 
	public List<Booking> getAllBookings(){
		//("Booking service - getAllBooking method executed");
		return bookingRepository.getAllBookings();
	}
	
	//Get bookings by date
	public List<Booking> getBookingsByDate(LocalDate date){
		//("Booking service - getBookingsbyDate method executed");
		return bookingRepository.getBookingsByDate(date);
	}
	
	//Get all bookings by customer
	public List<Booking>getBookingsByCustomer(String customerId)throws Exception{
		//("Booking service - getBookingsByCustomer method executed");
		return bookingRepository.getBookingsByCustomer(customerId);
	}
}
