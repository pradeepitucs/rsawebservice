package com.ucs.rsa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseRepository extends HibernateDaoSupport implements
		IBaseRepository {

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public Object get(String entityName, Serializable id) {
		return getHibernateTemplate().get(entityName, id);
	}

	@Override
	public <T> T load(Class<T> entityClass, Serializable id) {
		return getHibernateTemplate().load(entityClass, id);
	}

	@Override
	public Object load(String entityName, Serializable id) {
		return getHibernateTemplate().load(entityName, id);
	}

	@Override
	public <T> List<T> loadAll(final Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public void load(final Object entity, final Serializable id) {
		getHibernateTemplate().load(entity, id);
	}

	@Override
	public void refresh(final Object entity) {
		getHibernateTemplate().refresh(entity);
	}

	@Override
	public boolean contains(final Object entity) {
		return getHibernateTemplate().contains(entity);
	}

	// -------------------------------------------------------------------------
	// Convenience methods for storing individual objects
	// -------------------------------------------------------------------------

	@Override
	public Serializable save(final Object entity) {
		return getHibernateTemplate().save(entity);
	}

	@Override
	public Serializable save(final String entityName, final Object entity) {
		return getHibernateTemplate().save(entityName, entity);
	}

	@Override
	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void update(String entityName, Object entity) {
		getHibernateTemplate().update(entityName, entity);
	}

	@Override
	public void saveOrUpdate(final Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdate(final String entityName, final Object entity) {
		getHibernateTemplate().saveOrUpdate(entityName, entity);
	}

	@Override
	public void persist(final Object entity) {
		getHibernateTemplate().persist(entity);
	}

	@Override
	public void persist(final String entityName, final Object entity) {
		getHibernateTemplate().persist(entityName, entity);
	}

	@Override
	public <T> T merge(final T entity) {
		return getHibernateTemplate().merge(entity);
	}

	@Override
	public <T> T merge(final String entityName, final T entity) {
		return getHibernateTemplate().merge(entityName, entity);
	}

	@Override
	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void delete(String entityName, Object entity) {
		getHibernateTemplate().delete(entityName, entity);
	}

	@Override
	public void deleteAll(final Collection<?> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	// -------------------------------------------------------------------------
	// Convenience finder methods for detached criteria
	// -------------------------------------------------------------------------

	@Override
	public List<?> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<?> findByCriteria(final DetachedCriteria criteria,
			final int firstResult, final int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResults);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity) {
		return getHibernateTemplate().findByExample(exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(String entityName, T exampleEntity) {
		return getHibernateTemplate().findByExample(entityName, exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) {
		return getHibernateTemplate().findByExample(exampleEntity, firstResult,
				maxResults);
	}

	@Override
	public <T> List<T> findByExample(final String entityName,
			final T exampleEntity, final int firstResult, final int maxResults) {
		return getHibernateTemplate().findByExample(entityName, exampleEntity,
				firstResult, maxResults);
	}

}
