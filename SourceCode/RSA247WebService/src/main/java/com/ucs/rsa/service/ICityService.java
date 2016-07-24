package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.common.dto.CitiesDTO;
import com.ucs.rsa.common.dto.CityDTO;

public interface ICityService {

	public List<CityDTO> getCities();

	public CitiesDTO getCities(String iCityId);
	
}
