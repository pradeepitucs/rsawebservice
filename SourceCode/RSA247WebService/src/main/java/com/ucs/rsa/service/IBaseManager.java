package com.ucs.rsa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseManager {

	<T> T get(Class<T> entityClass, Serializable id);

	Object get(String entityName, Serializable id);

	<T> T load(Class<T> entityClass, Serializable id);

	Object load(String entityName, Serializable id);

	<T> List<T> loadAll(Class<T> entityClass);

	void load(Object entity, Serializable id);

	void refresh(Object entity);

	boolean contains(Object entity);

	Serializable save(Object entity);

	Serializable save(String entityName, Object entity);

	void update(Object entity);

	void update(String entityName, Object entity);

	void saveOrUpdate(Object entity);

	void saveOrUpdate(String entityName, Object entity);

	void persist(Object entity);

	void persist(String entityName, Object entity);

	<T> T merge(T entity);

	<T> T merge(String entityName, T entity);

	void delete(Object entity);

	void delete(String entityName, Object entity);

	void deleteAll(Collection<?> entities);

	List<?> findByCriteria(DetachedCriteria criteria);

	List<?> findByCriteria(DetachedCriteria criteria, int firstResult,
			int maxResults);

	<T> List<T> findByExample(T exampleEntity);

	<T> List<T> findByExample(String entityName, T exampleEntity);

	<T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults);

	<T> List<T> findByExample(String entityName, T exampleEntity, int firstResult,
			int maxResults);
	
}
