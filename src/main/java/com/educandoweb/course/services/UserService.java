package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service    //@Component //registra a classe como um componento do Spring - registra essa classe automaticamente com o @Autowired
public class UserService {

	@Autowired
	private UserRepository userRep;
	
	public List<User> findAll(){
		return userRep.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRep.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //retorna o obj User que estiver no Optional
	}
	
	public User insert(User obj) {
		return userRep.save(obj);
	}
	
	public void delete(Long id) {
		userRep.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = userRep.getReferenceById(id); //Esse método retorna uma referência à entidade com o ID fornecido, mas não busca os dados do banco de dados imediatamente. Em vez disso, ele cria um proxy (um objeto "falso") que representa a entidade.
		updateData(entity, obj);
		return userRep.save(entity);
	}
	
	public void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone()); //atualizda só os dados pessoais
	}
}
