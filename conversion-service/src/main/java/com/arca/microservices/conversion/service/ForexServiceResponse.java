package com.arca.microservices.conversion.service;

import lombok.Data;

import java.math.BigDecimal;

@Data
public
class ForexServiceResponse
{
	private Long       id;
	private String     from;
	private String     to;
	private BigDecimal exchangeRate;
	private int        servicePort;
}
