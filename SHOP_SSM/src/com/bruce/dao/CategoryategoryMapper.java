package com.bruce.dao;

import java.util.List;

import com.bruce.model.Categoryategory;

public interface CategoryategoryMapper {
	int deleteByPrimaryKey(Integer uid);

	int insert(Categoryategory record);

	int insertSelective(Categoryategory record);

	Categoryategory selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Categoryategory record);

	int updateByPrimaryKey(Categoryategory record);

	List<Categoryategory> selectByParams(Categoryategory record);
}