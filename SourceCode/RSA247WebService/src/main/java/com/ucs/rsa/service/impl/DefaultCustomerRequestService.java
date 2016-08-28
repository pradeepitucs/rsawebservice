/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class DefaultCustomerRequestService.
 */
@Service
public class DefaultCustomerRequestService extends DefaultBaseService implements CustomerRequestService
{

	/** The customer request DAO. */
	@Autowired
	@Qualifier("customerRequestDAO")
	CustomerRequestDAO customerRequestDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#updateCustomerRequest(com.ucs.rsa.model.CustomerRequestModel)
	 */
	@Override
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel)
	{
		CustomerRequestModel customerRequestModel = null;
		if (!"".equals(iCustomerRequestModel.getCustomerModel()) && !"".equals(iCustomerRequestModel.getServiceTypeModel())
				&& !"".equals(iCustomerRequestModel.getCustomerLatitude()) && !"".equals(iCustomerRequestModel.getCustomerLongitude())
				&& !"".equals(iCustomerRequestModel.getEmployeeModel()) && !"".equals(iCustomerRequestModel.getIssueId())
				&& !"".equals(iCustomerRequestModel.getIssueStatus()))
		{
			customerRequestModel = customerRequestDAO.updateCustomerRequest(iCustomerRequestModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerRequestModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ucs.rsa.service.CustomerRequestService#updateCustomerRequestByEmployee(com.ucs.rsa.model.CustomerRequestModel)
	 */
	@Override
	public ArrayList<String> updateCustomerRequestByEmployee(CustomerRequestModel iCustomerRequestModel)
	{
		ArrayList<String> customerRequestResponse = null;
		if (!"".equals(iCustomerRequestModel.getEmployeeModel()) && !"".equals(iCustomerRequestModel.getIssueId())
				&& !"".equals(iCustomerRequestModel.getIssueStatus()))
		{
			customerRequestResponse = customerRequestDAO.updateCustomerRequestByEmployee(iCustomerRequestModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerRequestResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getServiceProviderIDS(java.util.ArrayList, java.lang.String)
	 */
	@Override
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, String serviceType)
	{
		ArrayList<Integer> serviceProviderList = null;
		serviceProviderList = customerRequestDAO.getServiceProviderIDS(ratingAndLocation, serviceType);
		return serviceProviderList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getDeviceIDSFromServiceProviderIDS(java.util.ArrayList)
	 */
	@Override
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs)
	{
		ArrayList<String> deviceIDList = null;
		deviceIDList = customerRequestDAO.getDeviceIDSFromServiceProviderIDS(serviceProviderIDs);
		return deviceIDList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getIssueStatus(int)
	 */
	@Override
	public String getIssueStatus(int issueID)
	{
		String issueStatus = customerRequestDAO.getIssueStatus(issueID);
		return issueStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getGCMIDFromCustomerID(int)
	 */
	@Override
	public String getGCMIDFromCustomerID(int customerId)
	{
		String deviceID = customerRequestDAO.getGCMIDFromCustomerID(customerId);
		return deviceID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getServiceProviderIDFromEmployeeID(int)
	 */
	@Override
	public int getServiceProviderIDFromEmployeeID(int employeeID)
	{
		int serviceProviderID = customerRequestDAO.getServiceProviderIDFromEmployeeID(employeeID);
		return serviceProviderID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getServiceProviderLocationFromServiceProviderId(int)
	 */
	@Override
	public ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID)
	{
		ArrayList<Double> location = customerRequestDAO.getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		return location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getEmployeeDataFromEmployeeID(int)
	 */
	@Override
	public EmployeeModel getEmployeeDataFromEmployeeID(int employeeID)
	{
		EmployeeModel employeeModel = customerRequestDAO.getEmployeeDataFromEmployeeID(employeeID);
		return employeeModel;
	}

}
