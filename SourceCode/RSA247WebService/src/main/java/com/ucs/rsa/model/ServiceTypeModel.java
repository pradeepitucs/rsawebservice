/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class ServiceTypeModel.
 */
@Entity
@Table(name = "service_type_t")
@NamedQuery(name = "ServiceTypeModel.findAll", query = "SELECT v FROM ServiceTypeModel v")
public class ServiceTypeModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The service type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_type_id")
	private int serviceTypeId;

	/** The service type. */
	@Column(name = "service_type")
	private String serviceType;

	/** The service price. */
	@Column(name = "service_price")
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ServiceTypeModel [serviceTypeId=" + serviceTypeId + ",serviceType=" + serviceType + ",servicePrice=" + servicePrice
				+ "]";
	}

}
