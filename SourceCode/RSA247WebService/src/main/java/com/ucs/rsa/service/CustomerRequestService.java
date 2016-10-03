package com.ucs.rsa.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.CustomerSubIssueModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderCommentModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserVehicleModel;

public interface CustomerRequestService extends BaseService {

	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel);
	
	public ArrayList<String> updateCustomerRequestByEmployee(CustomerRequestModel iCustomerRequestModel);
	
	public CustomerRequestModel updateCustomerIssueAfterAccepting(CustomerRequestModel iCustomerRequestModel);
	
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, int serviceType,String newTimeFormat);
	
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs);
	
	public String getIssueStatus(int issueID);
	
	public UserVehicleModel getUserVehicle(int customerID);
	
	public String getGCMIDFromCustomerID(int customerId);
	
	public int getServiceProviderIDFromEmployeeID(int employeeID);
	
	public ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID);
	
	public EmployeeModel getEmployeeDataFromEmployeeID(int employeeID);
	
	public CustomerRequestModel updateCustomerIssueByServiceProvider(CustomerRequestModel customerRequestModel,ArrayList<CustomerSubIssueModel> customerSubIssueModelList,ServiceProviderCommentModel serviceProviderCommentModel);
	
	public CustomerRequestModel rejectCustomerIssue(CustomerRequestModel customerRequestModel,ServiceProviderCommentModel serviceProviderCommentModel);
	
	public List<ServiceTypeModel> getCompletedService(int issueID,CustomerRequestModel customerRequestModel);
	
	public List<ServiceTypeModel> getPaymentDetail(int issueID);

}
