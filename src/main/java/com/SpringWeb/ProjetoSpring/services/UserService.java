package com.SpringWeb.ProjetoSpring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	// Injetando via construtor
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}

}
