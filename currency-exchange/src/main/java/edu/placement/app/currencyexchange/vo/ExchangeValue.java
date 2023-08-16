package edu.placement.app.currencyexchange.vo;

import java.math.BigDecimal;

public class ExchangeValue {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int port;
	public ExchangeValue(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public boolean equals(Object object) {
		final ExchangeValue other = (ExchangeValue)object;
		return this.from.equals(other.from) && this.to.equals(other.to);
	}
	public int hashCode() {
		return this.from.hashCode() + this.to.hashCode();
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
