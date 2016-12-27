/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;



/**
 * The Interface BaseService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public interface BaseService
{

	// TODO : Base Service is having dao layer methods it not standard  

	/**
	 * Gets the.
	 *
	 * @param <T>
	 *           the generic type
	 * @param entityClass
	 *           the entity class
	 * @param id
	 *           the id
	 * @return the t
	 */
	<T> T get(Class<T> entityClass, Serializable id);

	/**
	 * Gets the.
	 *
	 * @param entityName
	 *           the entity name
	 * @param id
	 *           the id
	 * @return the object
	 */
	Object get(String entityName, Serializable id);

	/**
	 * Load.
	 *
	 * @param <T>
	 *           the generic type
	 * @param entityClass
	 *           the entity class
	 * @param id
	 *           the id
	 * @return the t
	 */
	<T> T load(Class<T> entityClass, Serializable id);

	/**
	 * Load.
	 *
	 * @param entityName
	 *           the entity name
	 * @param id
	 *           the id
	 * @return the object
	 */
	Object load(String entityName, Serializable id);

	/**
	 * Load all.
	 *
	 * @param <T>
	 *           the generic type
	 * @param entityClass
	 *           the entity class
	 * @return the list
	 */
	<T> List<T> loadAll(Class<T> entityClass);

	/**
	 * Load.
	 *
	 * @param entity
	 *           the entity
	 * @param id
	 *           the id
	 */
	void load(Object entity, Serializable id);

	/**
	 * Refresh.
	 *
	 * @param entity
	 *           the entity
	 */
	void refresh(Object entity);

	/**
	 * Contains.
	 *
	 * @param entity
	 *           the entity
	 * @return true, if successful
	 */
	boolean contains(Object entity);

	/**
	 * Save.
	 *
	 * @param entity
	 *           the entity
	 * @return the serializable
	 */
	Serializable save(Object entity);

	/**
	 * Save.
	 *
	 * @param entityName
	 *           the entity name
	 * @param entity
	 *           the entity
	 * @return the serializable
	 */
	Serializable save(String entityName, Object entity);

	/**
	 * Update.
	 *
	 * @param entity
	 *           the entity
	 */
	void update(Object entity);

	/**
	 * Update.
	 *
	 * @param entityName
	 *           the entity name
	 * @param entity
	 *           the entity
	 */
	void update(String entityName, Object entity);

	/**
	 * Save or update.
	 *
	 * @param entity
	 *           the entity
	 */
	void saveOrUpdate(Object entity);

	/**
	 * Save or update.
	 *
	 * @param entityName
	 *           the entity name
	 * @param entity
	 *           the entity
	 */
	void saveOrUpdate(String entityName, Object entity);

	/**
	 * Persist.
	 *
	 * @param entity
	 *           the entity
	 */
	void persist(Object entity);

	/**
	 * Persist.
	 *
	 * @param entityName
	 *           the entity name
	 * @param entity
	 *           the entity
	 */
	void persist(String entityName, Object entity);

	/**
	 * Merge.
	 *
	 * @param <T>
	 *           the generic type
	 * @param entity
	 *           the entity
	 * @return the t
	 */
	<T> T merge(T entity);

	/**
	 * Merge.
	 *
	 * @param <T>
	 *           the generic type
	 * @param entityName
	 *           the entity name
	 * @param entity
	 *           the entity
	 * @return the t
	 */
	<T> T merge(String entityName, T entity);

	/**
	 * Delete.
	 *
	 * @param entity
	 *           the entity
	 */
	void delete(Object entity);

	/**
	 * Delete.
	 *
	 * @param entityName
	 *           the entity name
	 * @param entity
	 *           the entity
	 */
	void delete(String entityName, Object entity);

	/**
	 * Delete all.
	 *
	 * @param entities
	 *           the entities
	 */
	void deleteAll(Collection<?> entities);

	/**
	 * Find by criteria.
	 *
	 * @param criteria
	 *           the criteria
	 * @return the list
	 */
	List<?> findByCriteria(DetachedCriteria criteria);

	/**
	 * Find by criteria.
	 *
	 * @param criteria
	 *           the criteria
	 * @param firstResult
	 *           the first result
	 * @param maxResults
	 *           the max results
	 * @return the list
	 */
	List<?> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

	/**
	 * Find by example.
	 *
	 * @param <T>
	 *           the generic type
	 * @param exampleEntity
	 *           the example entity
	 * @return the list
	 */
	<T> List<T> findByExample(T exampleEntity);

	/**
	 * Find by example.
	 *
	 * @param <T>
	 *           the generic type
	 * @param entityName
	 *           the entity name
	 * @param exampleEntity
	 *           the example entity
	 * @return the list
	 */
	<T> List<T> findByExample(String entityName, T exampleEntity);

	/**
	 * Find by example.
	 *
	 * @param <T>
	 *           the generic type
	 * @param exampleEntity
	 *           the example entity
	 * @param firstResult
	 *           the first result
	 * @param maxResults
	 *           the max results
	 * @return the list
	 */
	<T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults);

	/**
	 * Find by example.
	 *
	 * @param <T>
	 *           the generic type
	 * @param entityName
	 *           the entity name
	 * @param exampleEntity
	 *           the example entity
	 * @param firstResult
	 *           the first result
	 * @param maxResults
	 *           the max results
	 * @return the list
	 */
	<T> List<T> findByExample(String entityName, T exampleEntity, int firstResult, int maxResults);

}
