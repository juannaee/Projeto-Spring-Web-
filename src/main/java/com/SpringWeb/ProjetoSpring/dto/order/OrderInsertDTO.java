package com.SpringWeb.ProjetoSpring.dto.order;

import java.time.Instant;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.entities.enums.OrderStatus;

import jakarta.validation.constraints.NotNull;

public class OrderInsertDTO {

	private Long id;
	private Instant moment = Instant.now();
	private User user;
	@NotNull(message = "O status do pedido é obrigatório")
	private OrderStatus orderStatus;

	public OrderInsertDTO() {

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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
