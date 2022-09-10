package com.learn.microservices.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	RouteLocator gatewayLocator(RouteLocatorBuilder builder) {
		return builder.routes().
				route(p -> p.
							path("/get/**")
							.filters(f -> f
											.addRequestHeader("Cust-Req-Header", "X012")
											.addResponseHeader("Cust-Res-Header","X013")
									)
							.uri("http://httpbin.org:80")
					).
				route(p ->p
						.path("/currency-conversion/**")
						.uri("lb://currency-conversion")
					).
				route(p -> p
						.path("/currency-exchange/**")
						.uri("lb://currency-exchange")
					).
				build();
	}
}
