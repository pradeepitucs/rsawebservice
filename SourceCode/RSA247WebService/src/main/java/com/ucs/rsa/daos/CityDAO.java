/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos;

import java.util.List;

import com.ucs.rsa.model.CityModel;


/**
 * The Interface CityDAO.
 */
public interface CityDAO extends BaseDAO {

	/**
	 * Search cities by name.
	 *
	 * @param iName the i name
	 * @return the list
	 */
	public List<CityModel> searchCitiesByName(String iName);
		
	/**
	 * Find city.
	 *
	 * @param id the id
	 * @return the city model
	 */
	public CityModel findCity(String id);
	
	/**
	 * Find all cities.
	 *
	 * @return the list
	 */
	public List<CityModel> findAllCities();
	
	/**
	 * Find all cities.
	 *
	 * @param iPageNo the i page no
	 * @param iRecordsPerPage the i records per page
	 * @return the list
	 */
	public List<CityModel> findAllCities(int iPageNo, int iRecordsPerPage);
	
	/**
	 * Update city.
	 *
	 * @param iCityModel the i city model
	 * @return the city model
	 */
	public CityModel updateCity(CityModel iCityModel);
	
	/**
	 * Find no of records.
	 *
	 * @return the int
	 */
	public int findNoOfRecords();

	/**
	 * Delete city.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteCity(String id);
	
}
