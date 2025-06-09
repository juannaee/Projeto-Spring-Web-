package com.SpringWeb.ProjetoSpring.dto;

import java.util.ArrayList;
import java.util.List;


public class BatchUserInsertResponse {

	private List<UserDTO> insertedUsers = new ArrayList<>();
	private List<String> failedUsers = new ArrayList<>();

	public List<UserDTO> getInsertedUsers() {
		return insertedUsers;

	}

	public void setInsertedUsers(List<UserDTO> insertedUsers) {
		this.insertedUsers = insertedUsers;

	}

	public List<String> getFailedUser() {
		return failedUsers;
	}

	public void setFailedUser(List<String> failedUser) {
		this.failedUsers = failedUser;
	}

	public void addInsertedUser(UserDTO user) {
		this.insertedUsers.add(user);

	}

	public void addFailedUser(String reason) {
		this.failedUsers.add(reason);
	}
}
