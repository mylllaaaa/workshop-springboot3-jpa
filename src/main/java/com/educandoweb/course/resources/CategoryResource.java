package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	@GetMapping //responde à requisição do tipo de get do http
	public ResponseEntity<List<Category>> findAll(){ //retorna uma resposta ao tentar acessar um dado
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "/{id}") //indica que a irl vai receber um id
	public ResponseEntity<Category> findById(@PathVariable Long id) { //para que a url aceite a entrada do id
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
