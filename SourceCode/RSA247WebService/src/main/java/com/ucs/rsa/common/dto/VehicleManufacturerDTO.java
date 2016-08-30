/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleManufacturerDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicleManufacturer", namespace = "com.ucs.rsa.common.dto")

public class VehicleManufacturerDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The manufacturer id. */
	private int manufacturerId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The manufacturer name. */
	private String manufacturerName;
	//	private List<VehicleDTO> vehicleDTOs;
	//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	/**
	 * Gets the manufacturer id.
	 *
	 * @return the manufacturer id
	 */
	public int getManufacturerId()
	{
		return this.manufacturerId;
	}

	/**
	 * Sets the manufacturer id.
	 *
	 * @param manufacturerId
	 *           the new manufacturer id
	 */
	public void setManufacturerId(int manufacturerId)
	{
		this.manufacturerId = manufacturerId;
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
	 * Gets the manufacturer name.
	 *
	 * @return the manufacturer name
	 */
	public String getManufacturerName()
	{
		return this.manufacturerName;
	}

	/**
	 * Sets the manufacturer name.
	 *
	 * @param manufacturerName
	 *           the new manufacturer name
	 */
	public void setManufacturerName(String manufacturerName)
	{
		this.manufacturerName = manufacturerName;
	}

	//	public List<VehicleDTO> getVehicleModels() {
	//		return this.vehicleDTOs;
	//	}
	//
	//	public void setVehicleModels(List<VehicleDTO> vehicleModels) {
	//		this.vehicleDTOs = vehicleModels;
	//	}
	//
	//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
	//		return this.vehicleInformationDTOs;
	//	}
	//
	//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationModels) {
	//		this.vehicleInformationDTOs = vehicleInformationModels;
	//	}

}
