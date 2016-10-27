/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.model.CityModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface CityService.
 */
public interface CityService extends BaseService {

	/**
	 * Search cities by name.
	 *
	 * @param iName the i name
	 * @return the list
	 */
	public List<CityModel> searchCitiesByName(String iName);
	
	/**
	 * Filter cities by name.
	 *
	 * @param iName the i name
	 * @return the list
	 */
	public List<CityModel> filterCitiesByName(String iName);
		
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
