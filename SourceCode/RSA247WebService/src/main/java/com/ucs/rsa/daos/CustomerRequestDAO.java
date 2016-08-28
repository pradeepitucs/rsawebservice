/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos;

import java.util.ArrayList;

import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Interface CustomerRequestDAO.
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
	 * Gets the service provider IDS.
	 *
	 * @param ratingAndLocation
	 *           the rating and location
	 * @param serviceType
	 *           the service type
	 * @return the service provider IDS
	 */
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, String serviceType);

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

}
