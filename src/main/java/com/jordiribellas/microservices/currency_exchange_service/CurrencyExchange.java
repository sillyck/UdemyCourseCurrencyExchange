package com.jordiribellas.microservices.currency_exchange_service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CurrencyExchange {

	private Long id;
	private String from;
	private String to;
	private double conversionMultiple;
	private String enviorment;

	public CurrencyExchange(Long id, String from, String to, double conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

}
