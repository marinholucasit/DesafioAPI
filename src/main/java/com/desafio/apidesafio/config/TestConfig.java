package com.desafio.apidesafio.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.apidesafio.entities.Category;
import com.desafio.apidesafio.entities.Order;
import com.desafio.apidesafio.entities.Product;
import com.desafio.apidesafio.entities.User;
import com.desafio.apidesafio.entities.enums.OrderStatus;
import com.desafio.apidesafio.repositories.CategoryRepository;
import com.desafio.apidesafio.repositories.OrderRepository;
import com.desafio.apidesafio.repositories.ProductRepository;
import com.desafio.apidesafio.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Mobiles");
		Category cat2 = new Category(null, "Computers");
		Category cat3 = new Category(null, "Eletronics");
		
		Product prod1 = new Product(null, "Tv", "Led screem", 1600.0, "");
		Product prod2 = new Product(null, "PC", "Dell inspiron", 2600.0, "");
		Product prod3 = new Product(null, "SmartPhone", "MotoG plus", 1600.0, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		prod1.getCategories().add(cat2);
		prod1.getCategories().add(cat3);
		
		prod2.getCategories().add(cat2);
		prod2.getCategories().add(cat3);
		
		prod3.getCategories().add(cat1);
		prod3.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		User user1 = new User(null, "lucas", "lucas@teste.com", "(46) 9 9999-9999", "000000");
		User user2 = new User(null, "marinho", "marinho@teste.com", "(46) 9 9999-9999", "000000");
		
		Order order1 = new Order(null, Instant.parse("2020-09-21T08:27:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2020-09-21T08:27:07Z"), OrderStatus.WAITING_PAYMENT,user2);
		Order order3 = new Order(null, Instant.parse("2020-09-21T08:27:07Z"), OrderStatus.WAITING_PAYMENT,user1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}
}
