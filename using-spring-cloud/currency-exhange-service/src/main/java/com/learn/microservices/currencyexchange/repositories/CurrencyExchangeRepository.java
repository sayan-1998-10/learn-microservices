package com.learn.microservices.currencyexchange.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.microservices.currencyexchange.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	public Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
