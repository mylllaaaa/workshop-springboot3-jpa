package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service    //@Component //registra a classe como um componento do Spring - registra essa classe automaticamente com o @Autowired
public class ProductService {

	@Autowired
	private ProductRepository productRep;
	
	public List<Product> findAll(){
		return productRep.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRep.findById(id);
		return obj.get(); //retorna o obj User que estiver no Optional
	}
}
