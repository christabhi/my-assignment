package io.swagger.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import io.swagger.model.ApplicationUser;

@Service
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

	private List<ApplicationUser> users = new ArrayList<ApplicationUser>();

	@Override
	public void save(ApplicationUser applicationUser) {
		
		applicationUser.setId(Long.valueOf(getRandomNumber()));
		
		users.add(applicationUser);
	}
	
	@Override
	public ApplicationUser findByUsername(String username) {
		return users.stream().filter(applicationUser -> applicationUser.getUsername().equals(username)).findFirst()
				.orElse(null);
	}
	
	private static int getRandomNumber() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
}
