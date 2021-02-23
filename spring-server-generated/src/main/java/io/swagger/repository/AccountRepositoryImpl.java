package io.swagger.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import io.swagger.model.Account;

/**
 * @Description: Database repository 
 * */
@Service
public class AccountRepositoryImpl implements AccountRepository {

	@Override
	public Account findByAccountNumber(String accountNumber) {
		return RepositoryUtility.getAccountByAccountNumber(accountNumber);
	}

	@Override
	public List<Account> findAllAccounts() {
		return RepositoryUtility.getAllAccounts();
	}

}
