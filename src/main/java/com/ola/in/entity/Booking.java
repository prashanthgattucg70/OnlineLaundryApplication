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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

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


	@Future(message = "Invalid Preffered Date")
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@NotEmpty(message = "Service type required")
	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="booking_time")
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime bookingTime; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_item_id")
	private CustomerItem customerItem;

}
