package com.desafio.apidesafio.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apidesafio.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user1 = new User(1L, "lucas", "lucas@teste.com", "(46) 9 9999-9999", "000000");
		return ResponseEntity.ok().body(user1);
	}

}
