package com.bruce.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.UserMapper;
import com.bruce.model.User;
import com.bruce.service.UserService;
import com.bruce.utils.MailUitls;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	public int deleteByPrimaryKey(Integer uid) {
		return userMapper.deleteByPrimaryKey(uid);
	}

	public int insert(User record) {
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		MailUitls.sendMail(record.getEmail(), record.getCode());
		
		return userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	public List<User> selectByParams(User record) {
		return userMapper.selectByParams(record);
	}

}
