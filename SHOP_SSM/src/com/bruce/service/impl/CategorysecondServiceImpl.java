package com.bruce.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bruce.dao.CategorysecondMapper;
import com.bruce.model.Categorysecond;
import com.bruce.service.CategorysecondService;

@Service("categorysecondService")
public class CategorysecondServiceImpl implements CategorysecondService {

	@Resource
	private CategorysecondMapper categorysecondMapper;

	public int deleteByPrimaryKey(Integer uid) {
		return categorysecondMapper.deleteByPrimaryKey(uid);
	}

	public int insert(Categorysecond record) {
		return categorysecondMapper.insert(record);
	}

	public int insertSelective(Categorysecond record) {
		return categorysecondMapper.insertSelective(record);
	}

	public Categorysecond selectByPrimaryKey(Integer uid) {
		return categorysecondMapper.selectByPrimaryKey(uid);
	}

	public int updateByPrimaryKeySelective(Categorysecond record) {
		return categorysecondMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Categorysecond record) {
		return categorysecondMapper.updateByPrimaryKey(record);
	}

	public List<Categorysecond> selectByParams(Map<String,Object> record) {
		return categorysecondMapper.selectByParams(record);
	}

}
