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
 *          The Class UserVehiclesDTO.
 */
@XmlRootElement(name = "userVehicles", namespace = "com.ucs.rsa.common.dto")

public class UserVehiclesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The user vehicle DT os. */
	private List<UserVehicleDTO> userVehicleDTOs;

	/**
	 * Gets the user vehicle DT os.
	 *
	 * @return the user vehicle DT os
	 */
	@XmlElement(name = "userVehicle")
	public List<UserVehicleDTO> getUserVehicleDTOs()
	{
		return userVehicleDTOs;
	}

	/**
	 * Sets the user vehicle DT os.
	 *
	 * @param userVehicleDTOs
	 *           the new user vehicle DT os
	 */
	public void setUserVehicleDTOs(List<UserVehicleDTO> userVehicleDTOs)
	{
		this.userVehicleDTOs = userVehicleDTOs;
	}

}
