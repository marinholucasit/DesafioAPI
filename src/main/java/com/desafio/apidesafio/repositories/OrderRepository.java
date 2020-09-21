package com.desafio.apidesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apidesafio.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
