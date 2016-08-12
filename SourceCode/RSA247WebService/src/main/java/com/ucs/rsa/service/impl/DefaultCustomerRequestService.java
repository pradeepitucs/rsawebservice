package com.ucs.rsa.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerRequestDAO;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;
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
				&& !"".equals(iCustomerRequestModel.getEmployeeModel())
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
	
	@Override
	public ArrayList<String> updateCustomerRequestByEmployee(CustomerRequestModel iCustomerRequestModel) {
		ArrayList<String> customerRequestResponse = null;
		if (  !"".equals(iCustomerRequestModel.getEmployeeModel())
				&& !"".equals(iCustomerRequestModel.getIssueId())
				&& !"".equals(iCustomerRequestModel.getIssueStatus())) {
			customerRequestResponse = customerRequestDAO.updateCustomerRequestByEmployee(
					iCustomerRequestModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerRequestResponse;
	}
	
	@Override
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, String serviceType) {
		ArrayList<Integer> serviceProviderList =null;
		serviceProviderList = customerRequestDAO.getServiceProviderIDS(ratingAndLocation, serviceType);
		return serviceProviderList;
	}
	
	@Override
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs) {
		ArrayList<String> deviceIDList =null;
		deviceIDList = customerRequestDAO.getDeviceIDSFromServiceProviderIDS(serviceProviderIDs);
		return deviceIDList;
	}

	@Override
	public String getIssueStatus(int issueID) {
		String issueStatus = customerRequestDAO.getIssueStatus(issueID);
		return issueStatus;
	}
	
	@Override
	public String getGCMIDFromCustomerID(int customerId){
		String deviceID = customerRequestDAO.getGCMIDFromCustomerID(customerId);
		return deviceID;
	}

	@Override
	public int getServiceProviderIDFromEmployeeID(int employeeID) {
		int serviceProviderID = customerRequestDAO.getServiceProviderIDFromEmployeeID(employeeID);
		return serviceProviderID;
	}

	@Override
	public ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID) {
		ArrayList<Double> location = customerRequestDAO.getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		return location;
	}

	@Override
	public EmployeeModel getEmployeeDataFromEmployeeID(int employeeID) {
		EmployeeModel employeeModel = customerRequestDAO.getEmployeeDataFromEmployeeID(employeeID);
		return employeeModel;
	}

}
