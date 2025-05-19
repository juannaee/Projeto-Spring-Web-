package com.SpringWeb.ProjetoSpring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import com.SpringWeb.ProjetoSpring.services.UserService;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			

		};

	}

}
