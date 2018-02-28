package com.bruce.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bruce.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	SessionFactory sessionFactory;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(Long id) {
		T obj = findById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return (List<T>) getSession()
					.createQuery(
							"from " + clazz.getSimpleName()
									+ " where id in(:ids)")
					.setParameterList("ids", ids).list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T t) {
		return (T) getSession().merge(t);
	}

}
