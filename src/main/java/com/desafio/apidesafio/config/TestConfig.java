package com.desafio.apidesafio.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.apidesafio.entities.Order;
import com.desafio.apidesafio.entities.User;
import com.desafio.apidesafio.entities.enums.OrderStatus;
import com.desafio.apidesafio.repositories.OrderRepository;
import com.desafio.apidesafio.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "lucas", "lucas@teste.com", "(46) 9 9999-9999", "000000");
		User user2 = new User(null, "marinho", "marinho@teste.com", "(46) 9 9999-9999", "000000");
		
		Order order1 = new Order(null, Instant.parse("2020-09-21T08:27:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2020-09-21T08:27:07Z"), OrderStatus.WAITING_PAYMENT,user2);
		Order order3 = new Order(null, Instant.parse("2020-09-21T08:27:07Z"), OrderStatus.WAITING_PAYMENT,user1);
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}
}
