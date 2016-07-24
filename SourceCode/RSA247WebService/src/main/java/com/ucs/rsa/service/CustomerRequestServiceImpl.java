package com.ucs.rsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.rsa.common.dto.AmbulanceRequestDTO;
import com.ucs.rsa.common.dto.CustomerRequestDTO;
import com.ucs.rsa.dao.ICustomerRequestDAO;

@Component
public class CustomerRequestServiceImpl extends BaseManagerImpl implements ICustomerRequestService{
	
	@Autowired
	private ICustomerRequestDAO customerRequestDAO;

	@Override
	@Transactional
	public CustomerRequestDTO updateCustomerRequest(CustomerRequestDTO iCustomerRequestDTO, boolean isCreate) {
		CustomerRequestDTO customerRequestDTO = customerRequestDAO.updateUser(iCustomerRequestDTO, true);
		return customerRequestDTO;
	}

}
