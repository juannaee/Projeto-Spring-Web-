package com.SpringWeb.ProjetoSpring.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWeb.ProjetoSpring.dto.OrderDTO;
import com.SpringWeb.ProjetoSpring.dto.OrderInsertDTO;
import com.SpringWeb.ProjetoSpring.entities.Order;
import com.SpringWeb.ProjetoSpring.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	private final OrderService orderService;

	public OrderResource(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = orderService.findAll();
		return ResponseEntity.ok(orders);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = orderService.findById(id);
		return ResponseEntity.ok(order);
	}

	@PostMapping
	public ResponseEntity<OrderDTO> insertOrder(@RequestBody OrderInsertDTO orderInsertDTO) {

		Order order = orderService.fromDTO(orderInsertDTO);
		Order createdOrder = orderService.insertOrder(order);
		OrderDTO response = orderService.toDTO(createdOrder);
		return ResponseEntity.ok(response);

	}

	@PutMapping("/{orderId}/assign-user/{userId}")
	public ResponseEntity<Void> assignUserToOrder(@PathVariable Long orderId, @PathVariable Long userId) {
		orderService.assignUserToOrder(orderId, userId);
		return ResponseEntity.noContent().build();
	}

}
