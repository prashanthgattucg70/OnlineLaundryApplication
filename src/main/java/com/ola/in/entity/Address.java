package com.ola.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@NotEmpty(message = "Empty Field Door Number")
	@Column(name="door_no")
	private String doorNo;
	
	@NotEmpty(message = "Empty Field Street")
	private String street;
	
	@NotEmpty(message = "Empty Field Area")
	private String area;
	
	@NotEmpty(message = "Empty Field City")
	private String city;
	
	@NotEmpty(message = "Empty Field State")
	private String state;
	
	
	@NotNull (message = "not valid pincode")
	private int pincode;
}
