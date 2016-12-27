/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.daos.CityDAO;
import com.ucs.rsa.model.CityModel;
import com.ucs.rsa.service.CityService;



/**
 * The Class DefaultCityService.
 */
@Service
public class DefaultCityService extends DefaultBaseService implements CityService
{

	/** The city DAO. */
	@Autowired
	@Qualifier("defaultCityDAO")
	CityDAO cityDAO;

	/** The city list. */
	List<CityModel> cityList = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#searchCitiesByName(java.lang.String)
	 */
	@Override
	public List<CityModel> searchCitiesByName(String iName)
	{
		Comparator<CityModel> groupByComparator = Comparator.comparing(CityModel::getCityName);

		List<CityModel> result = getCityList().stream().filter(e -> e.getCityName().toLowerCase().contains(iName.toLowerCase()))
				.sorted(groupByComparator).collect(Collectors.toList());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#filterCitiesByName(java.lang.String)
	 */
	@Override
	public List<CityModel> filterCitiesByName(String iName)
	{
		Comparator<CityModel> groupByComparator = Comparator.comparing(CityModel::getCityName);

		List<CityModel> result = getCityList().stream().filter(e -> e.getCityName().equalsIgnoreCase(iName))
				.sorted(groupByComparator).collect(Collectors.toList());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#findCity(java.lang.String)
	 */
	@Override
	public CityModel findCity(String id)
	{
		Optional<CityModel> match = cityList.stream().filter(e -> e.getCityId() == Integer.valueOf(id)).findFirst();
		if (match.isPresent())
		{
			return match.get();
		}
		return new CityModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#findAllCities()
	 */
	@Override
	public List<CityModel> findAllCities()
	{
		return cityList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#findAllCities(int, int)
	 */
	@Override
	public List<CityModel> findAllCities(int iPageNo, int iRecordsPerPage)
	{
		List<CityModel> cityModels = new ArrayList<>();
		if (iPageNo >= -1 && iRecordsPerPage >= -1)
			cityModels = cityDAO.findAllCities(iPageNo, iRecordsPerPage);
		return cityModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#updateCity(com.ucs.rsa.model.CityModel)
	 */
	@Override
	public CityModel updateCity(CityModel iCityModel)
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#findNoOfRecords()
	 */
	@Override
	public int findNoOfRecords()
	{
		int noOfRecords = cityDAO.findNoOfRecords();
		return noOfRecords;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CityService#deleteCity(java.lang.String)
	 */
	@Override
	public boolean deleteCity(String id)
	{
		return false;
	}

	/**
	 * Gets the city list.
	 *
	 * @return the city list
	 */
	public List<CityModel> getCityList()
	{
		if (cityList.isEmpty())
		{
			cityList = cityDAO.loadAll(CityModel.class);
		}
		return cityList;
	}

	/**
	 * Sets the city list.
	 *
	 * @param cityList
	 *           the new city list
	 */
	public void setCityList(List<CityModel> cityList)
	{
		this.cityList = cityList;
	}

}
