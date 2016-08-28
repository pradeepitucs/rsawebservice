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
 *          The Class VehicleInformationModelDTO.
 */
@XmlRootElement(name = "vehicleInformationModel", namespace = "com.ucs.rsa.common.dto")

public class VehicleInformationModelDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle information model id. */
	private int vehicleInformationModelId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The vehicle information model name. */
	private String vehicleInformationModelName;
	//	private int vehicleInformationModelYear;
	//	private VehicleBodyTypeDTO vehicleBodyTypeDTO;
	//	private VehicleFuelTypeDTO vehicleFuelTypeDTO;
	//	private VehicleManufacturerDTO vehicleManufacturerDTO;
	//	private VehicleDTO vehicleDTO;
	//	private VehicleTypeDTO vehicleTypeDTO;


	/**
	 * Gets the vehicle information model id.
	 *
	 * @return the vehicle information model id
	 */
	public int getVehicleInformationModelId()
	{
		return this.vehicleInformationModelId;
	}

	/**
	 * Sets the vehicle information model id.
	 *
	 * @param vehicleInformationModelId
	 *           the new vehicle information model id
	 */
	public void setVehicleInformationModelId(int vehicleInformationModelId)
	{
		this.vehicleInformationModelId = vehicleInformationModelId;
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
	 * Gets the vehicle information model name.
	 *
	 * @return the vehicle information model name
	 */
	public String getVehicleInformationModelName()
	{
		return this.vehicleInformationModelName;
	}

	/**
	 * Sets the vehicle information model name.
	 *
	 * @param vehicleInformationModelName
	 *           the new vehicle information model name
	 */
	public void setVehicleInformationModelName(String vehicleInformationModelName)
	{
		this.vehicleInformationModelName = vehicleInformationModelName;
	}

	//	public int getVehicleInformationModelYear() {
	//		return this.vehicleInformationModelYear;
	//	}
	//
	//	public void setVehicleInformationModelYear(int vehicleInformationModelYear) {
	//		this.vehicleInformationModelYear = vehicleInformationModelYear;
	//	}

	//	public VehicleBodyTypeDTO getVehicleBodyTypeModel() {
	//		return this.vehicleBodyTypeDTO;
	//	}
	//
	//	public void setVehicleBodyTypeModel(VehicleBodyTypeDTO vehicleBodyTypeDTO) {
	//		this.vehicleBodyTypeDTO = vehicleBodyTypeDTO;
	//	}
	//
	//	public VehicleFuelTypeDTO getVehicleFuelTypeModel() {
	//		return this.vehicleFuelTypeDTO;
	//	}
	//
	//	public void setVehicleFuelTypeModel(VehicleFuelTypeDTO vehicleFuelTypeDTO) {
	//		this.vehicleFuelTypeDTO = vehicleFuelTypeDTO;
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
	//	public VehicleDTO getVehicleModel() {
	//		return this.vehicleDTO;
	//	}
	//
	//	public void setVehicleModel(VehicleDTO vehicleDTO) {
	//		this.vehicleDTO = vehicleDTO;
	//	}
	//
	//	public VehicleTypeDTO getVehicleTypeModel() {
	//		return this.vehicleTypeDTO;
	//	}
	//
	//	public void setVehicleTypeModel(VehicleTypeDTO vehicleTypeDTO) {
	//		this.vehicleTypeDTO = vehicleTypeDTO;
	//	}

}
