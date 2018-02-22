package com.bruce.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.UserMapper;
import com.bruce.model.User;
import com.bruce.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	public User findById(long id) {

		return userMapper.selectByPrimaryKey(id);
	}

}
