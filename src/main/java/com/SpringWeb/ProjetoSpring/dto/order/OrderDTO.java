package com.SpringWeb.ProjetoSpring.dto.order;

import java.time.Instant;

import com.SpringWeb.ProjetoSpring.dto.user.UserSimpleDTO;
import com.SpringWeb.ProjetoSpring.entities.Order;
import com.SpringWeb.ProjetoSpring.entities.enums.OrderStatus;


public class OrderDTO {

	private Long id;
	private Instant moment;
	private UserSimpleDTO user;
	private OrderStatus orderStatus;
	private String orderStatusDescription;

	public OrderDTO() {

	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		if (entity.getUser() != null) {
			this.user = new UserSimpleDTO(entity.getUser());
		}

		if (entity.getOrderStatus() != null) {
			this.orderStatus = entity.getOrderStatus();
			this.orderStatusDescription = entity.getOrderStatus().getDescription();

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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}

	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}

}
