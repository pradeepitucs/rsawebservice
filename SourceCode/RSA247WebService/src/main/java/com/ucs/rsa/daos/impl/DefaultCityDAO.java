/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CityDAO;
import com.ucs.rsa.model.CityModel;


// TODO: Auto-generated Javadoc
/**
 * The Class DefaultCityDAO.
 */
@Repository(value = "defaultCityDAO")
public class DefaultCityDAO extends DefaultBaseDAO implements CityDAO
{

	/** The no of records. */
	private int noOfRecords;

	/** The city models. */
	List<CityModel> cityModels = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CityDAO#searchCitiesByName(java.lang.String)
	 */
	@Override
	public List<CityModel> searchCitiesByName(String iName)
	{
		Comparator<CityModel> groupByComparator = Comparator.comparing(CityModel::getCityName);
		List<CityModel> result = cityModels.stream().filter(e -> e.getCityName().equalsIgnoreCase(iName)).sorted(groupByComparator)
				.collect(Collectors.toList());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CityDAO#findCity(java.lang.String)
	 */
	@Override
	public CityModel findCity(String id)
	{

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CityDAO#findAllCities()
	 */
	@Override
	public List<CityModel> findAllCities()
	{

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CityDAO#findAllCities(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CityModel> findAllCities(int iPageNo, int iRecordsPerPage)
	{

		Session theSession = null;
		try
		{
			theSession = currentSession();

			if (iPageNo >= -1 && iRecordsPerPage >= -1)
			{
				Criteria theCriteria = theSession.createCriteria(CityModel.class, "cityModel")
						.setFetchMode("address.clients", FetchMode.SELECT).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
						.setFirstResult(iPageNo).setMaxResults(iRecordsPerPage);
				cityModels = (List<CityModel>) theCriteria.list();

				this.noOfRecords = theSession.createCriteria(CityModel.class, "cityModel").list().size();
			}

		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return cityModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CityDAO#updateCity(com.ucs.rsa.model.CityModel)
	 */
	@Override
	public CityModel updateCity(CityModel iCityModel)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CityDAO#findNoOfRecords()
	 */
	@Override
	public int findNoOfRecords()
	{
		return noOfRecords;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CityDAO#deleteCity(java.lang.String)
	 */
	@Override
	public boolean deleteCity(String id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Gets the no of records.
	 *
	 * @return the no of records
	 */
	public int getNoOfRecords()
	{
		return noOfRecords;
	}

	/**
	 * Sets the no of records.
	 *
	 * @param noOfRecords
	 *           the new no of records
	 */
	public void setNoOfRecords(int noOfRecords)
	{
		this.noOfRecords = noOfRecords;
	}

}
