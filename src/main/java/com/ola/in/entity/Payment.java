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
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private String status;
<<<<<<< HEAD

	
	@Column(name="customer_id")
	private String customerId;
	
=======
	
	@Column(name="customer_id")
	private String customerId;
		
>>>>>>> branch 'master' of https://github.com/prashanthgattucg70/OnlineLaundryApplication.git
	@OneToOne (cascade = CascadeType.ALL, optional=true)
	@JoinColumn(name="id")
	private Card card;

}
