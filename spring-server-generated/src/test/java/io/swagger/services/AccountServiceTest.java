package io.swagger.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Account;
import io.swagger.model.AccountFilters;

@SpringBootTest(classes = {Swagger2SpringBoot.class})
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class AccountServiceTest {

	@Autowired
	private AccountServiceImpl accountService;
	
	@Test
	public void whenAccNumbIsProvided_thenRetriveNameIsCorrect() {
		Account account = accountService.getAccountByAccountNumber("01100218336"); 
		assertEquals(account.getAccountHolderName(), "Alok");
		assertEquals(account.getAccountType(), "SAVING");
		assertEquals(account.getCustomer().getEmail(), "aloktest@gamil.com");
	}
	
	@Test
	public void whenAccNumbIsWrong_thenObjectIsNull() {
		Account account = accountService.getAccountByAccountNumber("01100112222"); 
		assertNull(account);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterCountryCode() {
		AccountFilters filters = new AccountFilters("", "IN", "");
		List<Account> accounts = accountService.getAccounts(filters);
		assertEquals(accounts.size(), 4);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterInvalidCountryCode() {
		AccountFilters filters = new AccountFilters("", "TET", null);
		List<Account> accounts = accountService.getAccounts(filters);
		
		assertEquals(accounts.size(), 0);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterCurrencyCode() {
		AccountFilters filters = new AccountFilters("", null, "USD");
		List<Account> accounts = accountService.getAccounts(filters);
		
		assertEquals(accounts.size(), 2);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterInvalidCurrencyCode() {
		AccountFilters filters = new AccountFilters("", null, "CUK");
		List<Account> accounts = accountService.getAccounts(filters);
		
		assertEquals(accounts.size(), 0);
	}
}
