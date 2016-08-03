package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers", namespace = "com.ucs.rsa.common.dto")

public class CustomersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<CustomerDTO> customerDTOs;

	@XmlElement(name = "customer")
	public List<CustomerDTO> getCustomerDTOs() {
		return customerDTOs;
	}

	public void setCustomerDTOs(List<CustomerDTO> customerDTOs) {
		this.customerDTOs = customerDTOs;
	}

}