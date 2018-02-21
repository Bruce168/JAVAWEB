package com.bruce.service;

import java.util.ArrayList;
import java.util.List;

import com.bruce.model.User;

public class UserService {

	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();

		users.add(new User(1l, "Bruce", "Boy", "America"));
		users.add(new User(2l, "Jack", "Boy", "England"));

		return users;
	}
}
