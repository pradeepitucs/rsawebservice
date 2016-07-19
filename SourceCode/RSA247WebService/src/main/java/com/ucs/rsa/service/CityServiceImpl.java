package com.ucs.rsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.rsa.common.dto.CitiesDTO;
import com.ucs.rsa.common.dto.CityDTO;
import com.ucs.rsa.dao.CityDAOImpl;
import com.ucs.rsa.dao.ICityDAO;

@Component
public class CityServiceImpl extends BaseManagerImpl implements ICityService {

	@Autowired
	private ICityDAO cityDAOImpl;
	
	public void setCityDAOImpl(CityDAOImpl cityDAOImpl) {
		this.cityDAOImpl = cityDAOImpl;
	}

	@Override
	@Transactional
	public List<CityDTO> getCities() {
		List<CityDTO> cityDTOs;
		cityDTOs = cityDAOImpl.getCities();
		return cityDTOs;
	}

	@Override
	@Transactional
	public CitiesDTO getCities(String iCityId) {
		CitiesDTO citiesDTO;
		citiesDTO = cityDAOImpl.getCities(iCityId);
		return citiesDTO;
	}

}
