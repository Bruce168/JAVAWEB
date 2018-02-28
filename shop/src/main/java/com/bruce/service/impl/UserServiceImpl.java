package com.bruce.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.UserDao;
import com.bruce.model.User;
import com.bruce.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findFirstByParam(String paramName, String paramValue) {
		return userDao.findFirstByParam(paramName, paramValue);
	}

}
