package com.SpringWeb.ProjetoSpring.dto;

import java.time.Instant;

public class OrderInsertDTO {

	private Long id;
	private Instant moment;

	public OrderInsertDTO() {

	}

	public OrderInsertDTO(Long id, Instant moment) {
		this.id = id;
		this.moment = moment;

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
