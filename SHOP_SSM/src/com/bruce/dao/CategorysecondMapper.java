package com.bruce.dao;

import java.util.List;

import com.bruce.model.Categorysecond;

public interface CategorysecondMapper  {
	int deleteByPrimaryKey(Integer uid);

	int insert(Categorysecond record);

	int insertSelective(Categorysecond record);

	Categorysecond selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Categorysecond record);

	int updateByPrimaryKey(Categorysecond record);

	List<Categorysecond> selectByParams(Categorysecond record);
}