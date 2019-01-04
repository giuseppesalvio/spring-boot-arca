package com.arca.microservices.forex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public
class ForexController
{
	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public
	ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
	{
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(localServerPort());
		return exchangeValue;
	}

	private
	int localServerPort()
	{
		// @Value("local.server.port") dà errore per property non trovata
		return Integer.parseInt(environment.getProperty("local.server.port"));
	}
}
