package com.arca.microservices.conversion.service;

import lombok.Data;

import java.math.BigDecimal;

@Data
public
class CurrencyConversion
{
	private BigDecimal convertedAmount;
	private int        forexServicePort;
	private int        conversionServicePort;
}
