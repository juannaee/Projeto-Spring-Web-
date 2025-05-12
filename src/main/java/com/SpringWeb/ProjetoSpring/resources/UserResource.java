package com.SpringWeb.ProjetoSpring.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	private final UserService userService;
	
	
	 // Injetando via construtor
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}
	
	
	@PostMapping
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	
	
	
	

}
