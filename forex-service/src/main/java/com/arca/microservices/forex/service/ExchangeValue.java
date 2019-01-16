package com.arca.microservices.forex.service;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public
class ExchangeValue
{
	@Id
	private Long       id;
	@Column(name = "currency_from")
	private String     from;
	@Column(name = "currency_to")
	private String     to;
	private BigDecimal exchangeRate;
}
