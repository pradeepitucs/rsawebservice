package com.ucs.rsa.resource;

import java.sql.Time;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.notification.SendNotification;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.service.CustomerRequestService;

@Controller
@RequestMapping("/serviceProvider")
public class HandleCustomerRequestResource {
	
	@Autowired
	private CustomerRequestService customerRequestService;

	public CustomerRequestService getCustomerRequestService() {
		return customerRequestService;
	}

	public void setCustomerRequestService(CustomerRequestService customerRequestService) {
		this.customerRequestService = customerRequestService;
	}

	@RequestMapping(value = "/acceptcustomerissue", method = {RequestMethod.POST })
	private ModelAndView updateIssuelist(
	@RequestParam("issue_id") final int issue_id,
	@RequestParam("issue_status") final String issue_status, 
	@RequestParam("employee_id") final int emp_id,
	@RequestParam("issue_start_time") final Time st_time)
	{
	CustomerRequestModel customerRequestModel = new CustomerRequestModel();
	customerRequestModel.setIssueId(issue_id);
	customerRequestModel.setIssueStatus(issue_status);
	customerRequestModel.setIssueStartTime(st_time);
	//customerRequestModel.set

	EmployeeModel serviceProviderModel = new EmployeeModel();
	serviceProviderModel.setUserId(emp_id);
	customerRequestModel.setEmployeeModel(serviceProviderModel);

	ArrayList<String> customerRequestResponse = getCustomerRequestService().updateCustomerRequestByEmployee(customerRequestModel);
	if(customerRequestResponse.get(1).equalsIgnoreCase("Accepted")) {
		Runnable r = new Runnable() {
	         public void run() {
	        	sendNotificationToCustomer(Integer.parseInt(customerRequestResponse.get(0)),emp_id,issue_id);
	         }	
	     };
	     new Thread(r).start();	
		}
	return new ModelAndView("xml", "userDTO",customerRequestResponse);
	}
	
	private void sendNotificationToCustomer(int customerId,int employeeID, int issueID) {
		String gcmID = getGCMIDFromCustomerID(customerId);
		ArrayList<String> deviceID = new ArrayList<String>();
		deviceID.add(gcmID);
		int serviceProviderID = getServiceProviderIDFromEmployeeID(employeeID);
		ArrayList<Double> location = getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		EmployeeModel employeeModel = getEmployeeDataFromEmployeeID(employeeID);
		JSONArray jsonArrayObj = new JSONArray();
		JSONObject js = new JSONObject();
		try {
			js.put("issueId", issueID);
			js.put("employeeName", employeeModel.getEmployeeName());
			js.put("employeePhoneNumber", employeeModel.getMobileNo());
			js.put("employeeLocation", location.get(0)+","+location.get(1));
		} catch (JSONException e1) {
			e1.printStackTrace();
		}	
		jsonArrayObj.put(js);
		String msg = jsonArrayObj.toString();
		SendNotification sendNotification = new SendNotification();
		String notificationStatus = sendNotification.sendNotificationData(deviceID, msg); //sent it to the notification //sendGCMNotification(arraylistOfDevices, msg);
		
		
	}

	private EmployeeModel getEmployeeDataFromEmployeeID(int employeeID) {
		EmployeeModel employeeModel = getCustomerRequestService().getEmployeeDataFromEmployeeID(employeeID);
		return employeeModel;
	}

	private ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID) {
		ArrayList<Double> location = getCustomerRequestService().getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		return location;
	}

	private int getServiceProviderIDFromEmployeeID(int employeeID) {
		int serviceProviderID = getCustomerRequestService().getServiceProviderIDFromEmployeeID(employeeID);
		return serviceProviderID;
	}

	private String getGCMIDFromCustomerID(int customerId) {
		String gcmID = getCustomerRequestService().getGCMIDFromCustomerID(customerId);
		return gcmID;
	}
	
}