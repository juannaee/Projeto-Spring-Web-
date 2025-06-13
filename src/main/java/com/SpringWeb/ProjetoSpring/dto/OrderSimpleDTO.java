package com.SpringWeb.ProjetoSpring.dto;

import java.time.Instant;

import com.SpringWeb.ProjetoSpring.entities.Order;

public class OrderSimpleDTO {

	private Long id;
	private Instant moment;

	public OrderSimpleDTO() {

	}

	public OrderSimpleDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();

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
