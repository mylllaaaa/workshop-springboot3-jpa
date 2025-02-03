package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service    //@Component //registra a classe como um componento do Spring - registra essa classe automaticamente com o @Autowired
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRep;
	
	public List<Category> findAll(){
		return categoryRep.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRep.findById(id);
		return obj.get(); //retorna o obj User que estiver no Optional
	}
}
