/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class CustomerRequestsDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "customer_requests", namespace = "com.ucs.rsa.common.dto")
public class CustomerRequestsDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The customer requests. */
	private List<CustomerRequestDTO> customerRequests;

	/**
	 * Gets the customer requests.
	 *
	 * @return the customer requests
	 */
	public List<CustomerRequestDTO> getCustomerRequests()
	{
		return customerRequests;
	}

	/**
	 * Sets the customer requests.
	 *
	 * @param customerRequests
	 *           the new customer requests
	 */
	public void setCustomerRequests(List<CustomerRequestDTO> customerRequests)
	{
		this.customerRequests = customerRequests;
	}


}
