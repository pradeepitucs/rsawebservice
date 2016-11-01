/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerRequestDAO;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.CustomerSubIssueModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderCommentModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.service.CustomerRequestService;


// TODO: Auto-generated Javadoc
/**
 * The Class DefaultCustomerRequestService.
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
				&& !"".equals(iCustomerRequestModel.getEmployeeID()) && !"".equals(iCustomerRequestModel.getIssueId())
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
		if (!"".equals(iCustomerRequestModel.getEmployeeID()) && !"".equals(iCustomerRequestModel.getIssueId())
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
	 * @see com.ucs.rsa.service.CustomerRequestService#getServiceProviderIDS(java.util.ArrayList, int, java.lang.String)
	 */
	@Override
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, int serviceType, String newTimeFormat)
	{
		ArrayList<Integer> serviceProviderList = null;
		serviceProviderList = customerRequestDAO.getServiceProviderIDS(ratingAndLocation, serviceType, newTimeFormat);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#updateCustomerIssueAfterAccepting(com.ucs.rsa.model.
	 * CustomerRequestModel)
	 */
	@Override
	public CustomerRequestModel updateCustomerIssueAfterAccepting(CustomerRequestModel iCustomerRequestModel)
	{
		CustomerRequestModel customerRequestResponse = null;
		if (!"".equals(iCustomerRequestModel.getEmployeeID()) && !"".equals(iCustomerRequestModel.getIssueId())
				&& !"".equals(iCustomerRequestModel.getIssueStatus()))
		{
			customerRequestResponse = customerRequestDAO.updateCustomerIssueAfterAccepting(iCustomerRequestModel);
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
	 * @see com.ucs.rsa.service.CustomerRequestService#getUserVehicle(int)
	 */
	@Override
	public UserVehicleModel getUserVehicle(int customerID)
	{
		UserVehicleModel userVehicleModel = customerRequestDAO.getUserVehicle(customerID);
		return userVehicleModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#updateCustomerIssueByServiceProvider(com.ucs.rsa.model.
	 * CustomerRequestModel, java.util.ArrayList, com.ucs.rsa.model.ServiceProviderCommentModel)
	 */
	@Override
	public CustomerRequestModel updateCustomerIssueByServiceProvider(CustomerRequestModel customerRequestModel,
			ArrayList<CustomerSubIssueModel> customerSubIssueModelList, ServiceProviderCommentModel serviceProviderCommentModel)
	{
		CustomerRequestModel customerRequestResponse = null;
		if (!"".equals(customerRequestModel.getEmployeeID()) && !"".equals(customerRequestModel.getIssueId())
				&& !"".equals(customerRequestModel.getIssueStatus()) && !"".equals(customerSubIssueModelList)
				&& !"".equals(serviceProviderCommentModel))
		{
			customerRequestResponse = customerRequestDAO.updateCustomerIssueByServiceProvider(customerRequestModel,
					customerSubIssueModelList, serviceProviderCommentModel);
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
	 * @see com.ucs.rsa.service.CustomerRequestService#rejectCustomerIssue(com.ucs.rsa.model.CustomerRequestModel,
	 * com.ucs.rsa.model.ServiceProviderCommentModel)
	 */
	@Override
	public CustomerRequestModel rejectCustomerIssue(CustomerRequestModel customerRequestModel,
			ServiceProviderCommentModel serviceProviderCommentModel)
	{
		CustomerRequestModel customerRequestResponse = null;
		if (!"".equals(customerRequestModel.getEmployeeID()) && !"".equals(customerRequestModel.getIssueId())
				&& !"".equals(customerRequestModel.getIssueStatus()) && !"".equals(serviceProviderCommentModel))
		{
			customerRequestResponse = customerRequestDAO.rejectCustomerIssue(customerRequestModel, serviceProviderCommentModel);
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
	 * @see com.ucs.rsa.service.CustomerRequestService#getCompletedService(int, com.ucs.rsa.model.CustomerRequestModel)
	 */
	@Override
	public List<ServiceTypeModel> getCompletedService(int issueID, CustomerRequestModel customerRequestModel)
	{
		List<ServiceTypeModel> serviceType = null;
		if (issueID != 0)
		{
			serviceType = customerRequestDAO.getCompletedService(issueID, customerRequestModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return serviceType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerRequestService#getPaymentDetail(int)
	 */
	@Override
	public List<ServiceTypeModel> getPaymentDetail(int issueID)
	{
		List<ServiceTypeModel> serviceType = null;
		if (issueID != 0)
		{
			serviceType = customerRequestDAO.getPaymentDetail(issueID);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return serviceType;
	}

	@Override
	public List<CustomerRequestModel> filteredCustomerIssues(String iApprove, String iIssueStatus, String iTypes)
	{
		Comparator<CustomerRequestModel> groupByComparator = Comparator.comparing(CustomerRequestModel::getIssueId);
		List<CustomerRequestModel> result = new ArrayList<>();

		if (iApprove == null && iIssueStatus == null && iTypes != null)
		{
			result = customerRequestDAO.loadAll(CustomerRequestModel.class).stream()
					.filter(e -> e.getServiceTypeModel().getServiceTypeId() == Integer.parseInt(iTypes)).sorted(groupByComparator)
					.collect(Collectors.toList());

		}
		else if (iApprove == null && iIssueStatus != null && iTypes == null)
		{
			result = customerRequestDAO.loadAll(CustomerRequestModel.class).stream()
					.filter(e -> e.getIssueStatus().equals(iIssueStatus)).sorted(groupByComparator).collect(Collectors.toList());
		}
		else if (iApprove != null && iIssueStatus == null && iTypes == null)
		{
			result = customerRequestDAO.loadAll(CustomerRequestModel.class).stream()
					.filter(e -> e.getIsEnabled() == Boolean.valueOf(iApprove)).sorted(groupByComparator).collect(Collectors.toList());
		}
		else if (iApprove == null && iIssueStatus != null && iTypes != null)
		{
			result = customerRequestDAO.loadAll(CustomerRequestModel.class).stream()
					.filter(e -> e.getServiceTypeModel().getServiceTypeId() == Integer.parseInt(iTypes)
							&& e.getIssueStatus().equals(iIssueStatus))
					.sorted(groupByComparator).collect(Collectors.toList());
		}
		else if (iApprove != null && iIssueStatus == null && iTypes != null)
		{
			result = customerRequestDAO.loadAll(CustomerRequestModel.class).stream()
					.filter(e -> e.getServiceTypeModel().getServiceTypeId() == Integer.parseInt(iTypes)
							&& e.getIsEnabled() == Boolean.valueOf(iApprove))
					.sorted(groupByComparator).collect(Collectors.toList());
		}
		else if (iApprove != null && iIssueStatus != null && iTypes == null)
		{
			result = customerRequestDAO.loadAll(CustomerRequestModel.class).stream()
					.filter(e -> e.getIssueStatus().equals(iIssueStatus) && e.getIsEnabled() == Boolean.valueOf(iApprove))
					.sorted(groupByComparator).collect(Collectors.toList());
		}
		else if (iApprove == null && iIssueStatus != null && iTypes != null)
		{
			result = customerRequestDAO.loadAll(CustomerRequestModel.class).stream()
					.filter(e -> e.getServiceTypeModel().getServiceTypeId() == Integer.parseInt(iTypes)
							&& e.getIssueStatus().equals(iIssueStatus) && e.getIsEnabled() == Boolean.valueOf(iApprove))
					.sorted(groupByComparator).collect(Collectors.toList());
		}

		return result;
	}

}
