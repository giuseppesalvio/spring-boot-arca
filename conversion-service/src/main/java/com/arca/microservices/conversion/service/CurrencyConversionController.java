package com.arca.microservices.conversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public
class CurrencyConversionController
{
	@Autowired
	private CurrencyConversionService service;

	@GetMapping("/convert-currency/from/{from}/to/{to}/amount/{amount}")
	public
	CurrencyConversion convertCurrency(@PathVariable String from,
	                                   @PathVariable String to,
	                                   @PathVariable BigDecimal amount)
	{
		return service.convertAmount(from, to, amount);
	}
}
