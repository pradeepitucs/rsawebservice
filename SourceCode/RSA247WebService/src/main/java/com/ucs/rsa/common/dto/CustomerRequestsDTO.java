package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer_requests", namespace = "com.ucs.rsa.common.dto")
public class CustomerRequestsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<CustomerRequestDTO> customerRequests;

	public List<CustomerRequestDTO> getCustomerRequests() {
		return customerRequests;
	}

	public void setCustomerRequests(List<CustomerRequestDTO> customerRequests) {
		this.customerRequests = customerRequests;
	}

	
}
