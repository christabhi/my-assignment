package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Account
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-23T04:43:46.613Z[GMT]")

public class Account {
	
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("accountNumber")
	private String accountNumber = null;

	@JsonProperty("accountType")
	private String accountType = null;

	@JsonProperty("accountHolderName")
	private String accountHolderName = null;

	@JsonProperty("bankName")
	private String bankName = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("currency")
	private String currency = null;

	@JsonProperty("customer")
	private Customer customer = null;

	@JsonProperty("bankCode")
	private String bankCode = null;

	@JsonProperty("branchCode")
	private String branchCode = null;

	@JsonProperty("status")
	private String status = null;

	public Account id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@Schema(description = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account accountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	/**
	 * Get accountNumber
	 * 
	 * @return accountNumber
	 **/
	@Schema(description = "")

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account accountType(String accountType) {
		this.accountType = accountType;
		return this;
	}

	/**
	 * Different account type i.e - CHECKING / SAVING
	 * 
	 * @return accountType
	 **/
	@Schema(description = "Different account type i.e - CHECKING / SAVING")

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Account accountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
		return this;
	}

	/**
	 * Get accountHolderName
	 * 
	 * @return accountHolderName
	 **/
	@Schema(description = "")

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Account bankName(String bankName) {
		this.bankName = bankName;
		return this;
	}

	/**
	 * Get bankName
	 * 
	 * @return bankName
	 **/
	@Schema(description = "")

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Account country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 **/
	@Schema(description = "")

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Account currency(String currency) {
		this.currency = currency;
		return this;
	}

	/**
	 * Get currency
	 * 
	 * @return currency
	 **/
	@Schema(description = "")

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Account customer(Customer customer) {
		this.customer = customer;
		return this;
	}

	/**
	 * Get customer
	 * 
	 * @return customer
	 **/
	@Schema(description = "")

	@Valid
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account bankCode(String bankCode) {
		this.bankCode = bankCode;
		return this;
	}

	/**
	 * Get bankCode
	 * 
	 * @return bankCode
	 **/
	@Schema(description = "")

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public Account branchCode(String branchCode) {
		this.branchCode = branchCode;
		return this;
	}

	/**
	 * Get branchCode
	 * 
	 * @return branchCode
	 **/
	@Schema(description = "")

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Account status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Define status of the account NEW / VERIFIED / FAILED / DORMENT
	 * 
	 * @return status
	 **/
	@Schema(description = "Define status of the account NEW / VERIFIED / FAILED / DORMENT")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(this.id, account.id) && Objects.equals(this.accountNumber, account.accountNumber)
				&& Objects.equals(this.accountType, account.accountType)
				&& Objects.equals(this.accountHolderName, account.accountHolderName)
				&& Objects.equals(this.bankName, account.bankName) && Objects.equals(this.country, account.country)
				&& Objects.equals(this.currency, account.currency) && Objects.equals(this.customer, account.customer)
				&& Objects.equals(this.bankCode, account.bankCode)
				&& Objects.equals(this.branchCode, account.branchCode) && Objects.equals(this.status, account.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, accountNumber, accountType, accountHolderName, bankName, country, currency, customer,
				bankCode, branchCode, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Account {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
		sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
		sb.append("    accountHolderName: ").append(toIndentedString(accountHolderName)).append("\n");
		sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
		sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
		sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
		sb.append("    branchCode: ").append(toIndentedString(branchCode)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
