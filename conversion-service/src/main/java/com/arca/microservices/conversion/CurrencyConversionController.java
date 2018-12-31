package com.arca.microservices.conversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@Autowired
	private Environment environment;

	@GetMapping("/convert-currency/from/{from}/to/{to}/quantity/{quantity}")
	public
	CurrencyConversionBean convertCurrency(@PathVariable String from,
	                                       @PathVariable String to,
	                                       @PathVariable BigDecimal quantity)
	{
		ExchangeValue response = proxy.retrieveExchangeValue(from, to);

		logger.info("{}", response);

		return new CurrencyConversionBean(response.getId(),
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
