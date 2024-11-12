package com.jordiribellas.microservices.currency_exchange_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchange {

	private Long id;
	private String from;
	private String to;
	private double conversionMultiple;
	
}
