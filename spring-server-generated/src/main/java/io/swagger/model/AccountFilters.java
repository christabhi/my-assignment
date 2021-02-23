package io.swagger.model;

public class AccountFilters {

	private String accountType;
	
	private String countryCode;
	
	private String currencyCode;

	public AccountFilters(String accountType, String countryCode, String currencyCode) {
		this.accountType = accountType;
		this.countryCode = countryCode;
		this.currencyCode = currencyCode;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}
	
}
