package com.ucs.rsa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.CitiesDTO;
import com.ucs.rsa.common.dto.CityDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.City;

@Component
public class CityDAOImpl extends BaseRepository implements ICityDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<CityDTO> getCities() {
		List<City> citiesList = null;
		List<CityDTO> cityDTOsList = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			Criteria criteria = theSession.createCriteria(City.class, "city");
			citiesList = (List<City>) criteria.list();
			BeanUtils.copyProperties(citiesList, cityDTOsList);

		} catch (RuntimeException e) {
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return cityDTOsList;
	}

	@Override
	public CitiesDTO getCities(String iCityId) {
		List<City> citiesList = null;
		CitiesDTO citiesDTO = new CitiesDTO();
		Session theSession = null;
		try {
			theSession = currentSession();
			Criteria criteria = theSession.createCriteria(City.class, "city")
					.add(Restrictions.eq("cityID", iCityId));
			citiesList = (List<City>) criteria.list();
			BeanUtils.copyProperties(citiesList, citiesDTO.getCities());
		} catch (RuntimeException e) {
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return citiesDTO;
	}

	
}
