package com.jordiribellas.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private final CurrencyExchangeRepository repository;
    private final Environment environment;

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    
    @Autowired
    public CurrencyExchangeController(CurrencyExchangeRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		//INFO [currency-exchange,66d418538b80558582d0d786706513a3,29feb3960b9ca7a4] 1300 --- [currency-exchange] [nio-8001-exec-2] [66d418538b80558582d0d786706513a3-29feb3960b9ca7a4]
		logger.info("getExchangeValue called with {} to {}", from, to);
		
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for "+ from +" to " + to);
		}
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}
	
}
