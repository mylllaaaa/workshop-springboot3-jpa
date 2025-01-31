package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	@GetMapping //responde à requisição do tipo de get do http
	public ResponseEntity<List<Order>> findAll(){ //retorna uma resposta ao tentar acessar um dado
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "/{id}") //indica que a irl vai receber um id
	public ResponseEntity<Order> findById(@PathVariable Long id) { //para que a url aceite a entrada do id
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
