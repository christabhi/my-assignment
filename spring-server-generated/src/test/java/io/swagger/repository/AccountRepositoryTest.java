package io.swagger.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Account;
import io.swagger.model.AccountFilters;

@SpringBootTest(classes = {Swagger2SpringBoot.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountRepositoryTest {
	
	@Autowired
	private AccountRepositoryImpl accountRepository;
	
	@Test
	public void whenAccNumbIsProvided_thenRetriveNameIsCorrect() {
		Account account = accountRepository.findByAccountNumber("01100218336"); 
		Assert.assertEquals(account.getAccountHolderName(), "Alok");
		Assert.assertEquals(account.getAccountType(), "SAVING");
		Assert.assertEquals(account.getCustomer().getEmail(), "aloktest@gamil.com");
	}
	
	@Test
	public void whenAccNumbIsWrong_thenObjectIsNull() {
		Account account = accountRepository.findByAccountNumber("01100112222"); 
		Assert.assertNull(account);
	}
	
	@Test
	public void retriveAllAccounts() {
		List<Account> accounts = accountRepository.findAllAccounts(); 
		Assert.assertEquals(accounts.size(), 12);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterCountryCode() {
		List<Account> accounts = accountRepository.findAllAccounts();
		AccountFilters filters = new AccountFilters("", "IN", "");
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		Assert.assertEquals(accounts.size(), 4);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterInvalidCountryCode() {
		List<Account> accounts = accountRepository.findAllAccounts();
		AccountFilters filters = new AccountFilters("", "TET", null);
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		Assert.assertEquals(accounts.size(), 0);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterCurrencyCode() {
		List<Account> accounts = RepositoryUtility.getAllAccounts();
		AccountFilters filters = new AccountFilters("", null, "USD");
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		Assert.assertEquals(accounts.size(), 2);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterInvalidCurrencyCode() {
		List<Account> accounts = RepositoryUtility.getAllAccounts();
		AccountFilters filters = new AccountFilters("", null, "CUK");
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		Assert.assertEquals(accounts.size(), 0);
	}
}
