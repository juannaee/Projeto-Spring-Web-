package com.SpringWeb.ProjetoSpring.dto.user;

import java.util.List;
import java.util.stream.Collectors;

import com.SpringWeb.ProjetoSpring.dto.order.OrderSimpleDTO;
import com.SpringWeb.ProjetoSpring.entities.User;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private List<OrderSimpleDTO> orders;

	public UserDTO() {

	}

	public UserDTO(Long id, String name, String email, List<OrderSimpleDTO> orders) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.orders = orders;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();

		// Verifica se o usuário possui pedidos associados
		if (entity.getOrders() != null) {
			// Converte a lista de entidades Order para uma lista de OrderSimpleDTO
			// Utiliza stream para mapear cada Order em um OrderSimpleDTO,
			// coletando o resultado em uma nova lista
			this.orders = entity.getOrders().stream().map(OrderSimpleDTO::new).collect(Collectors.toList());
		}

	}

	public List<OrderSimpleDTO> getOrders() {
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
