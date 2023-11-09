package com.ola.in.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class OrderDto {
	private long orderId;
	@NotNull
	private double amount;
	@FutureOrPresent
	private LocalDate billingDate;
	@NotEmpty
	private String paymentMethod;
	@Valid
	private CustomerDto customer;
	@Valid
	private BookingDto bookingDetails;
}
