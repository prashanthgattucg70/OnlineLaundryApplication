package com.ola.in.exceptions;

public class PaymentNotFoundException extends RuntimeException{
	public PaymentNotFoundException(String msg) {
		super(msg);
	}

}
