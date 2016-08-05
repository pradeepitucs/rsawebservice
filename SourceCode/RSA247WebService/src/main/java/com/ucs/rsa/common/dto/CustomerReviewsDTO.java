package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer_reviews", namespace = "com.ucs.rsa.common.dto")
public class CustomerReviewsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CustomerReviewDTO> customerReviewDTOs;

	public List<CustomerReviewDTO> getCustomerReviewDTOs() {
		return customerReviewDTOs;
	}

	public void setCustomerReviewDTOs(List<CustomerReviewDTO> customerReviewDTOs) {
		this.customerReviewDTOs = customerReviewDTOs;
	}

}
