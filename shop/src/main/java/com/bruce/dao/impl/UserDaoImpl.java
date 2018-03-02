package com.bruce.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bruce.dao.UserMapper;
import com.bruce.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserMapper {

	@Override
	public User findByCode(String code) {
		
		@SuppressWarnings("unchecked")
		List<User> users= this.getSession().createQuery("from User where code=:code").setString("code", code).list();
		
		return users != null ? users.size() > 0 ? users.get(0): null : null;
	}

	@Override
	public User findByUsername(String username){
		
		@SuppressWarnings("unchecked")
		List<User> users= this.getSession().createQuery("from User where username=:username").setString("username", username).list();
		
		return users != null ? users.size() > 0 ? users.get(0): null : null;
	}
	
	@Override
	public User findFirstByParam(String paramName,String paramValue){
		@SuppressWarnings("unchecked")
		List<User> users= this.getSession().createQuery("from User where "+paramName+"=:"+paramName+"").setString(paramName, paramValue).list();
		
		return users != null ? users.size() > 0 ? users.get(0): null : null;
	}
}
