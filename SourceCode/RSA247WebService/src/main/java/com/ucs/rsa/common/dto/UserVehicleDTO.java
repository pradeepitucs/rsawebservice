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
 *          The Class UserVehicleDTO.
 */
@XmlRootElement(name = "userVehicle", namespace = "com.ucs.rsa.common.dto")

public class UserVehicleDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle id. */
	private int vehicleId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The user id. */
	private int userId;

	/** The vehicle reg no. */
	private String vehicleRegNo;
	//	private VehicleDTO vehicleDTO;


	/**
	 * Gets the vehicle id.
	 *
	 * @return the vehicle id
	 */
	public int getVehicleId()
	{
		return this.vehicleId;
	}

	/**
	 * Sets the vehicle id.
	 *
	 * @param vehicleId
	 *           the new vehicle id
	 */
	public void setVehicleId(int vehicleId)
	{
		this.vehicleId = vehicleId;
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
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId()
	{
		return this.userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *           the new user id
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * Gets the vehicle reg no.
	 *
	 * @return the vehicle reg no
	 */
	public String getVehicleRegNo()
	{
		return this.vehicleRegNo;
	}

	/**
	 * Sets the vehicle reg no.
	 *
	 * @param vehicleRegNo
	 *           the new vehicle reg no
	 */
	public void setVehicleRegNo(String vehicleRegNo)
	{
		this.vehicleRegNo = vehicleRegNo;
	}

	//	public VehicleDTO getVehicleModelT() {
	//		return this.vehicleDTO;
	//	}
	//
	//	public void setVehicleModelT(VehicleDTO vehicleDTO) {
	//		this.vehicleDTO = vehicleDTO;
	//	}

}
