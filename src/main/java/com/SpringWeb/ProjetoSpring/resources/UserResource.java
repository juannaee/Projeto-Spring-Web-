package com.SpringWeb.ProjetoSpring.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWeb.ProjetoSpring.dto.BatchUserInsertResponse;
import com.SpringWeb.ProjetoSpring.dto.UserDTO;
import com.SpringWeb.ProjetoSpring.dto.UserInsertDTO;
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
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(user);

	}

	@PostMapping
	public ResponseEntity<UserDTO> insertUser(@RequestBody UserInsertDTO userInsertDTO) {
		User user = userService.fromDTO(userInsertDTO);
		User createdUser = userService.insertUser(user);
		UserDTO response = userService.toDTO(createdUser);
		return ResponseEntity.ok(response);

	}

	@PostMapping("/batch")
	public ResponseEntity<BatchUserInsertResponse> insertUsersBatch(@RequestBody List<UserInsertDTO> usersInsertDTO) {
		BatchUserInsertResponse response = userService.insertUsersBatch(usersInsertDTO);
		return ResponseEntity.ok(response);

	}

}
