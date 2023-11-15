package com.ola.in.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<String> handleBookingNotFoundException(BookingNotFoundException bnfe){
		return new ResponseEntity<String>(bnfe.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<String> handlePaymentNotFoundException(PaymentNotFoundException pnfe){
		return new ResponseEntity<String>(pnfe.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException unfe){
		return new ResponseEntity<String>(unfe.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}

}
