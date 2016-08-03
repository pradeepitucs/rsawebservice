package com.ucs.rsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.ICustomerRequestDAO;
import com.ucs.rsa.model.AmbulanceRequest;
import com.ucs.rsa.model.CustomerRequest;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.service.ICustomerRequestService;

@Service
public class CustomerRequestServiceImpl extends DefaultBaseService implements
		ICustomerRequestService {

	@Autowired
	@Qualifier("customerRequestDAO")
	ICustomerRequestDAO customerRequestDAO;

	@Override
	public AmbulanceRequest updateAmbulanceRequest(
			AmbulanceRequest iAmbulanceRequest, boolean isCreate) {

		AmbulanceRequest ambulanceRequest = null;
		if (!"".equals(iAmbulanceRequest.getUserModel())
				&& !"".equals(iAmbulanceRequest.getServiceTypeModel())
				&& !"".equals(iAmbulanceRequest.getCustomerLatitude())
				&& !"".equals(iAmbulanceRequest.getCustomerLongitude())
				&& !"".equals(iAmbulanceRequest.getEmployeeId())
				&& !"".equals(iAmbulanceRequest.getIssueId())
				&& !"".equals(iAmbulanceRequest.getIssueStatus())
				&& !"".equals(iAmbulanceRequest.getAmount())) {
			ambulanceRequest = customerRequestDAO.updateAmbulanceRequest(
					iAmbulanceRequest, true);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}

		return ambulanceRequest;
	}

}
