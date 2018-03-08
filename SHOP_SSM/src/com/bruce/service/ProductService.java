package com.bruce.service;

import java.util.List;
import java.util.Map;

import com.bruce.model.Product;

public interface ProductService {
	int deleteByPrimaryKey(Integer uid);

	int insert(Product record);

	int insertSelective(Product record);

	Product selectByPrimaryKey(Integer pid);

	int updateByPrimaryKeySelective(Product record);

	int updateByPrimaryKey(Product record);

	List<Product> selectByParams(Map<String, Object> map);

	List<Product> selectByCid(Map<String, Object> map);

	Integer countSelectByCid(Map<String, Object> map);
	
	List<Product> selectByCsid(Map<String, Object> map);

	Integer countSelectByCsid(Map<String, Object> map);
}
