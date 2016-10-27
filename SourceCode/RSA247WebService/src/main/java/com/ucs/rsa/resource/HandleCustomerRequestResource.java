/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.CustomerRequestDTO;
import com.ucs.rsa.common.dto.ServiceTypeDTO;
import com.ucs.rsa.common.notification.SendNotification;
import com.ucs.rsa.common.sms.SmsLane;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.CustomerSubIssueModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderCommentModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserModel;
import com.ucs.rsa.service.CustomerRequestService;


/**
 * The Class HandleCustomerRequestResource.
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
	 * Gets the employee data from employee ID.
	 *
	 * @param employeeID
	 *           the employee ID
	 * @return the employee data from employee ID
	 */
	@SuppressWarnings("unused")
	private EmployeeModel getEmployeeDataFromEmployeeID(int employeeID)
	{
		EmployeeModel employeeModel = getCustomerRequestService().getEmployeeDataFromEmployeeID(employeeID);
		return employeeModel;
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

	/**
	 * Gets the service provider ID from employee ID.
	 *
	 * @param employeeID
	 *           the employee ID
	 * @return the service provider ID from employee ID
	 */
	@SuppressWarnings("unused")
	private int getServiceProviderIDFromEmployeeID(int employeeID)
	{
		int serviceProviderID = getCustomerRequestService().getServiceProviderIDFromEmployeeID(employeeID);
		return serviceProviderID;
	}

	/**
	 * Gets the service provider location from service provider id.
	 *
	 * @param serviceProviderID
	 *           the service provider ID
	 * @return the service provider location from service provider id
	 */
	@SuppressWarnings("unused")
	private ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID)
	{
		ArrayList<Double> location = getCustomerRequestService().getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		return location;
	}

	/**
	 * Payment detail.
	 *
	 * @param issue_id
	 *           the issue id
	 * @param issue_status
	 *           the issue status
	 * @param emp_id
	 *           the emp id
	 * @return the model and view
	 */
	@RequestMapping(value = "/paymentDetail", method =
	{ RequestMethod.POST })
	private ModelAndView paymentDetail(@RequestParam("issue_id") final int issue_id,
			@RequestParam("issue_status") final String issue_status, @RequestParam("employee_id") final int emp_id)
	{
		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setIssueId(issue_id);
		customerRequestModel.setIssueStatus(issue_status);
		/*
		 * EmployeeModel serviceProviderModel = new EmployeeModel(); serviceProviderModel.setUserId(emp_id);
		 */
		customerRequestModel.setEmployeeID(emp_id);
		List<ServiceTypeModel> serviceCompleted = getCustomerRequestService().getCompletedService(issue_id, customerRequestModel);
		List<ServiceTypeDTO> ServiceTypeDTO = new ArrayList<>();
		for (ServiceTypeModel serviceType : serviceCompleted)
		{
			CustomerRequestModel customerReq = new CustomerRequestModel();
			customerReq = getCustomerRequestService().get(CustomerRequestModel.class, issue_id);
			CustomerModel customer = new CustomerModel();
			customer = getCustomerRequestService().get(CustomerModel.class, customerReq.getCustomerModel().getUserId());
			ServiceTypeDTO serviceTypeD = new ServiceTypeDTO();
			if (customer.isMember())
			{
				serviceTypeD.setMemberPrice(serviceType.getMemberPrice());
			}
			else
			{
				serviceTypeD.setNonMemberPrice(serviceType.getNonMemberPrice());
			}
			serviceTypeD.setServiceType(serviceType.getServiceType());
			serviceTypeD.setServiceTypeId(serviceType.getServiceTypeId());

			ServiceTypeDTO.add(serviceTypeD);

		}
		if (serviceCompleted != null)
		{
			Runnable r = new Runnable()
			{
				public void run()
				{
					CustomerRequestModel customerRequestModel = new CustomerRequestModel();
					customerRequestModel = getCustomerRequestService().get(CustomerRequestModel.class, issue_id);
					sendNotificationToCustomer(customerRequestModel.getCustomerModel().getUserId(), issue_status, emp_id, issue_id);
				}
			};
			new Thread(r).start();
		}
		return new ModelAndView("xml", "ServiceTypeDTO", ServiceTypeDTO);
	}

	/**
	 * Reject customer issue.
	 *
	 * @param issue_id
	 *           the issue id
	 * @param issue_status
	 *           the issue status
	 * @param reject_comment
	 *           the reject comment
	 * @param emp_id
	 *           the emp id
	 * @return the model and view
	 */
	@RequestMapping(value = "/rejectcustomerissue", method =
	{ RequestMethod.POST })
	private ModelAndView rejectCustomerIssue(@RequestParam("issue_id") final int issue_id,
			@RequestParam("issue_status") final String issue_status, @RequestParam("rejectComment") final String reject_comment,
			@RequestParam("employee_id") final int emp_id)
	{
		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setIssueId(issue_id);
		customerRequestModel.setIssueStatus(issue_status);

		/*
		 * EmployeeModel serviceProviderModel = new EmployeeModel(); serviceProviderModel.setUserId(emp_id);
		 */
		customerRequestModel.setEmployeeID(emp_id);

		UserModel userModel = new UserModel();
		userModel.setUserId(emp_id);

		CustomerRequestModel customerRequestData = new CustomerRequestModel();
		customerRequestData.setIssueId(issue_id);

		ServiceProviderCommentModel serviceProviderCommentModel = new ServiceProviderCommentModel();
		serviceProviderCommentModel.setServiceProviderComment(reject_comment);
		serviceProviderCommentModel.setCustomerRequestModel(customerRequestData);
		serviceProviderCommentModel.setUserModel(userModel);

		CustomerRequestModel customerRequest = getCustomerRequestService().rejectCustomerIssue(customerRequestModel,
				serviceProviderCommentModel);
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		if (customerRequest != null)
		{
			customerRequestDTO.setCustomerLatitude(customerRequest.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequest.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequest.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequest.getIssueStatus());
		}
		return new ModelAndView("xml", "customerRequestDTO", customerRequestDTO);

	}

	/**
	 * Send notification to customer.
	 *
	 * @param customerId
	 *           the customer id
	 * @param status
	 *           the status
	 * @param employeeID
	 *           the employee ID
	 * @param issueID
	 *           the issue ID
	 */
	private void sendNotificationToCustomer(int customerId, String status, int employeeID, int issueID)
	{
		String gcmID = getGCMIDFromCustomerID(customerId);
		ArrayList<String> deviceID = new ArrayList<String>();
		deviceID.add(gcmID);
		CustomerRequestModel customerRequestmodel = new CustomerRequestModel();
		customerRequestmodel = getCustomerRequestService().get(CustomerRequestModel.class, issueID);
		ServiceTypeModel servicetype = new ServiceTypeModel();
		servicetype = getCustomerRequestService().get(ServiceTypeModel.class,
				customerRequestmodel.getServiceTypeModel().getServiceTypeId());
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel = getCustomerRequestService().get(EmployeeModel.class, employeeID);
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getCustomerRequestService().get(ServiceProviderModel.class, employeeModel.getServiceProviderID());
		ArrayList<Double> location = new ArrayList<Double>();//getServiceProviderLocationFromServiceProviderId(serviceProviderID);
		location.add(serviceProviderModel.getServiceProviderLatitude());
		location.add(serviceProviderModel.getServiceProviderLongitude());
		CustomerModel customerModel = new CustomerModel();
		customerModel = getCustomerRequestService().get(CustomerModel.class, customerId);
		String smsForCustomer = "Your Service request for a " + servicetype.getServiceType() + " has been accepted by "
				+ serviceProviderModel.getServiceProviderName() + ", mobile no. +91 " + employeeModel.getMobileNo() + ".";
		String smsForEmployee = "You have accepted a request for " + servicetype.getServiceType() + " of Mr."
				+ customerModel.getFirstName() + " " + customerModel.getLastName() + ". Mobile no. +91 " + customerModel.getMobileNo()
				+ ". Please start as soon as possible.";
		//SmsLane.SMSSender("pradeepit", "pradeep143", "91" + customerModel.getMobileNo(), smsForCustomer, "WebSMS", "0");
		//SmsLane.SMSSender("pradeepit", "pradeep143", "91" + employeeModel.getMobileNo(), smsForEmployee, "WebSMS", "0");
		JSONArray jsonArrayObj = new JSONArray();
		JSONObject js = new JSONObject();
		try
		{
			js.put("issueId", issueID);
			js.put("employeeId", employeeModel.getUserId());
			js.put("employeeName", employeeModel.getEmployeeName());
			js.put("employeePhoneNumber", employeeModel.getMobileNo());
			js.put("employeeLocation", location.get(0) + "," + location.get(1));
			js.put("service_provider_id", employeeModel.getServiceProviderID());
			js.put("issue_status", status);
			js.put("service_provider_name", serviceProviderModel.getServiceProviderName());
		}
		catch (JSONException e1)
		{
			e1.printStackTrace();
		}
		jsonArrayObj.put(js);
		String msg = jsonArrayObj.toString();
		SendNotification sendNotification = new SendNotification();
		@SuppressWarnings("unused")
		String notificationStatus = sendNotification.sendNotificationData(deviceID, msg);

	}

	/**
	 * Send notification to customer for location.
	 *
	 * @param location
	 *           the location
	 * @param emp_id
	 *           the emp id
	 * @param issue_id
	 *           the issue id
	 */
	private void sendNotificationToCustomerForLocation(String location, int emp_id, int issue_id)
	{
		CustomerRequestModel customerRequestmodel = new CustomerRequestModel();
		customerRequestmodel = getCustomerRequestService().get(CustomerRequestModel.class, issue_id);
		String gcmID = getGCMIDFromCustomerID(customerRequestmodel.getCustomerModel().getUserId());
		ArrayList<String> deviceID = new ArrayList<String>();
		deviceID.add(gcmID);
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel = getCustomerRequestService().get(EmployeeModel.class, emp_id);
		JSONArray jsonArrayObj = new JSONArray();
		JSONObject js = new JSONObject();
		try
		{
			js.put("issueId", issue_id);
			js.put("employeeId", employeeModel.getUserId());
			js.put("employeeName", employeeModel.getEmployeeName());
			js.put("employeePhoneNumber", employeeModel.getMobileNo());
			js.put("employeeLocation", location);
			js.put("service_provider_id", employeeModel.getServiceProviderID());
		}
		catch (JSONException e1)
		{
			e1.printStackTrace();
		}
		jsonArrayObj.put(js);
		String msg = jsonArrayObj.toString();
		SendNotification sendNotification = new SendNotification();
		@SuppressWarnings("unused")
		String notificationStatus = sendNotification.sendNotificationData(deviceID, msg);

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
	 * Update customer issue.
	 *
	 * @param issue_id
	 *           the issue id
	 * @param issue_status
	 *           the issue status
	 * @param emp_id
	 *           the emp id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updatecustomerissue", method =
	{ RequestMethod.POST })
	private ModelAndView updateCustomerIssue(@RequestParam("issue_id") final int issue_id,
			@RequestParam("issue_status") final String issue_status, @RequestParam("employee_id") final int emp_id)
	{
		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setIssueId(issue_id);
		customerRequestModel.setIssueStatus(issue_status);

		/*
		 * EmployeeModel serviceProviderModel = new EmployeeModel(); serviceProviderModel.setUserId(emp_id);
		 */
		customerRequestModel.setEmployeeID(emp_id);
		final CustomerRequestModel customerRequest = getCustomerRequestService()
				.updateCustomerIssueAfterAccepting(customerRequestModel);
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		if (customerRequest != null)
		{
			customerRequestDTO.setCustomerLatitude(customerRequest.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequest.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequest.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequest.getIssueStatus());
			Runnable r = new Runnable()
			{
				public void run()
				{
					sendNotificationToCustomer(customerRequest.getCustomerModel().getUserId(), customerRequest.getIssueStatus(),
							emp_id, issue_id);
				}
			};
			new Thread(r).start();
		}
		return new ModelAndView("xml", "customerRequestDTO", customerRequestDTO);

	}

	/**
	 * Update customer issue by employee.
	 *
	 * @param issue_id
	 *           the issue id
	 * @param serviceProviderComment
	 *           the service provider comment
	 * @param issue_status
	 *           the issue status
	 * @param serviceType
	 *           the service type
	 * @param emp_id
	 *           the emp id
	 * @param customer_vehicle_number
	 *           the customer vehicle number
	 * @return the model and view
	 */
	@RequestMapping(value = "/updatecustomerissuebyserviceprovider", method =
	{ RequestMethod.POST })
	private ModelAndView updateCustomerIssueByEmployee(@RequestParam("issue_id") final int issue_id,
			@RequestParam("service_provider_comment") final String serviceProviderComment,
			@RequestParam("issue_status") final String issue_status, @RequestParam("service_type") final String serviceType,
			@RequestParam("employee_id") final int emp_id,
			@RequestParam("customer_vehicle_number") final String customer_vehicle_number)
	{
		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setIssueId(issue_id);
		customerRequestModel.setIssueStatus(issue_status);

		/*
		 * EmployeeModel serviceProviderModel = new EmployeeModel(); serviceProviderModel.setUserId(emp_id);
		 */
		customerRequestModel.setEmployeeID(emp_id);

		UserModel userModel = new UserModel();
		userModel.setUserId(emp_id);

		CustomerRequestModel customerRequestData = new CustomerRequestModel();
		customerRequestData.setIssueId(issue_id);

		ServiceProviderCommentModel serviceProviderCommentModel = new ServiceProviderCommentModel();
		serviceProviderCommentModel.setServiceProviderComment(serviceProviderComment);
		serviceProviderCommentModel.setCustomerRequestModel(customerRequestData);
		serviceProviderCommentModel.setUserModel(userModel);
		String[] serviceTypesID = serviceType.split(",");
		ArrayList<CustomerSubIssueModel> customerSubIssueModelList = new ArrayList<CustomerSubIssueModel>();
		for (int i = 0; i < serviceTypesID.length; i++)
		{

			CustomerSubIssueModel customerSubIssueModel = new CustomerSubIssueModel();
			ServiceTypeModel servicetypeModel = new ServiceTypeModel();
			servicetypeModel.setServiceTypeId(Integer.parseInt(serviceTypesID[i]));
			customerSubIssueModel.setCustomerRequestModel(customerRequestData);
			customerSubIssueModel.setServiceTypeModel(servicetypeModel);
			customerSubIssueModelList.add(customerSubIssueModel);
		}

		CustomerRequestModel customerRequest = getCustomerRequestService()
				.updateCustomerIssueByServiceProvider(customerRequestModel, customerSubIssueModelList, serviceProviderCommentModel);

		/*
		 * CustomerRequestModel customerRequest = getCustomerRequestService()
		 * .updateCustomerIssueAfterAccepting(customerRequestModel);
		 */
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		if (customerRequest != null)
		{
			customerRequestDTO.setCustomerLatitude(customerRequest.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequest.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequest.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequest.getIssueStatus());
		}
		return new ModelAndView("xml", "customerRequestDTO", customerRequestDTO);

	}

	/**
	 * Update employee location.
	 *
	 * @param issue_id
	 *           the issue id
	 * @param location
	 *           the location
	 * @param emp_id
	 *           the emp id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateEmployeeLocation", method =
	{ RequestMethod.POST })
	private ModelAndView updateEmployeeLocation(@RequestParam("issue_id") final int issue_id,
			@RequestParam("current_location") final String location, @RequestParam("employee_id") final int emp_id)
	{
		Runnable r = new Runnable()
		{
			public void run()
			{
				sendNotificationToCustomerForLocation(location, emp_id, issue_id);
			}

		};
		new Thread(r).start();
		return new ModelAndView("xml", "EmployeeLocation", "LocationUpdated");

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
		// customerRequestModel.set

		/*
		 * EmployeeModel serviceProviderModel = new EmployeeModel(); serviceProviderModel.setUserId(emp_id);
		 */
		customerRequestModel.setEmployeeID(emp_id);

		final ArrayList<String> customerRequestResponse = getCustomerRequestService()
				.updateCustomerRequestByEmployee(customerRequestModel);
		if (customerRequestResponse.get(1).equalsIgnoreCase("Accepted"))
		{
			Runnable r = new Runnable()
			{
				public void run()
				{
					sendNotificationToCustomer(Integer.parseInt(customerRequestResponse.get(0)), customerRequestResponse.get(1),
							emp_id, issue_id);
				}
			};
			new Thread(r).start();
		}
		return new ModelAndView("xml", "userDTO", customerRequestResponse);
	}

}
