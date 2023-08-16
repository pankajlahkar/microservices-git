package edu.placement.app.currencyexchange.service;

import edu.placement.app.currencyexchange.vo.ExchangeValue;

public interface ExchangeRateService {
	ExchangeValue find(String from, String to);
}
