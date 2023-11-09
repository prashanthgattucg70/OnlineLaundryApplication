package com.ola.in.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	
	private long paymentId;
	@NotEmpty	
	private String type;
	@NotEmpty
	private String status;
	@Valid
	private CardDto card;
}
