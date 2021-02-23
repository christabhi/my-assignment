package io.swagger.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Account;
import io.swagger.model.AccountFilters;

@SpringBootTest(classes = {Swagger2SpringBoot.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class RepositoryUtilityTest {

	@Test
	public void whenAccNumbIsProvided_thenRetriveNameIsCorrect() {
		Account account = RepositoryUtility.getAccountByAccountNumber("01100114192"); 
		Assert.assertEquals(account.getAccountHolderName(), "Abhishek");
	}
	
	@Test
	public void whenAccNumbIsWrong_thenObjectIsNull() {
		Account account = RepositoryUtility.getAccountByAccountNumber("01100112222"); 
		Assert.assertNull(account);
	}
	
	@Test
	public void retriveAllAccounts() {
		List<Account> accounts = RepositoryUtility.getAllAccounts(); 
		Assert.assertEquals(accounts.size(), 12);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterAccountTypeChecking() {
		List<Account> accounts = RepositoryUtility.getAllAccounts();
		AccountFilters filters = new AccountFilters("CHECKING", null, null);
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		Assert.assertEquals(accounts.size(), 4);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterAccountTypeSaving() {
		List<Account> accounts = RepositoryUtility.getAllAccounts();
		AccountFilters filters = new AccountFilters("SAVING", null, null);
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		Assert.assertEquals(accounts.size(), 8);
	}
}
