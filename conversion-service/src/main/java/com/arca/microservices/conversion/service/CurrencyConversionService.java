package com.arca.microservices.conversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public
class CurrencyConversionService
{
	@Autowired
	private ForexServiceProxy proxy;

	@Autowired
	private CurrencyConversionAdapter adapter;

	public
	CurrencyConversion convertAmount(String from, String to, BigDecimal amount)
	{
		return adapter.toCurrencyConversion(proxy.retrieveExchangeValue(from, to), amount);
	}
}
