package com.ola.in.entity;

import java.time.LocalDate;
import javax.persistence.*;

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
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="billing_date")
	private LocalDate billingDate;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="booking_id")
	private Booking bookingDetails;
	
}
