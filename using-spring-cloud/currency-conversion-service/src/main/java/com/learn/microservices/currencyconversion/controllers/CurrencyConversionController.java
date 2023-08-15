package com.learn.microservices.currencyconversion.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learn.microservices.currencyconversion.dtos.CurrencyConversion;
import com.learn.microservices.currencyconversion.dtos.CurrencyExchangeProxy;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/calculate/from/{from}/to/{to}")
	public CurrencyConversion convertCurrency(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@RequestParam(name = "bucks",defaultValue = "1", required = true) BigDecimal bucks) {
		
		String url = String.format("http://localhost:8000/currency-exchange/retrieveExhangeRate/from/{from}/to/{to}",from,to);
		
		// Use rest template to call the api
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("from",from);
		paramMap.put("to",to);
		ResponseEntity<CurrencyConversion> convertedTo = new RestTemplate().getForEntity(url, CurrencyConversion.class, paramMap);
		CurrencyConversion currencyConversion = convertedTo.getBody();
		
		currencyConversion.setBucks(bucks);
		currencyConversion.setTotalCalculatedAmount(bucks.multiply(currencyConversion.getConversionMultiple()));
					
		return currencyConversion;
	}

	@GetMapping("/calculate/feign/from/{from}/to/{to}")
	public CurrencyConversion convertCurrencyFeign(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@RequestParam(name = "bucks",defaultValue = "1", required = true) BigDecimal bucks) {
		 
		CurrencyConversion currencyConversion = proxy.getExchangeRate(from, to);
		
		currencyConversion.setBucks(bucks);
		currencyConversion.setTotalCalculatedAmount(bucks.multiply(currencyConversion.getConversionMultiple()));
					
		return currencyConversion;
	}

}
