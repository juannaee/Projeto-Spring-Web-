package com.SpringWeb.ProjetoSpring.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.SpringWeb.ProjetoSpring.dto.orderStatus.OrderStatusDTO;
import com.SpringWeb.ProjetoSpring.entities.enums.OrderStatus;

@Service
public class OrderStatusService {

	public List<OrderStatusDTO> getAllStatuses() {
		return Arrays.stream(OrderStatus.values())
				.map(status -> new OrderStatusDTO(status.getCode(), status.name(), status.getDescription()))
				.collect(Collectors.toList());

	}

}
