/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.rsa.daos.BaseDAO;



/**
 * The Class DefaultBaseDAO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Repository(value = "defaultBaseDAO")
@Transactional
public class DefaultBaseDAO extends HibernateDaoSupport implements BaseDAO
{

	// TODO : Default Base DAO is having Hibernate template methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#get(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <T> T get(Class<T> entityClass, Serializable id)
	{
		return getHibernateTemplate().get(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#get(java.lang.String, java.io.Serializable)
	 */
	@Override
	public Object get(String entityName, Serializable id)
	{
		return getHibernateTemplate().get(entityName, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#load(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <T> T load(Class<T> entityClass, Serializable id)
	{
		return getHibernateTemplate().load(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#load(java.lang.String, java.io.Serializable)
	 */
	@Override
	public Object load(String entityName, Serializable id)
	{
		return getHibernateTemplate().load(entityName, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#loadAll(java.lang.Class)
	 */
	@Override
	public <T> List<T> loadAll(final Class<T> entityClass)
	{
		return getHibernateTemplate().loadAll(entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#load(java.lang.Object, java.io.Serializable)
	 */
	@Override
	public void load(final Object entity, final Serializable id)
	{
		getHibernateTemplate().load(entity, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#refresh(java.lang.Object)
	 */
	@Override
	public void refresh(final Object entity)
	{
		getHibernateTemplate().refresh(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(final Object entity)
	{
		return getHibernateTemplate().contains(entity);
	}

	// -------------------------------------------------------------------------
	// Convenience methods for storing individual objects
	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#save(java.lang.Object)
	 */
	@Override
	public Serializable save(final Object entity)
	{
		return getHibernateTemplate().save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#save(java.lang.String, java.lang.Object)
	 */
	@Override
	public Serializable save(final String entityName, final Object entity)
	{
		return getHibernateTemplate().save(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#update(java.lang.Object)
	 */
	@Override
	public void update(Object entity)
	{
		getHibernateTemplate().update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public void update(String entityName, Object entity)
	{
		getHibernateTemplate().update(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(final Object entity)
	{
		getHibernateTemplate().saveOrUpdate(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#saveOrUpdate(java.lang.String, java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(final String entityName, final Object entity)
	{
		getHibernateTemplate().saveOrUpdate(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#persist(java.lang.Object)
	 */
	@Override
	public void persist(final Object entity)
	{
		getHibernateTemplate().persist(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#persist(java.lang.String, java.lang.Object)
	 */
	@Override
	public void persist(final String entityName, final Object entity)
	{
		getHibernateTemplate().persist(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#merge(java.lang.Object)
	 */
	@Override
	public <T> T merge(final T entity)
	{
		return getHibernateTemplate().merge(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#merge(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> T merge(final String entityName, final T entity)
	{
		return getHibernateTemplate().merge(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object entity)
	{
		getHibernateTemplate().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public void delete(String entityName, Object entity)
	{
		getHibernateTemplate().delete(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#deleteAll(java.util.Collection)
	 */
	@Override
	public void deleteAll(final Collection<?> entities)
	{
		getHibernateTemplate().deleteAll(entities);
	}

	// -------------------------------------------------------------------------
	// Convenience finder methods for detached criteria
	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public List<?> findByCriteria(DetachedCriteria criteria)
	{
		return getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#findByCriteria(org.hibernate.criterion.DetachedCriteria, int, int)
	 */
	@Override
	public List<?> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults)
	{
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#findByExample(java.lang.Object)
	 */
	@Override
	public <T> List<T> findByExample(T exampleEntity)
	{
		return getHibernateTemplate().findByExample(exampleEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#findByExample(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> List<T> findByExample(String entityName, T exampleEntity)
	{
		return getHibernateTemplate().findByExample(entityName, exampleEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#findByExample(java.lang.Object, int, int)
	 */
	@Override
	public <T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults)
	{
		return getHibernateTemplate().findByExample(exampleEntity, firstResult, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.BaseDAO#findByExample(java.lang.String, java.lang.Object, int, int)
	 */
	@Override
	public <T> List<T> findByExample(final String entityName, final T exampleEntity, final int firstResult, final int maxResults)
	{
		return getHibernateTemplate().findByExample(entityName, exampleEntity, firstResult, maxResults);
	}

	/**
	 * Sets the session factroy.
	 *
	 * @param iSessionFactory
	 *           the new session factroy
	 */
	@Resource(name = "sessionFactory")
	public void setSessionFactroy(final SessionFactory iSessionFactory)
	{
		this.setSessionFactory(iSessionFactory);
	}

}
