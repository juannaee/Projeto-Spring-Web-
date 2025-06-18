package com.SpringWeb.ProjetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringWeb.ProjetoSpring.dto.user.BatchUserInsertResponse;
import com.SpringWeb.ProjetoSpring.dto.user.UserDTO;
import com.SpringWeb.ProjetoSpring.dto.user.UserInsertDTO;
import com.SpringWeb.ProjetoSpring.entities.Order;
import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.exceptions.ResourceNotFoundException;
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

	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado."));
	}

	public User insertUser(User user) {
		boolean emailExists = userRepository.findAll().stream()
				.anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));

		if (emailExists) {
			throw new DataIntegrityViolationException("E-mail já cadastrado: " + user.getEmail());
		}

		// criptografia de senhas
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);

		return userRepository.save(user);
	}

	// Insere uma lista de usuarios enviadas pelo cliente.
	public BatchUserInsertResponse insertUsersBatch(List<UserInsertDTO> usersDTOs) {

		BatchUserInsertResponse response = new BatchUserInsertResponse();

		for (UserInsertDTO dto : usersDTOs) {

			try {

				User user = fromDTO(dto);
				User created = insertUser(user);
				response.addInsertedUser(new UserDTO(created));
			} catch (DataIntegrityViolationException e) {
				response.addFailedUser("Email já cadastrado:" + dto.getEmail());
			} catch (Exception e) {
				response.addFailedUser("Erro ao cadastrar " + dto.getEmail() + ": " + e.getMessage());
			}

		}

		return response;
	}

	// Converte o que o cliente enviou (DTO) para a entidade que o banco entende.
	public User fromDTO(UserInsertDTO dto) {
		User user = new User(null, dto.getName(), dto.getEmail(), dto.getPhone(), dto.getPassword());
		if (dto.getOrders() != null) {
			dto.getOrders().forEach(orderDto -> {
				Order order = new Order(null, orderDto.getMoment(), user);
				user.getOrders().add(order);
			});

		}

		return user;

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
