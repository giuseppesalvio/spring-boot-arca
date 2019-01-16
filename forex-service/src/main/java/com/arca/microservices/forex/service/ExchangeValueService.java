package com.arca.microservices.forex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ExchangeValueService
{
	@Autowired
	private ExchangeValueRepository repository;

	@Autowired
	private ExchangeValueAdapter adapter;

	public
	ExchangeValueResponse getExchangeValue(String from, String to)
	{
		return adapter.toExchangeValueResponse(repository.findByFromAndTo(from, to));
	}

	public
	List<Exchange> getExchangeList()
	{
		return adapter.toExchangeList(repository.findAll());
	}
}
