package com.SpringWeb.ProjetoSpring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			//Teste para o UserRepository
			User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
			User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "abcdef");

			userRepository.save(u1);
			userRepository.save(u2);

		};
		
	}

}
