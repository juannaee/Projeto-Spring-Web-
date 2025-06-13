package com.SpringWeb.ProjetoSpring.dto;

import java.time.Instant;

import com.SpringWeb.ProjetoSpring.entities.Order;
import com.SpringWeb.ProjetoSpring.entities.User;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private User user;

	public OrderDTO() {

	}

	public OrderDTO(Long id, Instant moment, User user) {
		this.id = id;
		this.moment = moment;
		this.user = user;

	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.user = entity.getUser();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
