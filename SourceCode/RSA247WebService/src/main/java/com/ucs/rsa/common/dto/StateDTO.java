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
 *          The Class StateDTO.
 */
@XmlRootElement(name = "state", namespace = "com.ucs.rsa.common.dto")

public class StateDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The state id. */
	private int stateId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The state code. */
	private String stateCode;

	/** The state name. */
	private String stateName;
	//	private List<CityDTO> cityDTOs;


	/**
	 * Gets the state id.
	 *
	 * @return the state id
	 */
	public int getStateId()
	{
		return this.stateId;
	}

	/**
	 * Sets the state id.
	 *
	 * @param stateId
	 *           the new state id
	 */
	public void setStateId(int stateId)
	{
		this.stateId = stateId;
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

	/**
	 * Gets the state code.
	 *
	 * @return the state code
	 */
	public String getStateCode()
	{
		return this.stateCode;
	}

	/**
	 * Sets the state code.
	 *
	 * @param stateCode
	 *           the new state code
	 */
	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}

	/**
	 * Gets the state name.
	 *
	 * @return the state name
	 */
	public String getStateName()
	{
		return this.stateName;
	}

	/**
	 * Sets the state name.
	 *
	 * @param stateName
	 *           the new state name
	 */
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	//	public List<CityDTO> getCityModels() {
	//		return this.cityDTOs;
	//	}
	//
	//	public void setCityModels(List<CityDTO> cityDTOs) {
	//		this.cityDTOs = cityDTOs;
	//	}

}
