/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class CustomerReviewsDTO.
 */
@XmlRootElement(name = "customer_reviews", namespace = "com.ucs.rsa.common.dto")
public class CustomerReviewsDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The customer review DT os. */
	private List<CustomerReviewDTO> customerReviewDTOs;

	/**
	 * Gets the customer review DT os.
	 *
	 * @return the customer review DT os
	 */
	public List<CustomerReviewDTO> getCustomerReviewDTOs()
	{
		return customerReviewDTOs;
	}

	/**
	 * Sets the customer review DT os.
	 *
	 * @param customerReviewDTOs
	 *           the new customer review DT os
	 */
	public void setCustomerReviewDTOs(List<CustomerReviewDTO> customerReviewDTOs)
	{
		this.customerReviewDTOs = customerReviewDTOs;
	}

}
