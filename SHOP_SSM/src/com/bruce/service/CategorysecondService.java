package com.bruce.service;

import java.util.List;
import java.util.Map;

import com.bruce.model.Categorysecond;

public interface CategorysecondService {
	int deleteByPrimaryKey(Integer uid);

	int insert(Categorysecond record);

	int insertSelective(Categorysecond record);

	Categorysecond selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(Categorysecond record);

	int updateByPrimaryKey(Categorysecond record);

	List<Categorysecond> selectByParams(Map<String,Object> record);
}
