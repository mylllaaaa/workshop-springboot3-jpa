package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping //responde à requisição do tipo de get do http
	public ResponseEntity<User> findAll(){ //retorna uma resposta ao tentar acessar um dado
		User u = new User(1L, "Darrow", "reaperfromars@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);	
	}
	
}
