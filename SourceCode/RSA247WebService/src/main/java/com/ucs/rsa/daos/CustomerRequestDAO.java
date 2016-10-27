/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos;

import java.util.ArrayList;
import java.util.List;

import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.CustomerSubIssueModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderCommentModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserVehicleModel;


// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerRequestDAO.
 */
public interface CustomerRequestDAO extends BaseDAO
{

	/**
	 * Update customer request.
	 *
	 * @param iCustomerRequestModel
	 *           the i customer request model
	 * @return the customer request model
	 */
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel);

	/**
	 * Update customer request by employee.
	 *
	 * @param iCustomerRequestModel
	 *           the i customer request model
	 * @return the array list
	 */
	public ArrayList<String> updateCustomerRequestByEmployee(CustomerRequestModel iCustomerRequestModel);

	/**
	 * Update customer issue after accepting.
	 *
	 * @param iCustomerRequestModel
	 *           the i customer request model
	 * @return the customer request model
	 */
	public CustomerRequestModel updateCustomerIssueAfterAccepting(CustomerRequestModel iCustomerRequestModel);

	/**
	 * Gets the service provider IDS.
	 *
	 * @param ratingAndLocation
	 *           the rating and location
	 * @param serviceType
	 *           the service type
	 * @param newTimeFormat
	 *           the new time format
	 * @return the service provider IDS
	 */
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, int serviceType, String newTimeFormat);

	/**
	 * Gets the device IDS from service provider IDS.
	 *
	 * @param serviceProviderIDs
	 *           the service provider I ds
	 * @return the device IDS from service provider IDS
	 */
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs);

	/**
	 * Gets the issue status.
	 *
	 * @param issueID
	 *           the issue ID
	 * @return the issue status
	 */
	public String getIssueStatus(int issueID);

	/**
	 * Gets the user vehicle.
	 *
	 * @param customerID
	 *           the customer ID
	 * @return the user vehicle
	 */
	public UserVehicleModel getUserVehicle(int customerID);

	/**
	 * Gets the GCMID from customer ID.
	 *
	 * @param customerId
	 *           the customer id
	 * @return the GCMID from customer ID
	 */
	public String getGCMIDFromCustomerID(int customerId);

	/**
	 * Gets the service provider ID from employee ID.
	 *
	 * @param employeeID
	 *           the employee ID
	 * @return the service provider ID from employee ID
	 */
	public int getServiceProviderIDFromEmployeeID(int employeeID);

	/**
	 * Gets the service provider location from service provider id.
	 *
	 * @param serviceProviderID
	 *           the service provider ID
	 * @return the service provider location from service provider id
	 */
	public ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID);

	/**
	 * Gets the employee data from employee ID.
	 *
	 * @param employeeID
	 *           the employee ID
	 * @return the employee data from employee ID
	 */
	public EmployeeModel getEmployeeDataFromEmployeeID(int employeeID);

	/**
	 * Update customer issue by service provider.
	 *
	 * @param customerRequestModel
	 *           the customer request model
	 * @param customerSubIssueModelList
	 *           the customer sub issue model list
	 * @param serviceProviderCommentModel
	 *           the service provider comment model
	 * @return the customer request model
	 */
	public CustomerRequestModel updateCustomerIssueByServiceProvider(CustomerRequestModel customerRequestModel,
			ArrayList<CustomerSubIssueModel> customerSubIssueModelList, ServiceProviderCommentModel serviceProviderCommentModel);

	/**
	 * Reject customer issue.
	 *
	 * @param customerRequestModel
	 *           the customer request model
	 * @param serviceProviderCommentModel
	 *           the service provider comment model
	 * @return the customer request model
	 */
	public CustomerRequestModel rejectCustomerIssue(CustomerRequestModel customerRequestModel,
			ServiceProviderCommentModel serviceProviderCommentModel);

	/**
	 * Gets the completed service.
	 *
	 * @param issueID
	 *           the issue ID
	 * @param customerRequestModel
	 *           the customer request model
	 * @return the completed service
	 */
	public List<ServiceTypeModel> getCompletedService(int issueID, CustomerRequestModel customerRequestModel);

	/**
	 * Gets the payment detail.
	 *
	 * @param issueID
	 *           the issue ID
	 * @return the payment detail
	 */
	public List<ServiceTypeModel> getPaymentDetail(int issueID);

}
