package com.SpringWeb.ProjetoSpring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.services.UserService;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			// Teste para o UserRepository
			User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
			User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "abcdef");
			User u3 = new User(null, "teste de insertUser", "teste@testeinsert", "testeinsert", "testeinserteste");
			User u4 = new User(null, "teste de criptografia", "teste@testecriptografia", "testecriptografia",
					"testecriptografia");
			User u5 = new User(null, "Juan Guilherme", "juang@", "81996272911", "2711");

			userService.insertUser(u1);
			userService.insertUser(u2);
			userService.insertUser(u3);
			userService.insertUser(u4);
			userService.insertUser(u5);

		};

	}

}
