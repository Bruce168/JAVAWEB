package com.bruce.dao;

import java.util.List;

import com.bruce.model.Adminuser;

public interface AdminuserMapper  {
	int deleteByPrimaryKey(Integer uid);

	int insert(Adminuser record);

	int insertSelective(Adminuser record);

	Adminuser selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Adminuser record);

	int updateByPrimaryKey(Adminuser record);
	
	List<Adminuser> selectByParams(Adminuser record);
}