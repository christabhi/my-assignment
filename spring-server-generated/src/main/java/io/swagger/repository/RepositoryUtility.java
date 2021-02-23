package io.swagger.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import io.swagger.model.Account;
import io.swagger.model.AccountFilters;

/**
 * @Description: Helper class to replicate DB operations 
 * 
 * */
public class RepositoryUtility {

	/**
	 * @Description: holds the list of accounts
	 * */
	private static List<Account> accounts = new ArrayList<Account>();

	/**
	 * @Description: This is used to populate account list while application initialization to load data from data.json
	 * 
	 * */
	public static void saveAccount(Account account) {
		accounts.add(account);
	}
	
	/**
	 * @Description: Replicate database operation to fetch account details using account number
	 * @param {accountNumber}
	 * */
	public static Account getAccountByAccountNumber(String accountNumber) {
		return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst()
				.orElse(null);
	}

	/**
	 * @Description: Replicate database operation to fetch all accounts
	 * */
	public static List<Account> getAllAccounts() {
		return accounts;
	}

	/**
	 * @Description: Replicate database operation to apply filters
	 * */
	public static List<Account> applyFilters(List<Account> accounts, AccountFilters filters) {

		// Filter by account type
		accounts = filterByAccountType(accounts, filters.getAccountType());

		// Filter by currency code
		accounts = filterByCurrency(accounts, filters.getCurrencyCode());

		// Filter by country code
		accounts = filterByCountry(accounts, filters.getCountryCode());

		return accounts;
	}

	/**
	 * Create Custom filter for Account Type
	 */
	private static List<Account> filterByAccountType(List<Account> accounts, String accountType) {
		if (StringUtils.isEmpty(accountType) || !StringUtils.hasLength(accountType))
			return accounts;

		return accounts.stream().filter(account -> account.getAccountType().equals(accountType))
				.collect(Collectors.toList());
	}

	/**
	 * Create Custom filter for Currency Code
	 */
	private static List<Account> filterByCurrency(List<Account> accounts, String currnecyCode) {
		if (StringUtils.isEmpty(currnecyCode) || !StringUtils.hasLength(currnecyCode))
			return accounts;

		return accounts.stream().filter(account -> account.getCurrency().equals(currnecyCode))
				.collect(Collectors.toList());
	}

	/**
	 * Create Custom filter for Country Code
	 */
	private static List<Account> filterByCountry(List<Account> accounts, String countryCode) {
		if (StringUtils.isEmpty(countryCode) || !StringUtils.hasLength(countryCode))
			return accounts;

		return accounts.stream().filter(account -> account.getCountry().equals(countryCode))
				.collect(Collectors.toList());
	}
}
