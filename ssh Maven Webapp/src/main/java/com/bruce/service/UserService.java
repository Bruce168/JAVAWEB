package com.bruce.service;

import java.util.List;

import com.bruce.model.User;

public interface UserService {
	public List<User> list();
	
	public User findById(Long id);
}
