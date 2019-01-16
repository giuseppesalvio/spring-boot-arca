package com.arca.microservices.conversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public
class CurrencyConversionAdapter
{
	@Autowired
	private Environment environment;

	public
	CurrencyConversion toCurrencyConversion(ForexServiceResponse response, BigDecimal originalAmount)
	{
		CurrencyConversion dst = new CurrencyConversion();
		dst.setConvertedAmount(originalAmount.multiply(response.getExchangeRate()));
		dst.setForexServicePort(response.getServicePort());
		dst.setConversionServicePort(localServerPort());
		return dst;
	}

	private
	int localServerPort()
	{
		return Integer.parseInt(environment.getProperty("local.server.port"));
	}
}
