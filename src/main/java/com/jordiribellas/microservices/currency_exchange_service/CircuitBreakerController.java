package com.jordiribellas.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name="default")
	@Bulkhead(name="sample-api")
	public String sampleApi() {
//		logger.info("Sample Api call got correctly");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url-to-fail", String.class);
//		
//		return forEntity.getBody();
		
		return "sample-api";
	}
	
	public String hardcodedResponse(Exception exception) {
		return "fallback-response";
	}
	
}
