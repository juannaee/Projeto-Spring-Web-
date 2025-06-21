package com.SpringWeb.ProjetoSpring.dto.user;

import java.util.List;

import com.SpringWeb.ProjetoSpring.dto.order.OrderInsertDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInsertDTO {

	@NotBlank(message = "Nome é obrigatório")
	private String name;
	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Informe um email válido")
	private String email;
	@NotBlank(message = "Telefone é obrigatório")
	@Size(min = 8, max = 20, message = "Telefone deve ter entre 8 e 20 caracteres")
	private String phone;
	@NotBlank(message = "Senha é obrigatória")
	@Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
	private String password;
	@Valid
	private List<OrderInsertDTO> orders;

	public List<OrderInsertDTO> getOrders() {
		return orders;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
