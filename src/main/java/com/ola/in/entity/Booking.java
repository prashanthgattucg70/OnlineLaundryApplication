package com.ola.in.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private long bookingId;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@Column(name="booking_time")
	private LocalTime bookingTime;
	
	@Column(name="service_type")
	private String serviceType;
	
	/*@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private Customer customerDetails;*/
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customer_item_id")
	private CustomerItem customerItem;

}
