package com.ucs.rsa.dao;

import com.ucs.rsa.common.dto.CustomerRequestDTO;

public interface ICustomerRequestDAO {
	
	public CustomerRequestDTO updateUser(CustomerRequestDTO iCustomerRequestDTO, boolean isCreate);

}
