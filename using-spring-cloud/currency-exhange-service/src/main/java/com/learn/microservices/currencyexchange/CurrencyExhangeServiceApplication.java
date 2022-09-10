package com.learn.microservices.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class CurrencyExhangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExhangeServiceApplication.class, args);
	}

}
