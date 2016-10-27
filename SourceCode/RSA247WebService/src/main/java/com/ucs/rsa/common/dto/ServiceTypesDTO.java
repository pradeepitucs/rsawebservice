/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class ServiceTypesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "serviceTypes", namespace = "com.ucs.rsa.common.dto")
public class ServiceTypesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The service types DTO. */
	private List<ServiceTypeDTO> serviceTypesDTO;

	/**
	 * Gets the service types DTO.
	 *
	 * @return the service types DTO
	 */
	@XmlElement(name = "serviceTypes")
	public List<ServiceTypeDTO> getServiceTypesDTO()
	{
		return serviceTypesDTO;
	}

	/**
	 * Sets the service types DTO.
	 *
	 * @param serviceTypesDTO
	 *           the new service types DTO
	 */
	public void setServiceTypesDTO(List<ServiceTypeDTO> serviceTypesDTO)
	{
		this.serviceTypesDTO = serviceTypesDTO;
	}

}
