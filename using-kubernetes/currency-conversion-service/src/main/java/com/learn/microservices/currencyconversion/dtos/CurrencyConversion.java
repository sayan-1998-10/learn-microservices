package com.learn.microservices.currencyconversion.dtos;

import java.math.BigDecimal;

public class CurrencyConversion {

	Long Id;
	String from;
	String to;
	BigDecimal conversionMultiple;
	BigDecimal bucks;
	BigDecimal totalCalculatedAmount;
	String environmentInstance;	
	
	
	public CurrencyConversion() {
		
	}
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal bucks,
			BigDecimal totalCalculatedAmount) {
		super();
		Id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.bucks = bucks;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getBucks() {
		return bucks;
	}
	public void setBucks(BigDecimal bucks) {
		this.bucks = bucks;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getEnvironmentInstance() {
		return environmentInstance;
	}

	public void setEnvironmentInstance(String environmentInstance) {
		this.environmentInstance = environmentInstance;
	}
	
	
	
}
