package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.exceptions.DataNotFoundException;
import io.swagger.model.Account;
import io.swagger.model.AccountFilters;
import io.swagger.services.AccountService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-23T04:43:46.613Z[GMT]")
@RestController
public class AccountsApiController implements AccountsApi {

	private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

	private final AccountService accountService;

	@Autowired
	public AccountsApiController(AccountService accountService) {
		this.accountService = accountService;
	}

	public ResponseEntity<Account> accountByAccountNumber(
			@Parameter(in = ParameterIn.PATH, description = "Enter valid account number", required = true, schema = @Schema()) @Valid @PathVariable("accountNumber") String accountNumber) {
		
		log.info("");
		Account account = accountService.getAccountByAccountNumber(accountNumber);
		if(account == null)
			throw new DataNotFoundException("No record found");

		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	public ResponseEntity<List<Account>> accountList(
			@Parameter(in = ParameterIn.QUERY, description = "Account type values that need to be consider for filters", schema = @Schema()) @Valid @RequestParam(value = "accountType", required = false) String accountType,
			@Parameter(in = ParameterIn.QUERY, description = "Currenncy code values that need to be consider for filters", schema = @Schema()) @Valid @RequestParam(value = "crrCode", required = false) String crrCode,
			@Parameter(in = ParameterIn.QUERY, description = "Country code values that need to be consider for filters", schema = @Schema()) @Valid @RequestParam(value = "countCode", required = false) String countCode) {
		
		AccountFilters filters = new AccountFilters(accountType, countCode, crrCode);
		List<Account> accounts = accountService.getAccounts(filters);
		
		if(null == accounts || accounts.size() <= 0)
			throw new DataNotFoundException("No record found");
		
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}

}
