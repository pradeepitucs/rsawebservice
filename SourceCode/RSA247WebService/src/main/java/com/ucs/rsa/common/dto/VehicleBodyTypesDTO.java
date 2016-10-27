/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleBodyTypesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "VehicleBodyTypesDTO", namespace = "com.ucs.rsa.common.dto")

public class VehicleBodyTypesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle body type DT os. */
	private List<VehicleBodyTypeDTO> vehicleBodyTypeDTOs;

	/**
	 * Gets the vehicle body type DT os.
	 *
	 * @return the vehicle body type DT os
	 */
	public List<VehicleBodyTypeDTO> getVehicleBodyTypeDTOs()
	{
		return vehicleBodyTypeDTOs;
	}

	/**
	 * Sets the vehicle body type DT os.
	 *
	 * @param vehicleBodyTypeDTOs
	 *           the new vehicle body type DT os
	 */
	public void setVehicleBodyTypeDTOs(List<VehicleBodyTypeDTO> vehicleBodyTypeDTOs)
	{
		this.vehicleBodyTypeDTOs = vehicleBodyTypeDTOs;
	}

}
