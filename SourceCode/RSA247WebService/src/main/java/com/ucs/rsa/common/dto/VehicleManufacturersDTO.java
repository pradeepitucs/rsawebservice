/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleManufacturersDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicleManufacturers", namespace = "com.ucs.rsa.common.dto")

public class VehicleManufacturersDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The vehicle manufacturer DT os. */
	private List<VehicleManufacturerDTO> vehicleManufacturerDTOs;

	/**
	 * Gets the vehicle manufacturer DT os.
	 *
	 * @return the vehicle manufacturer DT os
	 */
	@XmlElement(name = "vehicleManufacturers")
	public List<VehicleManufacturerDTO> getVehicleManufacturerDTOs()
	{
		return vehicleManufacturerDTOs;
	}

	/**
	 * Sets the vehicle manufacturer DT os.
	 *
	 * @param vehicleManufacturerDTOs
	 *           the new vehicle manufacturer DT os
	 */
	public void setVehicleManufacturerDTOs(List<VehicleManufacturerDTO> vehicleManufacturerDTOs)
	{
		this.vehicleManufacturerDTOs = vehicleManufacturerDTOs;
	}

}
