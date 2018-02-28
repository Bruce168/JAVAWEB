package com.bruce.service;

import java.util.List;

public interface BaseService<T> {
	public void save(T t);

	public void update(T t);

	public void delete(Long id);

	public T findById(Long id);

	public List<T> findAll();

	public List<T> findByIds(Long[] ids);

	public T merge(T t);
}
