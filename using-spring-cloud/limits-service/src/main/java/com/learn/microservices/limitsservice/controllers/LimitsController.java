package com.learn.microservices.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.microservices.limitsservice.configuration.Configuration;
import dtos.Limit;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration limitConfig;
	
	@GetMapping("/limits")
	public Limit getLimits() {
		return new Limit(limitConfig.getMaximum(),limitConfig.getMinimum());
	}
	

}
