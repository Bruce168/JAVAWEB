package com.bruce.dao;

import java.util.List;

import com.bruce.model.User;

public interface UserMapper  {
	int deleteByPrimaryKey(Integer uid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	List<User> selectByParams(User record);
}