/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class CitiesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "cities", namespace = "com.ucs.rsa.common.dto")

public class CitiesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The city DT os. */
	private List<CityDTO> cityDTOs;

	/**
	 * Gets the city DT os.
	 *
	 * @return the city DT os
	 */
	@XmlElement(name = "city")
	public List<CityDTO> getCityDTOs()
	{
		return cityDTOs;
	}

	/**
	 * Sets the city DT os.
	 *
	 * @param cityDTOs
	 *           the new city DT os
	 */
	public void setCityDTOs(List<CityDTO> cityDTOs)
	{
		this.cityDTOs = cityDTOs;
	}

}
