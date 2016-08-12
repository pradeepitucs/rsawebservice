package com.ucs.rsa.service;

import java.util.ArrayList;

import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;

public interface CustomerRequestService extends BaseService {

	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel);
	
	public ArrayList<String> updateCustomerRequestByEmployee(CustomerRequestModel iCustomerRequestModel);
	
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, String serviceType);
	
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs);
	
	public String getIssueStatus(int issueID);
	
	public String getGCMIDFromCustomerID(int customerId);
	
	public int getServiceProviderIDFromEmployeeID(int employeeID);
	
	public ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID);
	
	public EmployeeModel getEmployeeDataFromEmployeeID(int employeeID);

}
