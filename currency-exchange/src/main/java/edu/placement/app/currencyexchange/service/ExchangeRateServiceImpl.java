package edu.placement.app.currencyexchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import edu.placement.app.currencyexchange.repo.dao.ExchangeRateDAO;
import edu.placement.app.currencyexchange.repo.entity.ExchangeRate;
import edu.placement.app.currencyexchange.vo.ExchangeValue;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{
	private Environment environment;
	private ExchangeRateDAO exchangeRateDAO;
	@Autowired
	public ExchangeRateServiceImpl(final ExchangeRateDAO exchangeRateDAO, final Environment environment) {
		this.exchangeRateDAO = exchangeRateDAO;
		this.environment = environment;
	}
	public ExchangeValue find(final String from, final String to) {
		final ExchangeValue targetExchangeValue = new ExchangeValue(from, to);
		final List<ExchangeRate>allExchangeRates = this.exchangeRateDAO.findAll();
		for(final ExchangeRate exchangeRate : allExchangeRates) {
			final ExchangeValue dbExchangeValue = new ExchangeValue(exchangeRate.getSourceCurrency(), exchangeRate.getTargetCurrency());
			if(targetExchangeValue.equals(dbExchangeValue)) {
				targetExchangeValue.setId(Long.valueOf(exchangeRate.getId()));
				targetExchangeValue.setConversionMultiple(exchangeRate.getConversionMultiple());
				targetExchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
				return targetExchangeValue;
			}
		}
		return null;
	}
}
