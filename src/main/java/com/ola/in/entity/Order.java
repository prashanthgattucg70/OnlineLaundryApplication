package com.ola.in.entity;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private long orderId;
	
	@NotNull(message = "Please Enter Amount")
	@Column(name="amount")
	private double amount;
	
	//@NotEmpty
	@FutureOrPresent(message = "Invalid Billing Date")
	@Column(name="billing_date")
	private LocalDate billingDate;
	
	@NotEmpty
	@Column(name="payment_method")
	private String paymentMethod;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	@JsonIgnore
	private Booking bookingDetails;
	
}
