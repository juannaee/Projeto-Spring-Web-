package com.SpringWeb.ProjetoSpring.dto;

import com.SpringWeb.ProjetoSpring.entities.User;

public class UserSimpleDTO {

	private Long id;
	private String name;
	private String email;

	public UserSimpleDTO() {

	}

	public UserSimpleDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
