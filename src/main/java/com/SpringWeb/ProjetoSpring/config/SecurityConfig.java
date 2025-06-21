package com.SpringWeb.ProjetoSpring.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.SpringWeb.ProjetoSpring.services.UserService;

@Configuration
public class SecurityConfig {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.userService = userService;
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**").disable())
				.headers(headers -> headers.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/h2-console/**", "/login", "/public/**", "/swagger-ui/**", "/v3/api-docs/**",
								"/swagger-ui.html", "/swagger-resources/**", "/webjars/**")
						.permitAll().requestMatchers(HttpMethod.POST, "/users", "/users/**").permitAll()
						.requestMatchers(HttpMethod.GET, "/users").permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").permitAll()).httpBasic(withDefaults());

		return http.build();
	}
}
