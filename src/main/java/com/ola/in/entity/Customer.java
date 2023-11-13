package com.ola.in.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;



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
	
	@NotEmpty(message = "Name Field Empty")
	@Column(name="name")
	private String name;
	
	@NotEmpty
	@Email(message = "Invalid Email")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message = "Please provide contact number")
	@Size(max=10, min=10, message = "Invalid contact number")
	@Column(name="contact_no")
	private String contactNo;
	
	
	@Past(message = "Invalid Date of Birth")
	@Column(name="dob")
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="door_no")
	private Address address;
}
