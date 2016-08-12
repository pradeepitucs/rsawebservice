package com.ucs.rsa.service;

import java.util.ArrayList;

import com.ucs.rsa.model.CustomerRequestModel;

public interface CustomerRequestService extends BaseService {

	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel);
	
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, String serviceType);
	
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs);
	
	public String getIssueStatus(int issueID);

}
