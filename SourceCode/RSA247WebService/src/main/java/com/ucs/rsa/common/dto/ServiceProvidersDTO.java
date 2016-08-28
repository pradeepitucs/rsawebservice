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
 *          The Class ServiceProvidersDTO.
 */
@XmlRootElement(name = "service_provider", namespace = "com.ucs.rsa.dto")
public class ServiceProvidersDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The service provider DTO. */
	private List<ServiceProviderDTO> serviceProviderDTO;

	/**
	 * Gets the service provider DT os.
	 *
	 * @return the service provider DT os
	 */
	@XmlElement(name = "service_provider")
	public List<ServiceProviderDTO> getServiceProviderDTOs()
	{
		return serviceProviderDTO;
	}

	/**
	 * Sets the service provider DT os.
	 *
	 * @param serviceProviderDTO
	 *           the new service provider DT os
	 */
	public void setServiceProviderDTOs(List<ServiceProviderDTO> serviceProviderDTO)
	{
		this.serviceProviderDTO = serviceProviderDTO;
	}

}
