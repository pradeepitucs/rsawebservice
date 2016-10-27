/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class VehicleInformationModelsDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "vehicleInformationModels", namespace = "com.ucs.rsa.common.dto")

public class VehicleInformationModelsDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The vehicle information model DT os. */
	private List<VehicleInformationModelDTO> vehicleInformationModelDTOs;

	/**
	 * Gets the vehicle information model DT os.
	 *
	 * @return the vehicle information model DT os
	 */
	@XmlElement(name = "vehicleInformationModel")
	public List<VehicleInformationModelDTO> getVehicleInformationModelDTOs()
	{
		return vehicleInformationModelDTOs;
	}

	/**
	 * Sets the vehicle information model DT os.
	 *
	 * @param vehicleInformationModelDTOs
	 *           the new vehicle information model DT os
	 */
	public void setVehicleInformationModelDTOs(List<VehicleInformationModelDTO> vehicleInformationModelDTOs)
	{
		this.vehicleInformationModelDTOs = vehicleInformationModelDTOs;
	}

}
