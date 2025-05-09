package com.SpringWeb.ProjetoSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWeb.ProjetoSpring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User user = new User(1L, "Marcos", "Marcos@", "8199632726","12345" );
		return ResponseEntity.ok().body(user);
		
		
	} 

}
