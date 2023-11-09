package com.ola.in.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerItemDto {
	
	private long itemId;
	@NotEmpty
	private String name;
	@NotEmpty	
	private String color;
	@NotEmpty
	private String category;
	@NotEmpty	
	private int quantity;
	@NotEmpty	
	private String material;
	@NotEmpty
	private String description;

}
