/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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



/**
 * The Class DefaultBaseService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Service
public class DefaultBaseService implements BaseService
{

	// TODO : Default Base Service is having dao layer methods it not standard  

	/** The base DAO. */
	@Autowired
	@Qualifier("defaultBaseDAO")
	private BaseDAO baseDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#get(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <T> T get(Class<T> entityClass, Serializable id)
	{
		return getBaseDAO().get(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#get(java.lang.String, java.io.Serializable)
	 */
	@Override
	public Object get(String entityName, Serializable id)
	{
		return getBaseDAO().get(entityName, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#load(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <T> T load(Class<T> entityClass, Serializable id)
	{
		return getBaseDAO().load(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#load(java.lang.String, java.io.Serializable)
	 */
	@Override
	public Object load(String entityName, Serializable id)
	{
		return getBaseDAO().load(entityName, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#loadAll(java.lang.Class)
	 */
	@Override
	public <T> List<T> loadAll(final Class<T> entityClass)
	{
		return getBaseDAO().loadAll(entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#load(java.lang.Object, java.io.Serializable)
	 */
	@Override
	public void load(final Object entity, final Serializable id)
	{
		getBaseDAO().load(entity, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#refresh(java.lang.Object)
	 */
	@Override
	public void refresh(final Object entity)
	{
		getBaseDAO().refresh(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(final Object entity)
	{
		return getBaseDAO().contains(entity);
	}

	// -------------------------------------------------------------------------
	// Convenience methods for storing individual objects
	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(final Object entity)
	{
		return getBaseDAO().save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#save(java.lang.String, java.lang.Object)
	 */
	@Override
	public Serializable save(final String entityName, final Object entity)
	{
		return getBaseDAO().save(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Object entity)
	{
		getBaseDAO().update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public void update(String entityName, Object entity)
	{
		getBaseDAO().update(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(final Object entity)
	{
		getBaseDAO().saveOrUpdate(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#saveOrUpdate(java.lang.String, java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(final String entityName, final Object entity)
	{
		getBaseDAO().saveOrUpdate(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#persist(java.lang.Object)
	 */
	@Override
	public void persist(final Object entity)
	{
		getBaseDAO().persist(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#persist(java.lang.String, java.lang.Object)
	 */
	@Override
	public void persist(final String entityName, final Object entity)
	{
		getBaseDAO().persist(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#merge(java.lang.Object)
	 */
	@Override
	public <T> T merge(final T entity)
	{
		return getBaseDAO().merge(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#merge(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> T merge(final String entityName, final T entity)
	{
		return getBaseDAO().merge(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object entity)
	{
		getBaseDAO().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public void delete(String entityName, Object entity)
	{
		getBaseDAO().delete(entityName, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#deleteAll(java.util.Collection)
	 */
	@Override
	public void deleteAll(final Collection<?> entities)
	{
		getBaseDAO().deleteAll(entities);
	}

	// -------------------------------------------------------------------------
	// Convenience finder methods for detached criteria
	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public List<?> findByCriteria(DetachedCriteria criteria)
	{
		return getBaseDAO().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#findByCriteria(org.hibernate.criterion.DetachedCriteria, int, int)
	 */
	@Override
	public List<?> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults)
	{
		return getBaseDAO().findByCriteria(criteria, firstResult, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#findByExample(java.lang.Object)
	 */
	@Override
	public <T> List<T> findByExample(T exampleEntity)
	{
		return getBaseDAO().findByExample(exampleEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#findByExample(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> List<T> findByExample(String entityName, T exampleEntity)
	{
		return getBaseDAO().findByExample(entityName, exampleEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#findByExample(java.lang.Object, int, int)
	 */
	@Override
	public <T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults)
	{
		return getBaseDAO().findByExample(exampleEntity, firstResult, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BaseService#findByExample(java.lang.String, java.lang.Object, int, int)
	 */
	@Override
	public <T> List<T> findByExample(final String entityName, final T exampleEntity, final int firstResult, final int maxResults)
	{
		return getBaseDAO().findByExample(entityName, exampleEntity, firstResult, maxResults);
	}

	/**
	 * Gets the base DAO.
	 *
	 * @return the base DAO
	 */
	public BaseDAO getBaseDAO()
	{
		return baseDAO;
	}

	/**
	 * Sets the base DAO.
	 *
	 * @param baseDAO
	 *           the new base DAO
	 */
	public void setBaseDAO(BaseDAO baseDAO)
	{
		this.baseDAO = baseDAO;
	}

}
