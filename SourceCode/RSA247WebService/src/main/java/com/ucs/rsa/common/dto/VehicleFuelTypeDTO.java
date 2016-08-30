/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleFuelTypeDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicleFuelType", namespace = "com.ucs.rsa.common.dto")

public class VehicleFuelTypeDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle fuel type id. */
	private int vehicleFuelTypeId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The vehicle fuel type name. */
	private String vehicleFuelTypeName;
	//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	/**
	 * Gets the vehicle fuel type id.
	 *
	 * @return the vehicle fuel type id
	 */
	public int getVehicleFuelTypeId()
	{
		return this.vehicleFuelTypeId;
	}

	/**
	 * Sets the vehicle fuel type id.
	 *
	 * @param vehicleFuelTypeId
	 *           the new vehicle fuel type id
	 */
	public void setVehicleFuelTypeId(int vehicleFuelTypeId)
	{
		this.vehicleFuelTypeId = vehicleFuelTypeId;
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
	 * Gets the vehicle fuel type name.
	 *
	 * @return the vehicle fuel type name
	 */
	public String getVehicleFuelTypeName()
	{
		return this.vehicleFuelTypeName;
	}

	/**
	 * Sets the vehicle fuel type name.
	 *
	 * @param vehicleFuelTypeName
	 *           the new vehicle fuel type name
	 */
	public void setVehicleFuelTypeName(String vehicleFuelTypeName)
	{
		this.vehicleFuelTypeName = vehicleFuelTypeName;
	}

	//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
	//		return this.vehicleInformationDTOs;
	//	}
	//
	//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationModels) {
	//		this.vehicleInformationDTOs = vehicleInformationModels;
	//	}

}
