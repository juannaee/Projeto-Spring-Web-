package com.SpringWeb.ProjetoSpring.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	// Injetando via construtor
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User insertUser(User user) {
		// teste de regra para verificar se email existe
		boolean emailExists = userRepository.findAll().stream()
				.anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));

		if (emailExists) {
			throw new DataIntegrityViolationException("E-mail já cadastrado: " + user.getEmail());
		}

		// teste de criptografia de senhas
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		System.out.println("teste de criptografar senhas passou");

		return userRepository.save(user);
	}

}
