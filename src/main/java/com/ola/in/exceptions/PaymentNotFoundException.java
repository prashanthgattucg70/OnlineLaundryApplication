package com.ola.in.exceptions;

public class PaymentNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentNotFoundException(String msg) {
		super(msg);
	}

}
