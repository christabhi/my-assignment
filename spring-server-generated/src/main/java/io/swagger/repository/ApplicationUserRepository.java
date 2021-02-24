package io.swagger.repository;

import io.swagger.model.ApplicationUser;

public interface ApplicationUserRepository {
	
	void save(ApplicationUser applicationUser);
	
	ApplicationUser findByUsername(String username);
}
