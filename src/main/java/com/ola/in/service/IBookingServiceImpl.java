package com.ola.in.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.Booking;
import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.repositories.IBookingRepository;
import com.ola.in.repositories.ICustomerRepository;


@Service
public class IBookingServiceImpl implements IBookingService {
	@Autowired
	private IBookingRepository bookingRepository;
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Booking addBooking(Booking booking) {
		bookingRepository .save(booking);
		return null;
	}

	public Booking removeBooking(long bookingId) throws Exception{
		Optional<Booking> ob=bookingRepository .findById(bookingId);
		if(ob.isPresent()) {
			Booking b= ob.get();
			bookingRepository .delete(b);
			return b;
		}
		else
			throw new NotFoundException("Booking id is not valid");
	}
	
	public Booking updateBooking(long bookingId, Booking booking) throws NotFoundException{
		Optional<Booking> ob = bookingRepository .findById(bookingId);
		
		if(ob.isPresent()) {
			
		Booking b= ob.get();
		b.setBookingDate(booking.getBookingDate());
		b.setBookingTime(booking.getBookingTime());
		b.setServiceType(booking.getServiceType());
		bookingRepository .save(b);
		return b;
	}
		else
			throw new NotFoundException("Booking Id is not valid");
	}
	
	public Booking getBooking(long bookingId) throws Exception {
		Optional<Booking> ob = bookingRepository .findById((bookingId));
		if(ob.isPresent()) {
			Booking b=ob.get();
			return b;
		}
		else 
			throw new NotFoundException("Booking id is not valid");
		
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepository .findAll();
	}
	
	public List<Booking> getBookingsByDate(LocalDate date){
		return bookingRepository .findByBookingDate(date);
	}
	
	public List<Booking> getBookingsByCustomer(String customerId) throws Exception{
		Optional<Customer> oc = customerRepository .findById(customerId);
		if(oc.isPresent()) {
			return bookingRepository .findByCustomerDetails(customerId);
		}
		else 
			throw new NotFoundException("customer id is not valid");
		
	}

	
}
