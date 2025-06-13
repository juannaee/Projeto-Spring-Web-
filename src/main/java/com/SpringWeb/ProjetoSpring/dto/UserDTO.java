package com.SpringWeb.ProjetoSpring.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.SpringWeb.ProjetoSpring.entities.User;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private List<OrderDTO> orders;

	public UserDTO() {

	}

	public UserDTO(Long id, String name, String email, List<OrderDTO> orders) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.orders = orders;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		if (entity.getOrders() != null) {
			this.orders = entity.getOrders().stream().map(OrderDTO::new).collect(Collectors.toList());
		}

	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
