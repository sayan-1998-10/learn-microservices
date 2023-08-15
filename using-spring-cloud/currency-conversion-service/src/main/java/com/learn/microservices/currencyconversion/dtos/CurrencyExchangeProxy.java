package com.learn.microservices.currencyconversion.dtos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// this name field is the service that will used to fetch the instances from Eureka server
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/retrieveExhangeRate/from/{from}/to/{to}")
	public CurrencyConversion getExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to);

}
