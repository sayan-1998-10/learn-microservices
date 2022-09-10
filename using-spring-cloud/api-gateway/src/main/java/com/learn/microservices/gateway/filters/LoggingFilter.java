package com.learn.microservices.gateway.filters;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

//Global filters. We can also use GatewayFilterFactory to implement granular filters only for some routes

@Component
public class LoggingFilter implements GlobalFilter {

	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		//Pre filtering
		logger.info("Path of the request received -> {}", exchange.getRequest().getPath());
		
		return chain.filter(exchange)
				.then(Mono.fromRunnable(() ->{
					logger.info("Post Proxied-Service Call");
				}));
	}

}
