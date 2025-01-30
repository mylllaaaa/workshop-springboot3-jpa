package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test") //pra configurar que é para testes - para popular o banco de dados com objs
public class TestConfig implements CommandLineRunner {

	@Autowired //vai resolver o problema da dependência
	private UserRepository userRep;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Victra Barca-Julii", "bestmomofalltimes@gmail.com", "988888888","123456789");
		User u2 = new User(null, "Sevro Barca-Julii", "howllernumber1@gmail.com", "977777777","987456321");

		userRep.saveAll(Arrays.asList(u1, u2));
	}
	
}
