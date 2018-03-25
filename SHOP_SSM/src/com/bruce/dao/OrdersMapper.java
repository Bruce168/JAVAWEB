package com.bruce.dao;

import java.util.List;
import java.util.Map;

import com.bruce.model.Orders;

public interface OrdersMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Orders record);

	int insertSelective(Orders record);

	Orders selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);

	List<Orders> selectByParams(Map<String,Object> map);
	
	int countSelectByParams(Map<String,Object> map);
}