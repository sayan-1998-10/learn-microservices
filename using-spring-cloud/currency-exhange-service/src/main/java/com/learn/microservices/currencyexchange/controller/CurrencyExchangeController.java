package com.learn.microservices.currencyexchange.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservices.currencyexchange.entity.CurrencyExchange;
import com.learn.microservices.currencyexchange.repositories.CurrencyExchangeRepository;

@RestController
@RequestMapping(path = "/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository exchangeRepo;
	
	@GetMapping("/retrieveExhangeRate/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeRate(
							@PathVariable("from") String from,
							@PathVariable("to") String to) 
	{
		
		Optional<CurrencyExchange> currExchangeWrapper = exchangeRepo.findByFromAndTo(from, to);
		CurrencyExchange currencyExchange = null;
		
		if(currExchangeWrapper.isPresent())
			currencyExchange = currExchangeWrapper.get();
		else {
			throw new RuntimeException("Currency Exchange Rate not present for the given currencies");
		}
		currencyExchange.setEnvironmentInstance(environment.getProperty("local.server.port") + " - exchange service instance");
		return currencyExchange;
	}
}
