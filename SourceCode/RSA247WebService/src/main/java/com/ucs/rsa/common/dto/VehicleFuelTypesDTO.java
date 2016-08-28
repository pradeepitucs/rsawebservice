/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class VehicleFuelTypesDTO.
 */
@XmlRootElement(name = "vehicleFuelTypes", namespace = "com.ucs.rsa.common.dto")

public class VehicleFuelTypesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The vehicle fuel type DT os. */
	private List<VehicleFuelTypeDTO> vehicleFuelTypeDTOs;

	/**
	 * Gets the vehicle fuel type DT os.
	 *
	 * @return the vehicle fuel type DT os
	 */
	@XmlElement(name = "vehicleFuelType")
	public List<VehicleFuelTypeDTO> getVehicleFuelTypeDTOs()
	{
		return vehicleFuelTypeDTOs;
	}

	/**
	 * Sets the vehicle fuel type DT os.
	 *
	 * @param vehicleFuelTypeDTOs
	 *           the new vehicle fuel type DT os
	 */
	public void setVehicleFuelTypeDTOs(List<VehicleFuelTypeDTO> vehicleFuelTypeDTOs)
	{
		this.vehicleFuelTypeDTOs = vehicleFuelTypeDTOs;
	}

}
