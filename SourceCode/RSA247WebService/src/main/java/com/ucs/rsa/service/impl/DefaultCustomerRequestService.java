package com.ucs.rsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerRequestDAO;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.service.CustomerRequestService;

@Service
public class DefaultCustomerRequestService extends DefaultBaseService implements
		CustomerRequestService {

	@Autowired
	@Qualifier("customerRequestDAO")
	CustomerRequestDAO customerRequestDAO;

	@Override
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel) {
		CustomerRequestModel customerRequestModel = null;
		if (!"".equals(iCustomerRequestModel.getCustomerModel())
				&& !"".equals(iCustomerRequestModel.getServiceTypeModel())
				&& !"".equals(iCustomerRequestModel.getCustomerLatitude())
				&& !"".equals(iCustomerRequestModel.getCustomerLongitude())
				&& !"".equals(iCustomerRequestModel.getServiceProviderModel())
				&& !"".equals(iCustomerRequestModel.getIssueId())
				&& !"".equals(iCustomerRequestModel.getIssueStatus())) {
			customerRequestModel = customerRequestDAO.updateCustomerRequest(
					iCustomerRequestModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerRequestModel;
	}

}
