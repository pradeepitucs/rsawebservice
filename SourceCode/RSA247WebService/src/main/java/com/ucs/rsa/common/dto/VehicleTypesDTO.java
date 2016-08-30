/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleTypesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicleTypes", namespace = "com.ucs.rsa.common.dto")

public class VehicleTypesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The vehicle type DT os. */
	private List<VehicleTypeDTO> vehicleTypeDTOs;

	/**
	 * Gets the vehicle type DT os.
	 *
	 * @return the vehicle type DT os
	 */
	@XmlElement(name = "vehicleType")
	public List<VehicleTypeDTO> getVehicleTypeDTOs()
	{
		return vehicleTypeDTOs;
	}

	/**
	 * Sets the vehicle type DT os.
	 *
	 * @param vehicleTypeDTOs
	 *           the new vehicle type DT os
	 */
	public void setVehicleTypeDTOs(List<VehicleTypeDTO> vehicleTypeDTOs)
	{
		this.vehicleTypeDTOs = vehicleTypeDTOs;
	}



}
