package io.swagger.repository;

import java.util.List;

import io.swagger.model.Account;

public interface AccountRepository {

	public Account findByAccountNumber(String accountNumber);
	
	public List<Account> findAllAccounts();
}
