package io.swagger.exceptions;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ErrorResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-23T04:43:46.613Z[GMT]")
public class ErrorResponse {
	
	@JsonProperty("timestamp")
	private Date timestamp;
	
	@JsonProperty("code")
	private Integer code = null;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("details")
	private String details = null;

	public ErrorResponse(Date timestamp, int code, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.code = code;
		this.message = message;
		this.details = details;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/
	@Schema(description = "")

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public ErrorResponse message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	@Schema(description = "")

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponse details(String details) {
		this.details = details;
		return this;
	}

	/**
	 * Get details
	 * 
	 * @return details
	 **/
	@Schema(description = "")

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ErrorResponse errorResponse = (ErrorResponse) o;
		return Objects.equals(this.code, errorResponse.code) && Objects.equals(this.message, errorResponse.message)
				&& Objects.equals(this.details, errorResponse.details);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message, details);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorResponse {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
