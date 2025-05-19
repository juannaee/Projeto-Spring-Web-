package com.SpringWeb.ProjetoSpring.resources;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return userService.findById(id).<ResponseEntity<?>>map(user -> ResponseEntity.ok(user)).orElseGet(
				() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID " + id + " Não encontrado."));

	}

	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user) {

		User createdUser = userService.insertUser(user);
		return ResponseEntity.ok(createdUser);

	}

}
