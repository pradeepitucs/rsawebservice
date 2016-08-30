/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehiclesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicles", namespace = "com.ucs.rsa.common.dto")

public class VehiclesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The vehicle DT os. */
	private List<VehicleDTO> vehicleDTOs;

	/**
	 * Gets the vehicle DT os.
	 *
	 * @return the vehicle DT os
	 */
	@XmlElement(name = "vehicle")
	public List<VehicleDTO> getVehicleDTOs()
	{
		return vehicleDTOs;
	}

	/**
	 * Sets the vehicle DT os.
	 *
	 * @param vehicleDTOs
	 *           the new vehicle DT os
	 */
	public void setVehicleDTOs(List<VehicleDTO> vehicleDTOs)
	{
		this.vehicleDTOs = vehicleDTOs;
	}

}
