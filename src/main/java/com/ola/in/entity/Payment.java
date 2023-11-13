package com.ola.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")
	private long paymentId;
	
	@NotEmpty(message = "Payment Type Required")
	@Column(name="type")
	private String type;
	
	@NotEmpty(message = "Payment Status Required")
	@Column(name="status")
	private String status;

	@NotNull
	@Column(name="customer_id")
	private String customerId;
	

		
	@OneToOne (cascade = CascadeType.ALL, optional=true)
	@JoinColumn(name="id")
	
	private Card card;

}
