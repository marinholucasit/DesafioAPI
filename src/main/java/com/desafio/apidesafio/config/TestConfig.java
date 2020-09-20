package com.desafio.apidesafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.apidesafio.entities.User;
import com.desafio.apidesafio.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "lucas", "lucas@teste.com", "(46) 9 9999-9999", "000000");
		User user2 = new User(null, "marinho", "marinho@teste.com", "(46) 9 9999-9999", "000000");
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
}
