package com.bruce.dao;

import java.util.List;
import java.util.Map;

import com.bruce.model.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(Integer uid);

	int insert(Product record);

	int insertSelective(Product record);

	Product selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Product record);

	int updateByPrimaryKey(Product record);

	List<Product> selectByParams(Map<String,Object> map);
}