package com.bruce.service;

import java.util.List;
import java.util.Map;

import com.bruce.model.Orders;

public interface OrdersService {
	int deleteByPrimaryKey(Integer uid);

	int insert(Orders record);

	int insertSelective(Orders record);

	Orders selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);

List<Orders> selectByParams(Map<String,Object> map);
	
	int countSelectByParams(Map<String,Object> map);
}
