/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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


/**
 * The Class HandleCustomerRequestResource.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/serviceProvider")
public class HandleCustomerRequestResource
{

	/** The customer request service. */
	@Autowired
	private CustomerRequestService customerRequestService;

	/**
	 * Gets the customer request service.
	 *
	 * @return the customer request service
	 */
	public CustomerRequestService getCustomerRequestService()
	{
		return customerRequestService;
	}

	/**
	 * Sets the customer request service.
	 *
	 * @param customerRequestService
	 *           the new customer request service
	 */
	public void setCustomerRequestService(CustomerRequestService customerRequestService)
	{
		this.customerRequestService = customerRequestService;
	}

	/**
	 * Update issuelist.
	 *
	 * @param issue_id
	 *           the issue id
	 * @param issue_status
	 *           the issue status
	 * @param emp_id
	 *           the emp id
	 * @param st_time
	 *           the st time
	 * @return the model and view
	 */
	@RequestMapping(value = "/acceptcustomerissue", method =
	{ RequestMethod.POST })
	private ModelAndView updateIssuelist(@RequestParam("issue_id") final int issue_id,
			@RequestParam("issue_status") final String issue_status, @RequestParam("employee_id") final int emp_id,
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

		final ArrayList<String> customerRequestResponse = getCustomerRequestService()
				.updateCustomerRequestByEmployee(customerRequestModel);
		if (customerRequestResponse.get(1).equalsIgnoreCase("Accepted"))
		{
			Runnable r = new Runnable()
			{
				public void run()
				{
					sendNotificationToCustomer(Integer.parseInt(customerRequestResponse.get(0)), emp_id, issue_id);
				}
			};
			new Thread(r).start();
		}
		return new ModelAndView("xml", "userDTO", customerRequestResponse);
	}

	/**
	 * Send notification to customer.
	 *
	 * @param customerId
	 *           the customer id
	 * @param employeeID
	 *           the employee ID
	 * @param issueID
	 *           the issue ID
	 */
	private void sendNotificationToCustomer(int customerId, int employeeID, int issueID)
	{
		String gcmID = getGCMIDFromCustomerID(customerId);
		ArrayList<String> deviceID = new ArrayList<String>();
		deviceID.add(gcmID);
		int serviceProviderID = getServiceProviderIDFromEmployeeID(employeeID);
		ArrayList<Double> location = getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		EmployeeModel employeeModel = getEmployeeDataFromEmployeeID(employeeID);
		JSONArray jsonArrayObj = new JSONArray();
		JSONObject js = new JSONObject();
		try
		{
			js.put("issueId", issueID);
			js.put("employeeName", employeeModel.getEmployeeName());
			js.put("employeePhoneNumber", employeeModel.getMobileNo());
			js.put("employeeLocation", location.get(0) + "," + location.get(1));
		}
		catch (JSONException e1)
		{
			e1.printStackTrace();
		}
		jsonArrayObj.put(js);
		String msg = jsonArrayObj.toString();
		SendNotification sendNotification = new SendNotification();
		String notificationStatus = sendNotification.sendNotificationData(deviceID, msg); //sent it to the notification //sendGCMNotification(arraylistOfDevices, msg);


	}

	/**
	 * Gets the employee data from employee ID.
	 *
	 * @param employeeID
	 *           the employee ID
	 * @return the employee data from employee ID
	 */
	private EmployeeModel getEmployeeDataFromEmployeeID(int employeeID)
	{
		EmployeeModel employeeModel = getCustomerRequestService().getEmployeeDataFromEmployeeID(employeeID);
		return employeeModel;
	}

	/**
	 * Gets the service provider location from service provider id.
	 *
	 * @param serviceProviderID
	 *           the service provider ID
	 * @return the service provider location from service provider id
	 */
	private ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID)
	{
		ArrayList<Double> location = getCustomerRequestService().getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		return location;
	}

	/**
	 * Gets the service provider ID from employee ID.
	 *
	 * @param employeeID
	 *           the employee ID
	 * @return the service provider ID from employee ID
	 */
	private int getServiceProviderIDFromEmployeeID(int employeeID)
	{
		int serviceProviderID = getCustomerRequestService().getServiceProviderIDFromEmployeeID(employeeID);
		return serviceProviderID;
	}

	/**
	 * Gets the GCMID from customer ID.
	 *
	 * @param customerId
	 *           the customer id
	 * @return the GCMID from customer ID
	 */
	private String getGCMIDFromCustomerID(int customerId)
	{
		String gcmID = getCustomerRequestService().getGCMIDFromCustomerID(customerId);
		return gcmID;
	}

}
