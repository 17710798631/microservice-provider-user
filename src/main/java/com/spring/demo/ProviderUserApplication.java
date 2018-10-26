package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class ProviderUserApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderUserApplication.class, args);
	}
	
}
