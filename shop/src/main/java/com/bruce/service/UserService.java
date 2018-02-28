package com.bruce.service;

import com.bruce.model.User;

public interface UserService extends BaseService<User> {

	User findByCode(String code);
	
	User findByUsername(String username);

	User findFirstByParam(String paramName, String paramValue);
}