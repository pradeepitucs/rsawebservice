package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cities", namespace = "com.ucs.rsa.common.dto")
public class CitiesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CityDTO> cities;

	public List<CityDTO> getCities() {
		return cities;
	}

	public void setCities(List<CityDTO> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "CitiesDTO [cities=" + cities + "]";
	}

}
