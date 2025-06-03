package com.SpringWeb.ProjetoSpring.dto;

import java.util.ArrayList;
import java.util.List;

import com.SpringWeb.ProjetoSpring.entities.User;

public class BatchUserInsertResponse {

	private List<User> insertedUsers = new ArrayList<>();
	private List<String> failedUsers = new ArrayList<>();

	public List<User> getInsertedUsers() {
		return insertedUsers;

	}

	public void setInsertedUsers(List<User> insertedUsers) {
		this.insertedUsers = insertedUsers;

	}

	public List<String> getFailedUser() {
		return failedUsers;
	}

	public void setFailedUser(List<String> failedUser) {
		this.failedUsers = failedUser;
	}

	public void addInsertedUser(User user) {
		this.insertedUsers.add(user);

	}

	public void addFailedUser(String reason) {
		this.failedUsers.add(reason);
	}
}
