package io.swagger.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Account;
import io.swagger.model.AccountFilters;
import io.swagger.repository.AccountRepository;
import io.swagger.repository.RepositoryUtility;

/**
 * @Description: Account service class
 * 
 * */

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	private final AccountRepository repository;
	
	@Autowired
	AccountServiceImpl(AccountRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * @Description: Fetch the account list and filter the list based on used filters parameters 
	 * @param: AccountFilters
	 * 
	 * */
	@Override
	public List<Account> getAccounts(AccountFilters filters) {
		log.info("Fetch account list with filters");
		
		List<Account> accounts = repository.findAllAccounts();
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		
		log.info("Fetch account list with filters Account size :" + accounts.size());
		return accounts;
	}

	/**
	 * @Description: Fetch the account details based on account number 
	 * @param: accountNumber
	 * 
	 * */
	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		log.info("Fetch the account details using accountNumber");
		return repository.findByAccountNumber(accountNumber);
	}

}
