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
	@NotEmpty
	@Column(name="door_no")
	private String doorNo;
	
	@NotEmpty
	@Column(name="street")
	private String street;
	
	@NotEmpty
	@Column(name="area")
	private String area;
	
	@NotEmpty
	@Column(name="city")
	private String city;
	
	@NotEmpty
	@Column(name="state")
	private String state;
	
	
	@NotNull
	@Size(max=6, min=6)
	@Column(name="pincode", nullable = false)
	private int pincode;
}
