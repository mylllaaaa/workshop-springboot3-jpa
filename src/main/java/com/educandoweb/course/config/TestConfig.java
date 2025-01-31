package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test") //pra configurar que é para testes - para popular o banco de dados com objs
public class TestConfig implements CommandLineRunner {

	@Autowired //vai resolver o problema da dependência
	private UserRepository userRep;
	
	@Autowired
	private OrderRepository orderRep;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Victra Barca-Julii", "bestmomofalltimes@gmail.com", "988888888","123456789");
		User u2 = new User(null, "Sevro Barca-Julii", "howllernumber1@gmail.com", "977777777","987456321");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRep.saveAll(Arrays.asList(u1, u2));
		orderRep.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
