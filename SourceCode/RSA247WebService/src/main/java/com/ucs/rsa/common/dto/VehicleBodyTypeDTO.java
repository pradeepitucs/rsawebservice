/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleBodyTypeDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "VehicleBodyTypeDTO", namespace = "com.ucs.rsa.common.dto")
public class VehicleBodyTypeDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle body type id. */
	private int vehicleBodyTypeId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The vehicle body type name. */
	private String vehicleBodyTypeName;
	//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	/**
	 * Gets the vehicle body type id.
	 *
	 * @return the vehicle body type id
	 */
	public int getVehicleBodyTypeId()
	{
		return this.vehicleBodyTypeId;
	}

	/**
	 * Sets the vehicle body type id.
	 *
	 * @param vehicleBodyTypeId
	 *           the new vehicle body type id
	 */
	public void setVehicleBodyTypeId(int vehicleBodyTypeId)
	{
		this.vehicleBodyTypeId = vehicleBodyTypeId;
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
	 * Gets the vehicle body type name.
	 *
	 * @return the vehicle body type name
	 */
	public String getVehicleBodyTypeName()
	{
		return this.vehicleBodyTypeName;
	}

	/**
	 * Sets the vehicle body type name.
	 *
	 * @param vehicleBodyTypeName
	 *           the new vehicle body type name
	 */
	public void setVehicleBodyTypeName(String vehicleBodyTypeName)
	{
		this.vehicleBodyTypeName = vehicleBodyTypeName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "VehicleBodyTypeDTO [vehicleBodyTypeId=" + vehicleBodyTypeId + ", isEnabled=" + isEnabled + ", vehicleBodyTypeName="
				+ vehicleBodyTypeName + "]";
	}

	//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
	//		return this.vehicleInformationDTOs;
	//	}
	//
	//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationDTOs) {
	//		this.vehicleInformationDTOs = vehicleInformationDTOs;
	//	}


}
