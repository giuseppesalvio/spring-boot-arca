package com.arca.microservices.forex.service;

import lombok.Data;

import java.math.BigDecimal;

@Data
public
class ExchangeValueResponse
{
	private String     from;
	private String     to;
	private BigDecimal exchangeRate;
	private int        servicePort;
}
