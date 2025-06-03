package com.SpringWeb.ProjetoSpring.config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.services.UserService;

@Configuration
@Profile("test")
public class TestConfig {

	//@Autowired
	//UserService userService;

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			//User user = new User(null, "admin", "admin@", "81996272911", "2711");

			//userService.insertUser(user);

		};

	}

}
