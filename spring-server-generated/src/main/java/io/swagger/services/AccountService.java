package io.swagger.services;

import java.util.List;

import io.swagger.model.Account;
import io.swagger.model.AccountFilters;

public interface AccountService {

	public List<Account> getAccounts(AccountFilters filters);
	
	public Account getAccountByAccountNumber(String accountNumber);
}
