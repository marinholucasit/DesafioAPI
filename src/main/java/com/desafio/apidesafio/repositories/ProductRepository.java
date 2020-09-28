package com.desafio.apidesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apidesafio.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
