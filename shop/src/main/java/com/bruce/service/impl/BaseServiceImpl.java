package com.bruce.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bruce.dao.BaseDao;
import com.bruce.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Resource
	private BaseDao<T> baseDao;

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(Long id) {
		baseDao.delete(id);
	}

	@Override
	public T findById(Long id) {
		return baseDao.findById(id);
	}

	@Override
	public List<T> findAll() {
		return baseDao.findAll();
	}

	@Override
	public List<T> findByIds(Long[] ids) {
		return baseDao.findByIds(ids);
	}

	@Override
	public T merge(T t) {
		return baseDao.merge(t);
	}

}
