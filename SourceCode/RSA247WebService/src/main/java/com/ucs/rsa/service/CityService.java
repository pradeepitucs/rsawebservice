package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.model.CityModel;

public interface CityService {

	public CityModel updateCity(CityModel cityModel);
	
	public List<CityModel> getAllCities();
	
	public CityModel getCity(int iCityId);
	
}
