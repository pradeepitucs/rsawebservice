/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class ServiceTypeDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "serviceType", namespace = "com.ucs.rsa.common.dto")
public class ServiceTypeDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The service type id. */
	private int serviceTypeId;

	/** The service type. */
	private String serviceType;

	/** The service price. */
	private int servicePrice;

	/**
	 * Gets the service type id.
	 *
	 * @return the service type id
	 */
	public int getServiceTypeId()
	{
		return serviceTypeId;
	}

	/**
	 * Sets the service type id.
	 *
	 * @param serviceTypeId
	 *           the new service type id
	 */
	public void setServiceTypeId(int serviceTypeId)
	{
		this.serviceTypeId = serviceTypeId;
	}

	/**
	 * Gets the service type.
	 *
	 * @return the service type
	 */
	public String getServiceType()
	{
		return serviceType;
	}

	/**
	 * Sets the service type.
	 *
	 * @param serviceType
	 *           the new service type
	 */
	public void setServiceType(String serviceType)
	{
		this.serviceType = serviceType;
	}

	/**
	 * Gets the service price.
	 *
	 * @return the service price
	 */
	public int getServicePrice()
	{
		return servicePrice;
	}

	/**
	 * Sets the service price.
	 *
	 * @param servicePrice
	 *           the new service price
	 */
	public void setServicePrice(int servicePrice)
	{
		this.servicePrice = servicePrice;
	}
}
