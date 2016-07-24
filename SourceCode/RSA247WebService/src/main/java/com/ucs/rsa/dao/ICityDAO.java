package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.CitiesDTO;
import com.ucs.rsa.common.dto.CityDTO;

public interface ICityDAO {

	public List<CityDTO> getCities();

	public CitiesDTO getCities(String iCityId);

}
