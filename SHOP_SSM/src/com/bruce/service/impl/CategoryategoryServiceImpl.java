package com.bruce.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.CategoryategoryMapper;
import com.bruce.model.Categoryategory;
import com.bruce.service.CategoryategoryService;

@Service("categoryategoryService")
public class CategoryategoryServiceImpl implements CategoryategoryService {

	@Resource
	private CategoryategoryMapper categoryategoryMapper;

	public int deleteByPrimaryKey(Integer uid) {
		return categoryategoryMapper.deleteByPrimaryKey(uid);
	}

	public int insert(Categoryategory record) {
		return categoryategoryMapper.insert(record);
	}

	public int insertSelective(Categoryategory record) {
		return categoryategoryMapper.insertSelective(record);
	}

	public Categoryategory selectByPrimaryKey(Integer uid) {
		return categoryategoryMapper.selectByPrimaryKey(uid);
	}

	public int updateByPrimaryKeySelective(Categoryategory record) {
		return categoryategoryMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Categoryategory record) {
		return categoryategoryMapper.updateByPrimaryKey(record);
	}

	public List<Categoryategory> selectByParams(Categoryategory record) {
		return categoryategoryMapper.selectByParams(record);
	}

}
