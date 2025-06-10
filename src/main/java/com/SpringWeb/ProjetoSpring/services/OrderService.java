package com.SpringWeb.ProjetoSpring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringWeb.ProjetoSpring.dto.OrderDTO;
import com.SpringWeb.ProjetoSpring.dto.OrderInsertDTO;
import com.SpringWeb.ProjetoSpring.entities.Order;
import com.SpringWeb.ProjetoSpring.exceptions.ResourceNotFoundException;
import com.SpringWeb.ProjetoSpring.repositories.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
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

	// Converte o que o cliente enviou (DTO) para a entidade que o banco entende.
	public Order fromDTO(OrderInsertDTO dto) {
		return new Order(null, dto.getMoment());

	}

	// Converte o User para o DTO de saída (UserDTO)
	public OrderDTO toDTO(Order order) {
		return new OrderDTO(order.getId(), order.getMoment());
	}

}
