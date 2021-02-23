package io.swagger.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Account;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-23T04:43:46.613Z[GMT]")
@RestController
public class AccountsApiController implements AccountsApi {

	private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Account> accountByAccountNumber(
			@Parameter(in = ParameterIn.PATH, description = "Enter valid account number", required = true, schema = @Schema()) @PathVariable("accountNumber") String accountNumber) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Account>(objectMapper.readValue(
						"{\n  \"branchCode\" : \"branchCode\",\n  \"country\" : \"country\",\n  \"bankCode\" : \"bankCode\",\n  \"accountType\" : \"accountType\",\n  \"bankName\" : \"bankName\",\n  \"currency\" : \"currency\",\n  \"id\" : 0,\n  \"accountNumber\" : \"accountNumber\",\n  \"accountHolderName\" : \"accountHolderName\",\n  \"customer\" : {\n    \"firstName\" : \"firstName\",\n    \"lastName\" : \"lastName\",\n    \"phone\" : \"phone\",\n    \"id\" : 6,\n    \"email\" : \"email\"\n  },\n  \"status\" : \"status\"\n}",
						Account.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Account>> accountList(
			@Parameter(in = ParameterIn.QUERY, description = "Account type values that need to be consider for filters", schema = @Schema()) @Valid @RequestParam(value = "accountType", required = false) String accountType,
			@Parameter(in = ParameterIn.QUERY, description = "Currenncy code values that need to be consider for filters", schema = @Schema()) @Valid @RequestParam(value = "crrCode", required = false) String crrCode,
			@Parameter(in = ParameterIn.QUERY, description = "Country code values that need to be consider for filters", schema = @Schema()) @Valid @RequestParam(value = "countCode", required = false) String countCode) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Account>>(objectMapper.readValue(
						"[ {\n  \"branchCode\" : \"branchCode\",\n  \"country\" : \"country\",\n  \"bankCode\" : \"bankCode\",\n  \"accountType\" : \"accountType\",\n  \"bankName\" : \"bankName\",\n  \"currency\" : \"currency\",\n  \"id\" : 0,\n  \"accountNumber\" : \"accountNumber\",\n  \"accountHolderName\" : \"accountHolderName\",\n  \"customer\" : {\n    \"firstName\" : \"firstName\",\n    \"lastName\" : \"lastName\",\n    \"phone\" : \"phone\",\n    \"id\" : 6,\n    \"email\" : \"email\"\n  },\n  \"status\" : \"status\"\n}, {\n  \"branchCode\" : \"branchCode\",\n  \"country\" : \"country\",\n  \"bankCode\" : \"bankCode\",\n  \"accountType\" : \"accountType\",\n  \"bankName\" : \"bankName\",\n  \"currency\" : \"currency\",\n  \"id\" : 0,\n  \"accountNumber\" : \"accountNumber\",\n  \"accountHolderName\" : \"accountHolderName\",\n  \"customer\" : {\n    \"firstName\" : \"firstName\",\n    \"lastName\" : \"lastName\",\n    \"phone\" : \"phone\",\n    \"id\" : 6,\n    \"email\" : \"email\"\n  },\n  \"status\" : \"status\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Account>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Account>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
