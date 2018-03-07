package com.bruce.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.ProductMapper;
import com.bruce.model.Product;
import com.bruce.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;

	public int deleteByPrimaryKey(Integer uid) {
		return productMapper.deleteByPrimaryKey(uid);
	}

	public int insert(Product record) {
		return productMapper.insert(record);
	}

	public int insertSelective(Product record) {
		return productMapper.insertSelective(record);
	}

	public Product selectByPrimaryKey(Integer uid) {
		return productMapper.selectByPrimaryKey(uid);
	}

	public int updateByPrimaryKeySelective(Product record) {
		return productMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Product record) {
		return productMapper.updateByPrimaryKey(record);
	}

	public List<Product> selectByParams(Map<String,Object> map) {
		return productMapper.selectByParams(map);
	}

	public List<Product> selectByCid(Map<String,Object> map) {
		return productMapper.selectByCid(map);
	}

	public Integer countSelectByCid(Map<String, Object> map) {
		return productMapper.countSelectByCid(map);
	}
	
	public List<Product> selectByCsid(Map<String, Object> map) {
		return productMapper.selectByCsid(map);
	}

	public Integer countSelectByCsid(Map<String, Object> map) {
		return productMapper.countSelectByCsid(map);
	}
}
