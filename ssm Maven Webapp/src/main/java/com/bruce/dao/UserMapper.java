package com.bruce.dao;

import java.util.List;
import java.util.Map;

import com.bruce.model.User;

public interface UserMapper {
	public User queryByPrimaryKey(Integer id);

	public List<User> queryUserByBatch(Map<String, Object> params);

	public void insertUser(User user);

	public void insertUserByBatch(List<User> list);

	public void deleteByPrimaryKey(Integer id);

	public void delteUserByBatch(Map<String, Object> params);

	public void updateByPrimaryKey(Integer id);

	public List<User> getAllUser();
}
