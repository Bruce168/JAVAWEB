package com.bruce.dao;

import java.util.List;

import com.bruce.model.Orders;

public interface OrdersMapper {
	int deleteByPrimaryKey(Integer uid);

	int insert(Orders record);

	int insertSelective(Orders record);

	Orders selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);

	List<Orders> selectByParams(Orders record);
}