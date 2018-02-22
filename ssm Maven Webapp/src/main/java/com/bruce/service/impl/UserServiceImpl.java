package com.bruce.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.UserMapper;
import com.bruce.model.User;
import com.bruce.service.UserService;

@Service("userService")  
public class UserServiceImpl implements UserService {

	@Resource    
    private UserMapper userMapper;   
	
	@Override
	public User getUserById(int userId) {    
        return userMapper.queryByPrimaryKey(userId);    
    }   

	@Override
	public void insertUser(User user) {    
        userMapper.insertUser(user);    
    }    
    
	@Override
    public void addUser(User user) {    
        userMapper.insertUser(user);    
    }    
    
    @Override    
    public List<User> getAllUser() {    
        return userMapper.getAllUser();    
    }    

}
