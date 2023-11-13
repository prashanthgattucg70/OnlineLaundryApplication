package com.ola.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="customer_items")
public class CustomerItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private long itemId;
	
	@NotEmpty(message="name required")
	private String name;
	
	@NotEmpty(message="color required")
	private String color;
	
	@NotEmpty(message="enter category")
	private String category;	
	
	@NotNull(message="quantity reqired")
	private int quantity;
	
	@NotEmpty(message="enter type of material")
	private String material;
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private Customer customer;
		
} 
