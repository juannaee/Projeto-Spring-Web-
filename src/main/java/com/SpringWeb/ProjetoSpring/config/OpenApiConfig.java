package com.SpringWeb.ProjetoSpring.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Projeto Spring web API", version = "1.0", description = "Projeto Spring Web com Spring Boot: Aplicação web com Spring Boot, utilizando Maven, H2, PostgreSQL, Heroku, e Postman. Foco em APIs RESTful, boas práticas de desenvolvimento e deploy contínuo.")

)
public class OpenApiConfig {

}
