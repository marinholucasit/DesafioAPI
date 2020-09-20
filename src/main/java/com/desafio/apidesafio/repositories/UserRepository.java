package com.desafio.apidesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apidesafio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
