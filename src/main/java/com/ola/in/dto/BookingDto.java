package com.ola.in.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

	private long bookingId;
	@NotEmpty
	private LocalDate bookingDate;
	@NotEmpty
	private LocalTime bookingTime;
	@NotEmpty
	private String serviceType;
}
