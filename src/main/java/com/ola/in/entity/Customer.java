package com.ola.in.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
@PrimaryKeyJoinColumn(referencedColumnName="user_id")
public class Customer extends User{
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="contact_no")
	private String contactNo;
	@Column(name="dob")
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="door_no")
	private Address address;
}
