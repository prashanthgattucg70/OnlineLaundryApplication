package com.ola.in.service;

import java.time.LocalDate;
import java.util.List;

import com.ola.in.entity.Booking;

public interface IBookingService {
	Booking addBooking(Booking booking);
	Booking removeBooking(long bookingId);
	Booking updateBooking(long bookingId, Booking booking);
	Booking getBooking(long bookingId);
	List<Booking> getAllBookings();
	List<Booking> getBookingsByDate(LocalDate date);
	List<Booking>getBookingsByCustomer(String customerId);
}
