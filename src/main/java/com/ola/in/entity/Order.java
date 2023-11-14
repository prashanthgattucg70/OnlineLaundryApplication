package com.ola.in.entity;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@FutureOrPresent(message = "Invalid Billing Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	@Column(name="billing_date")
	private LocalDate billingDate;
	
	@NotEmpty
	@Column(name="payment_method")
	private String paymentMethod;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	
	private Customer customer;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private Booking bookingDetails;
	
}
