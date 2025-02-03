package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderItemRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test") //pra configurar que é para testes - para popular o banco de dados com objs
public class TestConfig implements CommandLineRunner {

	@Autowired //vai resolver o problema da dependência
	private UserRepository userRep;
	
	@Autowired
	private OrderRepository orderRep;
	
	@Autowired
	private CategoryRepository catRep;
	
	@Autowired
	private ProductRepository proRep;
	
	@Autowired
	private OrderItemRepository oiRep;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		catRep.saveAll(Arrays.asList(cat1,cat2,cat3));
		proRep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		proRep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		User u1 = new User(null, "Victra Barca-Julii", "bestmomofalltimes@gmail.com", "988888888","123456789");
		User u2 = new User(null, "Sevro Barca-Julii", "howllernumber1@gmail.com", "977777777","987456321");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRep.saveAll(Arrays.asList(u1, u2));
		orderRep.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		oiRep.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}
	
}
