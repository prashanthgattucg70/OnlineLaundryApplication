package com.ola.in.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
	private long id;
	@NotEmpty
	private String cardName;
	@NotEmpty
	private String cardNumber;
	@NotEmpty
	private LocalDate expiryDate;
	@NotEmpty
	private String bankName;
}
