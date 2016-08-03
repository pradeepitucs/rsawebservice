package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cities", namespace = "com.ucs.rsa.common.dto")

public class CitiesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<CityDTO> cityDTOs;

	@XmlElement(name = "city")
	public List<CityDTO> getCityDTOs() {
		return cityDTOs;
	}

	public void setCityDTOs(List<CityDTO> cityDTOs) {
		this.cityDTOs = cityDTOs;
	}

}