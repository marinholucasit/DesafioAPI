package com.desafio.apidesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apidesafio.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
