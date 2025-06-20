package com.SpringWeb.ProjetoSpring.config;

import org.springframework.beans.factory.annotation.Autowired;

//import java.time.Instant;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//import com.SpringWeb.ProjetoSpring.entities.Order;
//import com.SpringWeb.ProjetoSpring.services.OrderService;
//import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.services.UserService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	UserService userService;
	// @Autowired
	// OrderService orderService;

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			//User user = new User(null, "desconhecido", "@", "81996272911", "2711");

			// userService.insertUser(user);

			// Order order = new Order(null, Instant.now());

			// orderService.insertOrder(order);
		};

	}

}
