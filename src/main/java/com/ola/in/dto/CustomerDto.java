package com.ola.in.dto;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	@NotEmpty
	private String name;
	@Email
	private String email;
	@NotEmpty
	@Size(max=10, min=10)
	private String contactNo;
	@Past
	private LocalDate dob;
}
