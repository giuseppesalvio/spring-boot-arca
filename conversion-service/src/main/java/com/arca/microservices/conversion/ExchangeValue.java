package com.arca.microservices.conversion;

import lombok.Data;

import java.math.BigDecimal;

@Data
public
class ExchangeValue
{
	private Long       id;
	private String     from;
	private String     to;
	private BigDecimal conversionMultiple;
	private int        port;
}
