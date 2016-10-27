/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class CustomersDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "customers", namespace = "com.ucs.rsa.common.dto")

public class CustomersDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The customer DT os. */
	private List<CustomerDTO> customerDTOs;

	/**
	 * Gets the customer DT os.
	 *
	 * @return the customer DT os
	 */
	@XmlElement(name = "customer")
	public List<CustomerDTO> getCustomerDTOs()
	{
		return customerDTOs;
	}

	/**
	 * Sets the customer DT os.
	 *
	 * @param customerDTOs
	 *           the new customer DT os
	 */
	public void setCustomerDTOs(List<CustomerDTO> customerDTOs)
	{
		this.customerDTOs = customerDTOs;
	}

}
