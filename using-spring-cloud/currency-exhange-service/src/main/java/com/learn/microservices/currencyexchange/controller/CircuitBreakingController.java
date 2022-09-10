package com.learn.microservices.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakingController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakingController.class);
	
	
	@GetMapping("/test-api")
//	@Retry(name="default",fallbackMethod = "fallback")
//	@CircuitBreaker(name = "default", fallbackMethod = "fallback")
	@RateLimiter(name = "default")
	public String testResilienceAPI() {		
		logger.info("Testing Resilience !!");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8085/some-dummy-url",String.class);
//		return forEntity.getBody();
		return "Testing";
	}
	
	public String fallback(Exception ex) {
		return "Fallback response";
	}
}
