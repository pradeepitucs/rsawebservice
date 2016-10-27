/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


// TODO: Auto-generated Javadoc
/**
 * The Class ServiceTypeDTO.
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

	/** The non member price. */
	private String nonMemberPrice;

	/** The member price. */
	private String memberPrice;

	/**
	 * Gets the non member price.
	 *
	 * @return the non member price
	 */
	public String getNonMemberPrice()
	{
		return nonMemberPrice;
	}

	/**
	 * Sets the non member price.
	 *
	 * @param nonMemberPrice
	 *           the new non member price
	 */
	public void setNonMemberPrice(String nonMemberPrice)
	{
		this.nonMemberPrice = nonMemberPrice;
	}

	/**
	 * Gets the member price.
	 *
	 * @return the member price
	 */
	public String getMemberPrice()
	{
		return memberPrice;
	}

	/**
	 * Sets the member price.
	 *
	 * @param memberPrice
	 *           the new member price
	 */
	public void setMemberPrice(String memberPrice)
	{
		this.memberPrice = memberPrice;
	}

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
}
