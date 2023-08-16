package edu.placement.app.currencyexchange.repo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.placement.app.currencyexchange.repo.entity.ExchangeRate;

public interface ExchangeRateDAO extends JpaRepository<ExchangeRate, Integer>{

}
