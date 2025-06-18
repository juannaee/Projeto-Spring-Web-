package com.SpringWeb.ProjetoSpring.dto.order;

import java.time.Instant;

import com.SpringWeb.ProjetoSpring.dto.user.UserSimpleDTO;
import com.SpringWeb.ProjetoSpring.entities.Order;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private UserSimpleDTO user;

	public OrderDTO() {

	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		if (entity.getUser() != null) {
			this.user = new UserSimpleDTO(entity.getUser());
		}

	}

	public UserSimpleDTO getUser() {
		return user;
	}

	public void setUser(UserSimpleDTO user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

}
