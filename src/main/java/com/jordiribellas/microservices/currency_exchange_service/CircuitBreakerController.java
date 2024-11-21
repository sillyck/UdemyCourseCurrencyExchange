package com.jordiribellas.microservices.currency_exchange_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

	@GetMapping("/sample-api")
	//@Retry
	public String sampleApi() {
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url-to-fail", String.class);
		
		return forEntity.getBody();
	}
	
}
