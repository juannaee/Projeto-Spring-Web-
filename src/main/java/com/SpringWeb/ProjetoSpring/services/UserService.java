package com.SpringWeb.ProjetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

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

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado com email: " + username);
		}

		return org.springframework.security.core.userdetails.User.builder().username(user.get().getEmail())
				.password(user.get().getPassword()).roles("USER").build();
	}

}
