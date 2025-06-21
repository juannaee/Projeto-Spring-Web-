package com.SpringWeb.ProjetoSpring.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWeb.ProjetoSpring.dto.orderStatus.OrderStatusDTO;
import com.SpringWeb.ProjetoSpring.services.OrderStatusService;

@RestController
@RequestMapping("/order-status")
public class OrderStatusResource {

	private final OrderStatusService orderStatusService;

	public OrderStatusResource(OrderStatusService orderStatusService) {
		this.orderStatusService = orderStatusService;
	}

	
	@GetMapping
	public ResponseEntity<List<OrderStatusDTO>> getAllOrderStatuses() {
		List<OrderStatusDTO> statuses = orderStatusService.getAllStatuses();
		return ResponseEntity.ok(statuses);

	}

}
