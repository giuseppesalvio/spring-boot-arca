package com.arca.microservices.conversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public
class CurrencyConversionController
{
	@Autowired
	private ForexServiceProxy proxy;

	@Autowired
	private Environment environment;

	@GetMapping("/convert-currency/from/{from}/to/{to}/quantity/{quantity}")
	public
	CurrencyConversion convertCurrency(@PathVariable String from,
	                                   @PathVariable String to,
	                                   @PathVariable BigDecimal quantity)
	{
		ForexServiceResponse response = proxy.retrieveExchangeValue(from, to);
		return new CurrencyConversion(response.getId(),
		                              from,
		                              to,
		                              response.getConversionMultiple(),
		                              quantity,
		                              quantity.multiply(response.getConversionMultiple()),
		                              response.getPort(),
		                              localServerPort());
	}

	private
	int localServerPort()
	{
		return Integer.parseInt(environment.getProperty("local.server.port"));
	}
}
