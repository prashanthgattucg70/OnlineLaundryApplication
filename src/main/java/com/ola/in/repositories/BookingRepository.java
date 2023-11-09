package com.ola.in.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ola.in.entity.Booking;
import com.ola.in.entity.Customer;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.jpa.IBookingJpa;
import com.ola.in.jpa.ICustomerJpa;
@Repository
public class BookingRepository implements IBookingRepository{
	
	@Autowired
	private IBookingJpa bookingjpa;
	
	@Autowired
	private ICustomerJpa customerjpa;

	@Override
	public Booking addBooking(Booking booking) {
		bookingjpa.save(booking);
		return null;
	}

	public Booking removeBooking(long bookingId) throws Exception{
		Optional<Booking> ob=bookingjpa.findById(bookingId);
		if(ob.isPresent()) {
			Booking b= ob.get();
			bookingjpa.delete(b);
			return b;
		}
		else
			throw new NotFoundException("Booking id is not valid");
	}
	
	public Booking updateBooking(long bookingId, Booking booking) throws NotFoundException{
Optional<Booking> ob = bookingjpa.findById(bookingId);
		
		if(ob.isPresent()) {
			
		Booking b= ob.get();
		b.setBookingDate(booking.getBookingDate());
		b.setBookingTime(booking.getBookingTime());
		b.setServiceType(booking.getServiceType());
		bookingjpa.save(b);
		return b;
	}
		else
			throw new NotFoundException("Booking Id is not valid");
	}
	
	public Booking getBooking(long bookingId) throws Exception {
		Optional<Booking> ob = bookingjpa.findById((bookingId));
		if(ob.isPresent()) {
			Booking b=ob.get();
			return b;
		}
		else 
			throw new NotFoundException("Booking id is not valid");
		
	}
	
	public List<Booking> getAllBookings(){
		List<Booking> b=bookingjpa.findAll();
		return b;
	}
	
	public List<Booking> getBookingsByDate(LocalDate date){
		List<Booking> b = bookingjpa.findByBookingDate(date);
		return b;
	}
	
	public List<Booking> getBookingsByCustomer(String customerId) throws Exception{
		Optional<Customer> oc = customerjpa.findById(customerId);
		if(oc.isPresent()) {
			return bookingjpa.findByCustomerDetails(customerId);
		}
		else 
			throw new NotFoundException("customer id is not valid");
		
	}
}
