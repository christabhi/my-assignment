package io.swagger.services;

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
import io.swagger.repository.RepositoryUtility;

@SpringBootTest(classes = {Swagger2SpringBoot.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

	@Autowired
	private AccountServiceImpl accountService;
	
	@Test
	public void whenAccNumbIsProvided_thenRetriveNameIsCorrect() {
		Account account = accountService.getAccountByAccountNumber("01100218336"); 
		Assert.assertEquals(account.getAccountHolderName(), "Alok");
		Assert.assertEquals(account.getAccountType(), "SAVING");
		Assert.assertEquals(account.getCustomer().getEmail(), "aloktest@gamil.com");
	}
	
	@Test
	public void whenAccNumbIsWrong_thenObjectIsNull() {
		Account account = accountService.getAccountByAccountNumber("01100112222"); 
		Assert.assertNull(account);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterCountryCode() {
		AccountFilters filters = new AccountFilters("", "IN", "");
		List<Account> accounts = accountService.getAccounts(filters);
		Assert.assertEquals(accounts.size(), 4);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterInvalidCountryCode() {
		AccountFilters filters = new AccountFilters("", "TET", null);
		List<Account> accounts = accountService.getAccounts(filters);
		
		Assert.assertEquals(accounts.size(), 0);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterCurrencyCode() {
		AccountFilters filters = new AccountFilters("", null, "USD");
		List<Account> accounts = accountService.getAccounts(filters);
		
		Assert.assertEquals(accounts.size(), 2);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterInvalidCurrencyCode() {
		AccountFilters filters = new AccountFilters("", null, "CUK");
		List<Account> accounts = accountService.getAccounts(filters);
		
		Assert.assertEquals(accounts.size(), 0);
	}
}
