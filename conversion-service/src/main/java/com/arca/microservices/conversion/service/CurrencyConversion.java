package com.arca.microservices.conversion.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class CurrencyConversion
{
	private Long       id;
	private String     from;
	private String     to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int        forexPort;
	private int        converterPort;
}