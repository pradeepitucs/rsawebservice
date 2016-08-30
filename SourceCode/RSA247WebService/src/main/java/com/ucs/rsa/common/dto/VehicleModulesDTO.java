/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleModulesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicleModuleDetails", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleModulesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle module DTO. */
	private List<VehicleModuleDTO> vehicleModuleDTO;

	/**
	 * Gets the vehicle module DTO.
	 *
	 * @return the vehicle module DTO
	 */
	public List<VehicleModuleDTO> getVehicleModuleDTO()
	{
		return vehicleModuleDTO;
	}

	/**
	 * Sets the vehicle module DTO.
	 *
	 * @param vehicleModuleDTO
	 *           the new vehicle module DTO
	 */
	public void setVehicleModuleDTO(List<VehicleModuleDTO> vehicleModuleDTO)
	{
		this.vehicleModuleDTO = vehicleModuleDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "VehicleModulesDTO [vehicleModuleDTO=" + vehicleModuleDTO + "]";
	}

}
