package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

//@Repository - aqui n precisa pq ele já implementa uma interface com essa característica
public interface ProductRepository extends JpaRepository<Product, Long>{ //interface - pede a classe com que vc vai trabalhar e o tipo da chave primária

}
