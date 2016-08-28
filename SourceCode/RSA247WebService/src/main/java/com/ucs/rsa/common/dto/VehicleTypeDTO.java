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
 *          The Class VehicleTypeDTO.
 */
@XmlRootElement(name = "vehicleType", namespace = "com.ucs.rsa.common.dto")

public class VehicleTypeDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle type id. */
	private int vehicleTypeId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The vehicle type name. */
	private String vehicleTypeName;
	//	private List<VehicleInformationModelDTO> vehicleInformationModelDTOs;


	/**
	 * Gets the vehicle type id.
	 *
	 * @return the vehicle type id
	 */
	public int getVehicleTypeId()
	{
		return this.vehicleTypeId;
	}

	/**
	 * Sets the vehicle type id.
	 *
	 * @param vehicleTypeId
	 *           the new vehicle type id
	 */
	public void setVehicleTypeId(int vehicleTypeId)
	{
		this.vehicleTypeId = vehicleTypeId;
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
	 * Gets the vehicle type name.
	 *
	 * @return the vehicle type name
	 */
	public String getVehicleTypeName()
	{
		return this.vehicleTypeName;
	}

	/**
	 * Sets the vehicle type name.
	 *
	 * @param vehicleTypeName
	 *           the new vehicle type name
	 */
	public void setVehicleTypeName(String vehicleTypeName)
	{
		this.vehicleTypeName = vehicleTypeName;
	}

	//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
	//		return this.vehicleInformationModelDTOs;
	//	}
	//
	//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationModelDTOs) {
	//		this.vehicleInformationModelDTOs = vehicleInformationModelDTOs;
	//	}

}
