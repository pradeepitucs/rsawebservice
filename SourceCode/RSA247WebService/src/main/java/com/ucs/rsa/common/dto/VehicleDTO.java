/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicle", namespace = "com.ucs.rsa.common.dto")

public class VehicleDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle model id. */
	private int vehicleModelId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The model name. */
	private String modelName;
	//	private List<UserVehicleDTO> userVehicleDTOs;
	//	private VehicleManufacturerDTO vehicleManufacturerDTO;
	//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	/**
	 * Gets the vehicle model id.
	 *
	 * @return the vehicle model id
	 */
	public int getVehicleModelId()
	{
		return this.vehicleModelId;
	}

	/**
	 * Sets the vehicle model id.
	 *
	 * @param vehicleModelId
	 *           the new vehicle model id
	 */
	public void setVehicleModelId(int vehicleModelId)
	{
		this.vehicleModelId = vehicleModelId;
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
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	public String getModelName()
	{
		return this.modelName;
	}

	/**
	 * Sets the model name.
	 *
	 * @param modelName
	 *           the new model name
	 */
	public void setModelName(String modelName)
	{
		this.modelName = modelName;
	}

	//	public List<UserVehicleDTO> getUserVehicleModels() {
	//		return this.userVehicleDTOs;
	//	}
	//
	//	public void setUserVehicleModels(List<UserVehicleDTO> userVehicleDTOs) {
	//		this.userVehicleDTOs = userVehicleDTOs;
	//	}
	//
	//	public VehicleManufacturerDTO getVehicleManufacturerModel() {
	//		return this.vehicleManufacturerDTO;
	//	}
	//
	//	public void setVehicleManufacturerModel(VehicleManufacturerDTO vehicleManufacturerDTO) {
	//		this.vehicleManufacturerDTO = vehicleManufacturerDTO;
	//	}
	//
	//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
	//		return this.vehicleInformationDTOs;
	//	}
	//
	//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationDTOs) {
	//		this.vehicleInformationDTOs = vehicleInformationDTOs;
	//	}

}
