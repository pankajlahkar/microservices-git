package edu.placement.app.currencyexchange.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.placement.app.currencyexchange.service.ExchangeRateService;
import edu.placement.app.currencyexchange.vo.ExchangeValue;

@RestController
public class CurrencyExchangeRestController {
	private static Logger logger = LoggerFactory.getLogger(CurrencyExchangeRestController.class);
	private ExchangeRateService exchangeRateService;
	@Autowired
	public CurrencyExchangeRestController(final ExchangeRateService exchangeRateService) {
		this.exchangeRateService = exchangeRateService;
	}
	/*
	private List<ExchangeValue>currencyExchangeList = new ArrayList<ExchangeValue>();
	@PostConstruct
	public void populateCurrencyExchangeList() {
		currencyExchangeList.add(new ExchangeValue(Long.valueOf(1), "USD", "INR", new BigDecimal(80)));
		currencyExchangeList.add(new ExchangeValue(Long.valueOf(2), "EUR", "INR", new BigDecimal(100)));
		currencyExchangeList.add(new ExchangeValue(Long.valueOf(3), "AUD", "INR", new BigDecimal(75)));
		currencyExchangeList.add(new ExchangeValue(Long.valueOf(4), "BP", "INR", new BigDecimal(95)));
	}
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		final ExchangeValue requestedExchangeValue = new ExchangeValue(from , to); 
		for(final ExchangeValue exchangeValue : currencyExchangeList) {
			if(exchangeValue.equals(requestedExchangeValue)) {
				exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
				return exchangeValue;
			}
		}
		throw new RuntimeException("Invalid currency conversion request");
	}
	*/
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		logger.info("from " + from + " to " + to);
		return this.exchangeRateService.find(from, to);
	}
}
