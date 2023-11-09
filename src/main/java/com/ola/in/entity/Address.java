package com.ola.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name="door_no")
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;
}
