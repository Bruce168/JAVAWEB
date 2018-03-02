package com.bruce.dao;

import java.util.List;

import com.bruce.model.Orderitem;

public interface OrderitemMapper  {
	int deleteByPrimaryKey(Integer uid);

	int insert(Orderitem record);

	int insertSelective(Orderitem record);

	Orderitem selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Orderitem record);

	int updateByPrimaryKey(Orderitem record);
	
	List<Orderitem> selectByParams(Orderitem record);
}