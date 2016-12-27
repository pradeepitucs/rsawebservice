package com.ucs.rsa.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerServiceRequestDAO;
import com.ucs.rsa.model.CustomerServiceRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.service.CustomerServiceRequestService;

/**
 * The Class DefaultCustomerServiceRequestService.
 */
@Service
public class DefaultCustomerServiceRequestService extends DefaultBaseService implements CustomerServiceRequestService {

	/** The customer request dao. */
	@Autowired
	@Qualifier("customerServiceRequestDAO")
	CustomerServiceRequestDAO customerRequestDAO;
	
	/* (non-Javadoc)
	 * @see com.ucs.rsa.service.CustomerServiceRequestService#updateCustomerServiceRequest(com.ucs.rsa.model.CustomerServiceRequestModel)
	 */
	@Override
	public CustomerServiceRequestModel updateCustomerServiceRequest(CustomerServiceRequestModel iCustomerRequestModel) {
		CustomerServiceRequestModel customerRequestModel = null;
		if (!"".equals(iCustomerRequestModel.getCustomerModel())
				&& !"".equals(iCustomerRequestModel.getServiceTypeModel())
				&& !"".equals(iCustomerRequestModel.getCustomerLatitude())
				&& !"".equals(iCustomerRequestModel.getCustomerLongitude())
				&& !"".equals(iCustomerRequestModel.getCustomerServiceRequestID())) {
			customerRequestModel = customerRequestDAO.updateCustomerServiceRequest(iCustomerRequestModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerRequestModel;
	}

	/* (non-Javadoc)
	 * @see com.ucs.rsa.service.CustomerServiceRequestService#getServiceProviders(java.util.ArrayList, int)
	 */
	@Override
	public ArrayList<ServiceProviderModel> getServiceProviders(ArrayList<Double> ratingArray, int serviceTypeId) {
		ArrayList<ServiceProviderModel> serviceProviders = new ArrayList<ServiceProviderModel>();
		serviceProviders = customerRequestDAO.getServiceProviders(ratingArray, serviceTypeId);
		return serviceProviders;
	}

	/* (non-Javadoc)
	 * @see com.ucs.rsa.service.CustomerServiceRequestService#updateVehicleServiceType(com.ucs.rsa.model.CustomerServiceRequestModel)
	 */
	@Override
	public CustomerServiceRequestModel updateVehicleServiceType(
			CustomerServiceRequestModel customerServiceRequestmodel) {
		CustomerServiceRequestModel customerRequestModel = null;
		if (!"".equals(customerServiceRequestmodel.getCustomerServiceRequestID())
				&& !"".equals(customerServiceRequestmodel.getServiceTypeModel())) {
			customerRequestModel = customerRequestDAO.updateVehicleServiceType(customerServiceRequestmodel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerRequestModel;
	}

	/* (non-Javadoc)
	 * @see com.ucs.rsa.service.CustomerServiceRequestService#getEmployees(int)
	 */
	@Override
	public ArrayList<EmployeeModel> getEmployees(int serviceProviderId) {
		ArrayList<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		employees = customerRequestDAO.getEmployees(serviceProviderId);
		return employees;
	}

	

}
