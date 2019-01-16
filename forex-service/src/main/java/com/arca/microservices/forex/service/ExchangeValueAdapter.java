package com.arca.microservices.forex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public
class ExchangeValueAdapter
{
	@Autowired
	private Environment environment;

	public
	ExchangeValueResponse toExchangeValueResponse(ExchangeValue src)
	{
		ExchangeValueResponse dst = new ExchangeValueResponse();
		dst.setFrom(src.getFrom());
		dst.setTo(src.getTo());
		dst.setExchangeRate(src.getExchangeRate());
		dst.setServicePort(localServerPort());
		return dst;
	}

	public
	Exchange toExchange(ExchangeValue src)
	{
		Exchange dst = new Exchange();
		dst.setFrom(src.getFrom());
		dst.setTo(src.getTo());
		return dst;
	}

	public
	List<Exchange> toExchangeList(List<ExchangeValue> srcList)
	{
		List<Exchange> dstList = new ArrayList<>();
		for (ExchangeValue src : srcList)
		{
			dstList.add(toExchange(src));
		}
		return dstList;
	}

	private
	int localServerPort()
	{
		return Integer.parseInt(environment.getProperty("local.server.port"));
	}
}
