package com.SpringWeb.ProjetoSpring.dto;

import java.time.Instant;

import com.SpringWeb.ProjetoSpring.entities.User;

public class OrderInsertDTO {

	private Long id;
	private Instant moment;
	private User user;

	public OrderInsertDTO() {

	}

	public OrderInsertDTO(Long id, Instant moment, User user) {
		this.id = id;
		this.moment = moment;
		this.user = user;

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
