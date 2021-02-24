package io.swagger.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Account;
import io.swagger.model.AccountFilters;

@SpringBootTest(classes = {Swagger2SpringBoot.class})
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class RepositoryUtilityTest {

	@Test
	public void whenAccNumbIsProvided_thenRetriveNameIsCorrect() {
		Account account = RepositoryUtility.getAccountByAccountNumber("01100114192"); 
		assertEquals(account.getAccountHolderName(), "Abhishek");
	}
	
	@Test
	public void whenAccNumbIsWrong_thenObjectIsNull() {
		Account account = RepositoryUtility.getAccountByAccountNumber("01100112222"); 
		assertNull(account);
	}
	
	@Test
	public void retriveAllAccounts() {
		List<Account> accounts = RepositoryUtility.getAllAccounts(); 
		assertEquals(accounts.size(), 12);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterAccountTypeChecking() {
		List<Account> accounts = RepositoryUtility.getAllAccounts();
		AccountFilters filters = new AccountFilters("CHECKING", null, null);
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		assertEquals(accounts.size(), 4);
	}
	
	@Test
	public void retriveAllAccounts_applyFilterAccountTypeSaving() {
		List<Account> accounts = RepositoryUtility.getAllAccounts();
		AccountFilters filters = new AccountFilters("SAVING", null, null);
		
		accounts = RepositoryUtility.applyFilters(accounts, filters);
		assertEquals(accounts.size(), 8);
	}
}
