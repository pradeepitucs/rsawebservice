package com.ucs.rsa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.daos.BaseDAO;
import com.ucs.rsa.service.BaseService;

@Service
public class DefaultBaseService implements BaseService {

	// TODO : Default Base Service is having dao layer methods it not standard  
	
	@Autowired
	@Qualifier("defaultBaseDAO")
	private BaseDAO baseDAO;

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return getBaseDAO().get(entityClass, id);
	}

	@Override
	public Object get(String entityName, Serializable id) {
		return getBaseDAO().get(entityName, id);
	}

	@Override
	public <T> T load(Class<T> entityClass, Serializable id) {
		return getBaseDAO().load(entityClass, id);
	}

	@Override
	public Object load(String entityName, Serializable id) {
		return getBaseDAO().load(entityName, id);
	}

	@Override
	public <T> List<T> loadAll(final Class<T> entityClass) {
		return getBaseDAO().loadAll(entityClass);
	}

	@Override
	public void load(final Object entity, final Serializable id) {
		getBaseDAO().load(entity, id);
	}

	@Override
	public void refresh(final Object entity) {
		getBaseDAO().refresh(entity);
	}

	@Override
	public boolean contains(final Object entity) {
		return getBaseDAO().contains(entity);
	}

	// -------------------------------------------------------------------------
	// Convenience methods for storing individual objects
	// -------------------------------------------------------------------------

	@Override
	public Serializable save(final Object entity) {
		return getBaseDAO().save(entity);
	}

	@Override
	public Serializable save(final String entityName, final Object entity) {
		return getBaseDAO().save(entityName, entity);
	}

	@Override
	public void update(Object entity) {
		getBaseDAO().update(entity);
	}

	@Override
	public void update(String entityName, Object entity) {
		getBaseDAO().update(entityName, entity);
	}

	@Override
	public void saveOrUpdate(final Object entity) {
		getBaseDAO().saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdate(final String entityName, final Object entity) {
		getBaseDAO().saveOrUpdate(entityName, entity);
	}

	@Override
	public void persist(final Object entity) {
		getBaseDAO().persist(entity);
	}

	@Override
	public void persist(final String entityName, final Object entity) {
		getBaseDAO().persist(entityName, entity);
	}

	@Override
	public <T> T merge(final T entity) {
		return getBaseDAO().merge(entity);
	}

	@Override
	public <T> T merge(final String entityName, final T entity) {
		return getBaseDAO().merge(entityName, entity);
	}

	@Override
	public void delete(Object entity) {
		getBaseDAO().delete(entity);
	}

	@Override
	public void delete(String entityName, Object entity) {
		getBaseDAO().delete(entityName, entity);
	}

	@Override
	public void deleteAll(final Collection<?> entities) {
		getBaseDAO().deleteAll(entities);
	}

	// -------------------------------------------------------------------------
	// Convenience finder methods for detached criteria
	// -------------------------------------------------------------------------

	@Override
	public List<?> findByCriteria(DetachedCriteria criteria) {
		return getBaseDAO().findByCriteria(criteria);
	}

	@Override
	public List<?> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults) {
		return getBaseDAO().findByCriteria(criteria, firstResult, maxResults);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity) {
		return getBaseDAO().findByExample(exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(String entityName, T exampleEntity) {
		return getBaseDAO().findByExample(entityName, exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults) {
		return getBaseDAO().findByExample(exampleEntity, firstResult, maxResults);
	}

	@Override
	public <T> List<T> findByExample(final String entityName, final T exampleEntity, final int firstResult,
			final int maxResults) {
		return getBaseDAO().findByExample(entityName, exampleEntity, firstResult, maxResults);
	}

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

}
