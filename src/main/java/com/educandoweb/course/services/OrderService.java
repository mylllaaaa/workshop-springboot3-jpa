package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service    //@Component //registra a classe como um componento do Spring - registra essa classe automaticamente com o @Autowired
public class OrderService {

	@Autowired
	private OrderRepository orderRep;
	
	public List<Order> findAll(){
		return orderRep.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = orderRep.findById(id);
		return obj.get(); //retorna o obj Order que estiver no Optional
	}
}
