package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class CustomerServiceRequestsDTO.
 */
@XmlRootElement(name = "customer_service_requests", namespace = "com.ucs.rsa.common.dto")
public class CustomerServiceRequestsDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The customer requests. */
	private List<CustomerServiceRequestDTO> customerRequests;

	/**
	 * Gets the customer requests.
	 *
	 * @return the customer requests
	 */
	public List<CustomerServiceRequestDTO> getCustomerRequests()
	{
		return customerRequests;
	}

	/**
	 * Sets the customer requests.
	 *
	 * @param customerRequests
	 *           the new customer requests
	 */
	public void setCustomerRequests(List<CustomerServiceRequestDTO> customerRequests)
	{
		this.customerRequests = customerRequests;
	}

}
