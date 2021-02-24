package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationUser {

	private long id;
    
	@JsonProperty("username")
	private String username;
    
	@JsonProperty("password")
	private String password;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
