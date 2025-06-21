package com.SpringWeb.ProjetoSpring.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {

	WAITING_PAYMENT(1, "Esperando por pagamento"), PAID(2, "Pago"), SHIPPED(3, "Enviado"), DELIVERED(4, "Entregue"),
	CANCEL(5, "Cancelado");

	private int code;
	private String description;

	private OrderStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	public String getDescription() {
		return description;
	}

	// Permite que o cliente envie "pago" e a API entenda como PAID
	@JsonCreator
	public static OrderStatus fromDescription(String value) {
		for (OrderStatus status : OrderStatus.values()) {
			if (status.getDescription().equalsIgnoreCase(value) || status.name().equalsIgnoreCase(value)) {
				return status;
			}

		}
		throw new IllegalArgumentException("Status inválido" + value);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}

		}
		throw new IllegalArgumentException("Código do OrderStatus é invalido" + code);
	}

}
