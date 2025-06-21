package com.SpringWeb.ProjetoSpring.dto.order;

import java.time.Instant;

import com.SpringWeb.ProjetoSpring.entities.User;
import com.SpringWeb.ProjetoSpring.entities.enums.OrderStatus;

import io.swagger.v3.oas.annotations.media.Schema;

public class OrderInsertDTO {

	private Long id;
	private Instant moment;
	private User user;
	@Schema(description = "Status do pedido. Aceita: PAID, WAITING_PAYMENT, SHIPPED, DELIVERED, CANCELED", example = "PAID")
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
