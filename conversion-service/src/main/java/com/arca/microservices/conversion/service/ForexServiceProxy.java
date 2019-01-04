package com.arca.microservices.conversion.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("forex-service")
@RibbonClient("forex-service")
public
interface ForexServiceProxy
{
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	ForexServiceResponse retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
