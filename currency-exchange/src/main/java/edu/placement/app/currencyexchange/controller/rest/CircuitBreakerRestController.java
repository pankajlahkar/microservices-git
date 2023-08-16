package edu.placement.app.currencyexchange.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerRestController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerRestController.class);
	@GetMapping("/sampleapi")
	//@Retry(name="sampleapi", fallbackMethod = "sampleApiFallback")
	@CircuitBreaker(name="default", fallbackMethod = "sampleApiFallback")
	public String sampleApi() {
		logger.info("************************Calling sampleapi****************");
		new RestTemplate().getForEntity("http://localhost:8080/someapi", String.class);
		return "Sample API";
	}
	private String sampleApiFallback(final Exception exception) {
		return "sampleApiFallback";
	}
}
