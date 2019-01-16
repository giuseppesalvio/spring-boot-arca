package com.arca.microservices.forex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public
class ExchangeValueController
{
	@Autowired
	private ExchangeValueService service;

	@GetMapping("/exchange/from/{from}/to/{to}")
	public
	ExchangeValueResponse retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
	{
		return service.getExchangeValue(from, to);
	}

	@GetMapping("/exchange/list")
	public
	List<Exchange> retrieveExchangeList()
	{
		return service.getExchangeList();
	}
}
