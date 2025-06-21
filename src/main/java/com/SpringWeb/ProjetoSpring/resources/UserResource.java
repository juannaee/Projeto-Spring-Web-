package com.SpringWeb.ProjetoSpring.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWeb.ProjetoSpring.dto.user.BatchUserInsertResponse;
import com.SpringWeb.ProjetoSpring.dto.user.UserDTO;
import com.SpringWeb.ProjetoSpring.dto.user.UserInsertDTO;
import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserService userService;

	// Injetando via construtor
	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = users.stream().map(UserDTO::new).toList();
		return ResponseEntity.ok(usersDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(new UserDTO(user));

	}

	@PostMapping
	public ResponseEntity<UserDTO> insertUser(@RequestBody @Valid UserInsertDTO userInsertDTO) {
		User user = userService.fromDTO(userInsertDTO);
		User createdUser = userService.insertUser(user);
		return ResponseEntity.ok(new UserDTO(createdUser));

	}

	@PostMapping("/batch")
	public ResponseEntity<BatchUserInsertResponse> insertUsersBatch(@RequestBody List<UserInsertDTO> usersInsertDTO) {
		BatchUserInsertResponse response = userService.insertUsersBatch(usersInsertDTO);
		return ResponseEntity.ok(response);

	}

}
