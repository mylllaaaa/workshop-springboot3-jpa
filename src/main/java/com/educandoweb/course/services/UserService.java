package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service    //@Component //registra a classe como um componento do Spring - registra essa classe automaticamente com o @Autowired
public class UserService {

	@Autowired
	private UserRepository userRep;
	
	public List<User> findAll(){
		return userRep.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRep.findById(id);
		return obj.get(); //retorna o obj User que estiver no Optional
	}
	
	public User insert(User obj) {
		return userRep.save(obj);
	}
	
	public void delete(Long id) {
		userRep.deleteById(id);
	}
}
