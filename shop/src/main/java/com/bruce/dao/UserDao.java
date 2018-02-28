package com.bruce.dao;


import com.bruce.model.User;

public interface UserDao extends BaseDao<User>{

	User findByCode(String code);

	User findByUsername(String username);

	User findFirstByParam(String paramName, String paramValue);

	
}
