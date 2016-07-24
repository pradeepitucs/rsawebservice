package com.ucs.rsa.service;

import com.ucs.rsa.common.dto.CustomerRequestDTO;

public interface ICustomerRequestService {
	
	public CustomerRequestDTO updateCustomerRequest(CustomerRequestDTO iCustomerRequestDTO, boolean isCreate);

}
