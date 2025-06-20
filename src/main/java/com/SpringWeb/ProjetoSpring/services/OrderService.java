package com.SpringWeb.ProjetoSpring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringWeb.ProjetoSpring.dto.order.OrderInsertDTO;
import com.SpringWeb.ProjetoSpring.entities.Order;
import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.exceptions.ResourceNotFoundException;
import com.SpringWeb.ProjetoSpring.repositories.OrderRepository;
import com.SpringWeb.ProjetoSpring.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final UserRepository userRepository;

	public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		return orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ordem com id: " + id + " não encontrado "));
	}

	public Order insertOrder(Order order) {
		return orderRepository.save(order);
	}

	// Vincula um user a uma ordem

	@Transactional
	public void assignUserToOrder(Long orderId, Long userId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Ordem não encontrada"));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

		order.setUser(user);
		orderRepository.save(order);

	}

	// Converte o que o cliente enviou (DTO) para a entidade que o banco entende.
	public Order fromDTO(OrderInsertDTO dto) {
		User user;

		if (dto.getUser() == null) {
			user = userRepository.findById(999L)
					.orElseThrow(() -> new ResourceNotFoundException("Usuário genérico não encontrado"));
		} else {
			user = userRepository.findById(dto.getUser().getId())
					.orElseThrow(() -> new ResourceNotFoundException("Usuário genérico não encontrado"));
		}

		Order order = new Order();
		order.setMoment(dto.getMoment());
		order.setOrderStatus(dto.getOrderStatus());
		order.setUser(user);

		return order;

	}

}
