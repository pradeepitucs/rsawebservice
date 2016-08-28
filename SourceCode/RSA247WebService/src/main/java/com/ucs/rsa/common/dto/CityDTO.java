/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class CityDTO.
 */
@XmlRootElement(name = "city", namespace = "com.ucs.rsa.common.dto")
public class CityDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The city id. */
	private int cityId;

	/** The city code. */
	private String cityCode;

	/** The city name. */
	private String cityName;

	/** The is enabled. */
	private boolean isEnabled;

	//	private StateDTO stateDTO;

	//	private List<CustomerDTO> customerDTOs;

	/**
	 * Gets the city id.
	 *
	 * @return the city id
	 */
	public int getCityId()
	{
		return this.cityId;
	}

	/**
	 * Sets the city id.
	 *
	 * @param cityId
	 *           the new city id
	 */
	public void setCityId(int cityId)
	{
		this.cityId = cityId;
	}

	/**
	 * Gets the city code.
	 *
	 * @return the city code
	 */
	public String getCityCode()
	{
		return this.cityCode;
	}

	/**
	 * Sets the city code.
	 *
	 * @param cityCode
	 *           the new city code
	 */
	public void setCityCode(String cityCode)
	{
		this.cityCode = cityCode;
	}

	/**
	 * Gets the city name.
	 *
	 * @return the city name
	 */
	public String getCityName()
	{
		return this.cityName;
	}

	/**
	 * Sets the city name.
	 *
	 * @param cityName
	 *           the new city name
	 */
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	/**
	 * Gets the checks if is enabled.
	 *
	 * @return the checks if is enabled
	 */
	public boolean getIsEnabled()
	{
		return this.isEnabled;
	}

	/**
	 * Sets the checks if is enabled.
	 *
	 * @param isEnabled
	 *           the new checks if is enabled
	 */
	public void setIsEnabled(boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	//	public StateDTO getStateModel() {
	//		return this.stateDTO;
	//	}
	//
	//	public void setStateModel(StateDTO stateDTO) {
	//		this.stateDTO = stateDTO;
	//	}
	//
	//	public List<CustomerDTO> getCustomerModels() {
	//		return this.customerDTOs;
	//	}
	//
	//	public void setCustomerModels(List<CustomerDTO> customerDTOs) {
	//		this.customerDTOs = customerDTOs;
	//	}

}
