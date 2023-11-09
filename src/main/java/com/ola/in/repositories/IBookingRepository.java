package com.ola.in.repositories;

import java.time.LocalDate;
import java.util.List;

import com.ola.in.entity.Booking;
import com.ola.in.exceptions.NotFoundException;



public interface IBookingRepository {
	Booking addBooking(Booking booking);
	Booking removeBooking(long bookingId) throws Exception;
	Booking updateBooking(long bookingId, Booking booking)throws NotFoundException;
	Booking getBooking(long bookingId) throws Exception;
	List<Booking> getAllBookings();
	List<Booking> getBookingsByDate(LocalDate date);
	List<Booking> getBookingsByCustomer(String customerId)throws Exception;	
}
