package com.ola.in.exceptions;

public class BookingNotFoundException extends RuntimeException{
	public BookingNotFoundException(String msg) {
		super(msg);
	}

}
