package com.ucs.rsa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ucs.rsa.dao.IBaseRepository;

@Component
public class BaseManagerImpl implements IBaseManager {

	@Resource(name = "baseRepository")
	private IBaseRepository repository;

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return getRepository().get(entityClass, id);
	}

	@Override
	public Object get(String entityName, Serializable id) {
		return getRepository().get(entityName, id);
	}

	@Override
	public <T> T load(Class<T> entityClass, Serializable id) {
		return getRepository().load(entityClass, id);
	}

	@Override
	public Object load(String entityName, Serializable id) {
		return getRepository().load(entityName, id);
	}

	@Override
	public <T> List<T> loadAll(final Class<T> entityClass) {
		return getRepository().loadAll(entityClass);
	}

	@Override
	public void load(final Object entity, final Serializable id) {
		getRepository().load(entity, id);
	}

	@Override
	public void refresh(final Object entity) {
		getRepository().refresh(entity);
	}

	@Override
	public boolean contains(final Object entity) {
		return getRepository().contains(entity);
	}

	// -------------------------------------------------------------------------
	// Convenience methods for storing individual objects
	// -------------------------------------------------------------------------

	@Override
	public Serializable save(final Object entity) {
		return getRepository().save(entity);
	}

	@Override
	public Serializable save(final String entityName, final Object entity) {
		return getRepository().save(entityName, entity);
	}

	@Override
	public void update(Object entity) {
		getRepository().update(entity);
	}

	@Override
	public void update(String entityName, Object entity) {
		getRepository().update(entityName, entity);
	}

	@Override
	public void saveOrUpdate(final Object entity) {
		getRepository().saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdate(final String entityName, final Object entity) {
		getRepository().saveOrUpdate(entityName, entity);
	}

	@Override
	public void persist(final Object entity) {
		getRepository().persist(entity);
	}

	@Override
	public void persist(final String entityName, final Object entity) {
		getRepository().persist(entityName, entity);
	}

	@Override
	public <T> T merge(final T entity) {
		return getRepository().merge(entity);
	}

	@Override
	public <T> T merge(final String entityName, final T entity) {
		return getRepository().merge(entityName, entity);
	}

	@Override
	public void delete(Object entity) {
		getRepository().delete(entity);
	}

	@Override
	public void delete(String entityName, Object entity) {
		getRepository().delete(entityName, entity);
	}

	@Override
	public void deleteAll(final Collection<?> entities) {
		getRepository().deleteAll(entities);
	}

	// -------------------------------------------------------------------------
	// Convenience finder methods for detached criteria
	// -------------------------------------------------------------------------

	@Override
	public List<?> findByCriteria(DetachedCriteria criteria) {
		return getRepository().findByCriteria(criteria);
	}

	@Override
	public List<?> findByCriteria(final DetachedCriteria criteria,
			final int firstResult, final int maxResults) {
		return getRepository().findByCriteria(criteria, firstResult,
				maxResults);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity) {
		return getRepository().findByExample(exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(String entityName, T exampleEntity) {
		return getRepository().findByExample(entityName, exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) {
		return getRepository().findByExample(exampleEntity, firstResult,
				maxResults);
	}

	@Override
	public <T> List<T> findByExample(final String entityName,
			final T exampleEntity, final int firstResult, final int maxResults) {
		return getRepository().findByExample(entityName, exampleEntity,
				firstResult, maxResults);
	}

	public IBaseRepository getRepository() {
		return repository;
	}

	public void setRepository(IBaseRepository repository) {
		this.repository = repository;
	}
	
}
