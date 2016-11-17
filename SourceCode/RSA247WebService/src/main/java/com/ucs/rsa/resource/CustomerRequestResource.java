/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.CustomerDTO;
import com.ucs.rsa.common.dto.CustomerRequestDTO;
import com.ucs.rsa.common.dto.CustomerRequestsDTO;
import com.ucs.rsa.common.dto.EmployeeDTO;
//import com.ucs.rsa.common.dto.EmployeeDTO;
import com.ucs.rsa.common.dto.ServiceTypeDTO;
import com.ucs.rsa.common.notification.SendNotification;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.service.CustomerRequestService;


/**
 * The Class CustomerRequestResource.
 */
@Controller
@RequestMapping("/servicerequest")
public class CustomerRequestResource
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
	 * Update customer request.
	 *
	 * @param issueId
	 *           the issue id
	 * @param issueTypeId
	 *           the issue type id
	 * @param customerLatitude
	 *           the customer latitude
	 * @param customerLongitude
	 *           the customer longitude
	 * @param customerId
	 *           the customer id
	 * @param issueStatus
	 *           the issue status
	 * @param amount
	 *           the amount
	 * @param employeeId
	 *           the employee id
	 * @param customerVehicleNumber
	 *           the customer vehicle number
	 * @return the model and view
	 */
	@RequestMapping(value = "/updatecustomerrequest", method =
	{ RequestMethod.POST })
	private ModelAndView updateCustomerRequest(@RequestParam("issueId") final int issueId,
			@RequestParam("issueTypeId") final int issueTypeId, @RequestParam("customerLatitude") final double customerLatitude,
			@RequestParam("customerLongitude") final double customerLongitude, @RequestParam("customerId") final int customerId,
			@RequestParam("issueStatus") final String issueStatus, @RequestParam("amount") final long amount,
			@RequestParam("employeeId") final int employeeId,
			@RequestParam("customerVehicleNumber") final String customerVehicleNumber)
	{

		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setCustomerLatitude(customerLatitude);
		customerRequestModel.setCustomerLongitude(customerLongitude);
		customerRequestModel.setIssueId(issueId);
		customerRequestModel.setIssueStatus("Open");
		customerRequestModel.setCustomerVehicleNumber(customerVehicleNumber);
		//customerRequestModel.setIssueStatus(issueStatus);
		java.sql.Date startDate = new java.sql.Date(System.currentTimeMillis());

		DateFormat df = new SimpleDateFormat("yyyy_mm_dd HH:mm:ss");
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		System.out.println(df.format(date));
		String timeStamp = df.format(date);//new SimpleDateFormat("yyyy_mm_dd HH:mm:ss").format(new Date());
		String[] timeAndDate = timeStamp.split(" ");
		//java.sql.Time time = new java.sql.Time(System.currentTimeMillis());
		customerRequestModel.setIssueTime(Time.valueOf(timeAndDate[1]));
		customerRequestModel.setIssueStartTime(Time.valueOf("00:00:00"));
		customerRequestModel.setIssueDate(startDate);
		ServiceTypeModel serverType = new ServiceTypeModel();
		serverType.setServiceTypeId(issueTypeId);
		customerRequestModel.setServiceTypeModel(serverType);

		CustomerModel customerModel = new CustomerModel();
		customerModel.setUserId(customerId);
		customerRequestModel.setCustomerModel(customerModel);

		/*
		 * EmployeeModel employeeModel = new EmployeeModel(); employeeModel.setUserId(employeeId);
		 */
		customerRequestModel.setEmployeeID(0);

		final CustomerRequestModel customerRequestModel1 = getCustomerRequestService().updateCustomerRequest(customerRequestModel);

		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setCustomerLatitude(customerRequestModel1.getCustomerLatitude());
		customerRequestDTO.setCustomerLongitude(customerRequestModel1.getCustomerLongitude());
		customerRequestDTO.setIssueId(customerRequestModel1.getIssueId());
		customerRequestDTO.setIssueStatus(customerRequestModel1.getIssueStatus());
		if (customerRequestModel1 != null)
		{
			Runnable r = new Runnable()
			{
				public void run()
				{
					assigningIssueAndSendNotificationstatus(customerRequestModel1);
				}
			};
			new Thread(r).start();
		}
		return new ModelAndView("xml", "customerRequest", customerRequestDTO);

	}

	/**
	 * Gets the all customer requests.
	 *
	 * @return the all customer requests
	 */
	@RequestMapping(value = "/customerrequests", method =
	{ RequestMethod.GET })
	public ModelAndView getAllCustomerRequests()
	{

		List<CustomerRequestModel> customerRequestModels = new ArrayList<>();
		customerRequestModels = getCustomerRequestService().loadAll(CustomerRequestModel.class);

		CustomerRequestsDTO customerRequestsDTO = new CustomerRequestsDTO();
		List<CustomerRequestDTO> CustomerRequestDTOs = new ArrayList<>();

		for (CustomerRequestModel customerRequestModel : customerRequestModels)
		{
			CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
			customerRequestDTO.setIssueStartTime(customerRequestModel.getIssueStartTime());
			customerRequestDTO.setCustomerVehicleNumber(customerRequestModel.getCustomerVehicleNumber());
			customerRequestDTO.setIssueDate(customerRequestModel.getIssueDate());
			customerRequestDTO.setIssueTime(customerRequestModel.getIssueTime());

			ServiceTypeModel abc = new ServiceTypeModel();
			abc = customerRequestModel.getServiceTypeModel();
			ServiceTypeDTO abc2 = new ServiceTypeDTO();
			abc2.setServiceTypeId(abc.getServiceTypeId());
			customerRequestDTO.setServiceTypeModel(abc2);

			CustomerModel customerModel = new CustomerModel();
			customerModel = customerRequestModel.getCustomerModel();
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setUserId(customerModel.getUserId());
			customerRequestDTO.setCustomerModel(customerDTO);

			CustomerRequestDTOs.add(customerRequestDTO);
		}

		customerRequestsDTO.setCustomerRequests(CustomerRequestDTOs);
		return new ModelAndView("xml", "customers", customerRequestsDTO);
	}

	/**
	 * Payment detail.
	 *
	 * @param issue_id
	 *           the issue id
	 * @return the model and view
	 */
	@RequestMapping(value = "/paymentDetail", method =
	{ RequestMethod.POST, RequestMethod.GET })
	private ModelAndView paymentDetail(@RequestParam("issue_id") final int issue_id)
	{
		List<ServiceTypeModel> serviceCompleted = getCustomerRequestService().getPaymentDetail(issue_id);
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
		return new ModelAndView("findAllCustomerRequests", "ServiceTypeDTO", ServiceTypeDTO);
	}

	/**
	 * Gets the customer request.
	 *
	 * @param iCustomerRequestId
	 *           the i customer request id
	 * @return the customer request
	 */
	@RequestMapping(value = "/customerrequest", method =
	{ RequestMethod.GET })
	public ModelAndView getCustomerRequest(@RequestParam("customerrequestid") final int iCustomerRequestId)
	{

		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel = getCustomerRequestService().get(CustomerRequestModel.class, iCustomerRequestId);

		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		if (customerRequestModel != null)
		{
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
		}
		return new ModelAndView("xml", "customerrequest", customerRequestDTO);
	}

	/**
	 * Assigning issue and send notificationstatus.
	 *
	 * @param entities
	 *           the entities
	 */
	private void assigningIssueAndSendNotificationstatus(final CustomerRequestModel entities)
	{
		String notificationStatus = sendNotification(entities);
		String newTime = "";
		if (notificationStatus.contains("Notification Successfully"))
		{
			String[] statusAndTime = notificationStatus.split(",");
			TimerTask task = new TimerTask()
			{
				@Override
				public void run()
				{
					// task to run goes here
					checkForIssueStatus(entities.getIssueId());
				}
			};

			Timer timer = new Timer();
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			Date d;
			try
			{
				d = df.parse(statusAndTime[1]);
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(d);
				cal1.add(Calendar.MINUTE, 10);
				newTime = df.format(cal1.getTime());
				System.out.println(newTime);
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			long delay = 0;
			long intevalPeriod = Long.parseLong(newTime);

			// schedules the task to be run in an interval 
			timer.scheduleAtFixedRate(task, delay, intevalPeriod);

		}
		else
		{
		}

	}

	/**
	 * Send notification.
	 *
	 * @param entities
	 *           the entities
	 * @return the string
	 */
	private String sendNotification(CustomerRequestModel entities)
	{
		double fixedRange = 0;
		double incrementRangeForLast = 0;
		double lowStartRating = 0;
		double lowEndRating = 0;
		double highStartRating = 0;
		double highEndRating = 0;
		double incrementRange = 0;
		int numberOfLoop = 0;
		Properties prop = new Properties();
		InputStream inputStream = CustomerRequestResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		try
		{
			prop.load(inputStream);
			String fixedRangeInString = prop.getProperty("FIXED_RADIUS_RANGE");
			String incrementRangeForLastInString = prop.getProperty("INCREASED_RADIUS_RANGE_FOR_LAST");
			String lowStartRatingInString = prop.getProperty("LOW_RATING_START");
			String lowEndRatingInString = prop.getProperty("LOW_RATING_END");
			String highStartRatingInString = prop.getProperty("HIGH_RATING_START");
			String highEndRatingInString = prop.getProperty("HIGH_RATING_END");
			String incrementRangeInString = prop.getProperty("INCREASED_RADIUS_RANGE");
			String numberOfLoopInString = prop.getProperty("NUMBER_OF_LOOP");
			fixedRange = Double.parseDouble(fixedRangeInString);
			incrementRangeForLast = Double.parseDouble(incrementRangeForLastInString);
			lowStartRating = Double.parseDouble(lowStartRatingInString);
			lowEndRating = Double.parseDouble(lowEndRatingInString);
			highStartRating = Double.parseDouble(highStartRatingInString);
			highEndRating = Double.parseDouble(highEndRatingInString);
			incrementRange = Double.parseDouble(incrementRangeInString);
			numberOfLoop = Integer.parseInt(numberOfLoopInString);
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		String notificationStatus = null;
		for (int i = 0; i < numberOfLoop; i++)
		{
			if (i != 0 && i <= 3)
			{
				fixedRange = fixedRange + incrementRange;
			}
			if (i > 3)
			{
				fixedRange = fixedRange + incrementRangeForLast;
			}
			ArrayList<Double> ratingArray = new ArrayList<Double>();
			ratingArray.add(highStartRating);
			ratingArray.add(highEndRating);
			ArrayList<Integer> serviceProviderID = new ArrayList<Integer>();
			serviceProviderID = getServiceProviderList(entities, fixedRange, ratingArray);
			if (serviceProviderID.isEmpty())
			{
				ratingArray.clear();
				ratingArray.add(lowStartRating);
				ratingArray.add(lowEndRating);
				serviceProviderID = getServiceProviderList(entities, fixedRange, ratingArray);
				if (serviceProviderID.isEmpty())
				{
					//String smsForAdmin = "No Service Provider Near Issue:-" + entities.getIssueId();
					//SmsLane.SMSSender("pradeepit", "pradeep143", "91" + "8892755277", smsForAdmin, "WebSMS", "0");
				}
				else
				{
					Set<Integer> hs = new HashSet<>();
					hs.addAll(serviceProviderID);
					serviceProviderID.clear();
					serviceProviderID.addAll(hs);
					notificationStatus = sendGCMNotificationAndGetStatus(serviceProviderID, entities);
					//break;
				}
			}
			else
			{
				Set<Integer> hs = new HashSet<>();
				hs.addAll(serviceProviderID);
				serviceProviderID.clear();
				serviceProviderID.addAll(hs);
				notificationStatus = sendGCMNotificationAndGetStatus(serviceProviderID, entities);
				//break;
			}
		}
		return notificationStatus;
	}

	/**
	 * Gets the service provider devices ID with service provider ID.
	 *
	 * @param listString
	 *           the list string
	 * @return the service provider devices ID with service provider ID
	 */
	private ArrayList<String> getServiceProviderDevicesIDWithServiceProviderID(ArrayList<Integer> listString)
	{

		ArrayList<String> listOfDevices = getCustomerRequestService().getDeviceIDSFromServiceProviderIDS(listString);
		return listOfDevices;
	}

	/**
	 * Check for issue status.
	 *
	 * @param issueID
	 *           the issue ID
	 * @return the string
	 */
	private String checkForIssueStatus(int issueID)
	{
		String issueStatus = getCustomerRequestService().getIssueStatus(issueID);
		return issueStatus;
	}

	/**
	 * Gets the service provider list.
	 *
	 * @param entities
	 *           the entities
	 * @param fixedRange
	 *           the fixed range
	 * @param ratingArray
	 *           the rating array
	 * @return the service provider list
	 */
	private ArrayList<Integer> getServiceProviderList(CustomerRequestModel entities, double fixedRange,
			ArrayList<Double> ratingArray)
	{
		ArrayList<Integer> serviceProviderID = new ArrayList<Integer>();
		String issueType = getServiceTypeWithTypeID(entities.getServiceTypeModel().getServiceTypeId());
		System.out.println(issueType);
		double latStarted = entities.getCustomerLatitude() - fixedRange;
		double latStoped = entities.getCustomerLatitude() + fixedRange;
		double longStarted = entities.getCustomerLongitude() - fixedRange;
		double longStoped = entities.getCustomerLongitude() + fixedRange;
		ratingArray.add(latStarted);
		ratingArray.add(latStoped);
		ratingArray.add(longStarted);
		ratingArray.add(longStoped);
		String newTimeFormatInString = new SimpleDateFormat("H:m").format(entities.getIssueTime());
		//Time newTimeFormat =  Time.valueOf(newTimeFormatInString);
		serviceProviderID = getCustomerRequestService().getServiceProviderIDS(ratingArray,
				entities.getServiceTypeModel().getServiceTypeId(), newTimeFormatInString);
		return serviceProviderID;
	}

	/**
	 * Gets the service type with type ID.
	 *
	 * @param serviceTypeId
	 *           the service type id
	 * @return the service type with type ID
	 */
	private String getServiceTypeWithTypeID(int serviceTypeId)
	{
		ServiceTypeModel serviceTypeModel = new ServiceTypeModel();
		serviceTypeModel = getCustomerRequestService().get(ServiceTypeModel.class, serviceTypeId);
		return serviceTypeModel.getServiceType();
	}

	/**
	 * Send GCM notification and get status.
	 *
	 * @param serviceProviderID
	 *           the service provider ID
	 * @param entities
	 *           the entities
	 * @return the string
	 */
	private String sendGCMNotificationAndGetStatus(ArrayList<Integer> serviceProviderID, CustomerRequestModel entities)
	{
		ArrayList<String> arraylistOfDevices = new ArrayList<String>();
		//ServiceTypeModel serviceTypeModel = new ServiceTypeModel();
		//serviceTypeModel = getCustomerRequestService().get(ServiceTypeModel.class, serviceTypeId);
		//return serviceTypeModel.getServiceType();
		UserVehicleModel userVehicle = new UserVehicleModel();
		userVehicle = getCustomerRequestService().getUserVehicle(entities.getCustomerModel().getUserId());
		CustomerModel customer = new CustomerModel();
		customer = getCustomerRequestService().get(CustomerModel.class, entities.getCustomerModel().getUserId());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(cal.getTime());
		JSONArray jsonArrayObj = new JSONArray();
		JSONObject js = new JSONObject();
		try
		{
			js.put("issueId", entities.getIssueId());
			js.put("issueTime", time);
			js.put("issueDate", entities.getIssueDate());
			js.put("customerVehicleNumber", userVehicle.getVehicleRegNo());
			js.put("customerPhoneNumber", customer.getMobileNo());
			js.put("customerLocation", entities.getCustomerLatitude() + "," + entities.getCustomerLongitude());
			js.put("issueType", getServiceTypeWithTypeID(entities.getServiceTypeModel().getServiceTypeId()));
		}
		catch (JSONException e1)
		{
			e1.printStackTrace();
		}
		jsonArrayObj.put(js);
		String msg = jsonArrayObj.toString();
		System.out.println(jsonArrayObj.toString());
		arraylistOfDevices = getServiceProviderDevicesIDWithServiceProviderID(serviceProviderID);
		SendNotification sendNotification = new SendNotification();
		String notificationStatus = sendNotification.sendNotificationData(arraylistOfDevices, msg); //sent it to the notification //sendGCMNotification(arraylistOfDevices, msg);
		return notificationStatus;
	}

	/**
	 * Find all customer requests.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/findAllCustomerRequests", method =
	{ RequestMethod.GET })
	public ModelAndView findAllCustomerRequests()
	{

		List<CustomerRequestModel> customerRequestModels = new ArrayList<>();
		customerRequestModels = getCustomerRequestService().loadAll(CustomerRequestModel.class);

		CustomerRequestsDTO customerRequestsDTO = new CustomerRequestsDTO();
		List<CustomerRequestDTO> CustomerRequestDTOs = new ArrayList<>();

		for (CustomerRequestModel customerRequestModel : customerRequestModels)
		{
			CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
			customerRequestDTO.setIssueStartTime(customerRequestModel.getIssueStartTime());
			customerRequestDTO.setCustomerVehicleNumber(customerRequestModel.getCustomerVehicleNumber());
			customerRequestDTO.setIssueDate(customerRequestModel.getIssueDate());
			customerRequestDTO.setIssueTime(customerRequestModel.getIssueTime());

			ServiceTypeModel abc = new ServiceTypeModel();
			abc = customerRequestModel.getServiceTypeModel();
			ServiceTypeDTO abc2 = new ServiceTypeDTO();
			abc2.setServiceTypeId(abc.getServiceTypeId());
			abc2.setServiceType(abc.getServiceType());
			customerRequestDTO.setServiceTypeModel(abc2);

			CustomerModel customerModel = new CustomerModel();
			customerModel = customerRequestModel.getCustomerModel();

			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setUserId(customerModel.getUserId());
			customerDTO.setFirstName(customerModel.getFirstName());
			customerRequestDTO.setCustomerModel(customerDTO);

			CustomerRequestDTOs.add(customerRequestDTO);
		}
		customerRequestsDTO.setCustomerRequests(CustomerRequestDTOs);

		Comparator<CustomerRequestModel> groupByComparator = Comparator.comparing(CustomerRequestModel::getIssueId);
		Set<String> customerIssueStatus = customerRequestModels.stream().map(CustomerRequestModel::getIssueStatus)
				.collect(Collectors.toSet());

		Set<ServiceTypeModel> serviceTypess = customerRequestModels.stream().map(CustomerRequestModel::getServiceTypeModel)
				.collect(Collectors.toSet());
		Map<String, Integer> serviceTypes = serviceTypess.stream()
				.collect(Collectors.toMap(ServiceTypeModel::getServiceType, ServiceTypeModel::getServiceTypeId));

		ModelAndView modelAndView = new ModelAndView("findAllCustomerRequests", "findAllCustomerRequests", customerRequestsDTO);

		modelAndView.addObject("customerIssueStatus", customerIssueStatus);
		modelAndView.addObject("serviceTypes", serviceTypes);

		return modelAndView;
	}

	/**
	 * Filtered customer issues.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/filteredCustomerIssues", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public ModelAndView filteredCustomerIssues(@RequestParam(value = "page", required = false) final String iPage,
			@RequestParam(value = "approve", required = false) final String iApprove,
			@RequestParam(value = "issueStatus", required = false) final String iIssueStatus,
			@RequestParam(value = "types", required = false) final String iTypes)
	{
		List<CustomerRequestModel> customerRequestModels = new ArrayList<>();

		customerRequestModels = customerRequestService.filteredCustomerIssues(iApprove, iIssueStatus, iTypes);

		CustomerRequestsDTO customerRequestsDTO = new CustomerRequestsDTO();
		List<CustomerRequestDTO> CustomerRequestDTOs = new ArrayList<>();

		for (CustomerRequestModel customerRequestModel : customerRequestModels)
		{
			CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
			customerRequestDTO.setIssueStartTime(customerRequestModel.getIssueStartTime());
			customerRequestDTO.setCustomerVehicleNumber(customerRequestModel.getCustomerVehicleNumber());
			customerRequestDTO.setIssueDate(customerRequestModel.getIssueDate());
			customerRequestDTO.setIssueTime(customerRequestModel.getIssueTime());

			ServiceTypeModel abc = new ServiceTypeModel();
			abc = customerRequestModel.getServiceTypeModel();
			ServiceTypeDTO abc2 = new ServiceTypeDTO();
			abc2.setServiceTypeId(abc.getServiceTypeId());
			abc2.setServiceType(abc.getServiceType());
			customerRequestDTO.setServiceTypeModel(abc2);

			CustomerModel customerModel = new CustomerModel();
			customerModel = customerRequestModel.getCustomerModel();

			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setUserId(customerModel.getUserId());
			customerDTO.setFirstName(customerModel.getFirstName());
			customerRequestDTO.setCustomerModel(customerDTO);

			CustomerRequestDTOs.add(customerRequestDTO);
		}
		customerRequestsDTO.setCustomerRequests(CustomerRequestDTOs);

		Comparator<CustomerRequestModel> groupByComparator = Comparator.comparing(CustomerRequestModel::getIssueId);
		Set<String> customerIssueStatus = customerRequestModels.stream().map(CustomerRequestModel::getIssueStatus)
				.collect(Collectors.toSet());

		Set<ServiceTypeModel> serviceTypess = customerRequestModels.stream().map(CustomerRequestModel::getServiceTypeModel)
				.collect(Collectors.toSet());
		Map<String, Integer> serviceTypes = serviceTypess.stream()
				.collect(Collectors.toMap(ServiceTypeModel::getServiceType, ServiceTypeModel::getServiceTypeId));

		ModelAndView modelAndView = new ModelAndView("findAllCustomerRequests", "findAllCustomerRequests", customerRequestsDTO);

		modelAndView.addObject("customerIssueStatus", customerIssueStatus);
		modelAndView.addObject("serviceTypes", serviceTypes);

		return modelAndView;
	}










	/**
	 * Gets the customer request.
	 *
	 * @param iCustomerRequestId
	 *           the i customer request id
	 * @return the customer request
	 */
	@RequestMapping(value = "/customerrequestid", method =
	{ RequestMethod.GET })
	public ModelAndView getCustomerDetailsByIssueId(@RequestParam("customerrequestid") final int iCustomerRequestId)
	{
		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel = getCustomerRequestService().get(CustomerRequestModel.class, iCustomerRequestId);
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		CustomerDTO customerDTO = new CustomerDTO();
		if (customerRequestModel != null)
		{
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
			CustomerModel customerModel = customerRequestModel.getCustomerModel();
			customerDTO.setEmailId(customerModel.getEmailId());
			customerDTO.setUserId(customerModel.getUserId());

			customerDTO.setFirstName(customerModel.getFirstName());
			customerRequestDTO.setCustomerModel(customerDTO);
			System.out.println("hhhhhhhhh-----" + customerDTO);
		}
		return new ModelAndView("xml", "customerDTO", customerDTO);
	}







	@RequestMapping(value = "/employeeInfobyissueid", method =
	{ RequestMethod.GET })
	public ModelAndView getEmployeeDetailsByIssueId(@RequestParam("employeeInfo_By_issueid") final int iCustomerRequestId)
	{
		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel = getCustomerRequestService().get(CustomerRequestModel.class, iCustomerRequestId);
		int empId = customerRequestModel.getEmployeeID();

		EmployeeModel employeeModel = new EmployeeModel();
		if(empId != 0) {
			employeeModel = getCustomerRequestService().get(EmployeeModel.class, empId);
		}
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		if(employeeModel.getUserId() != 0) {
			employeeDTO.setUserId(employeeModel.getUserId());
			employeeDTO.setEmployeeName(employeeModel.getEmployeeName());
			employeeDTO.setMobileNo(employeeModel.getMobileNo());
		}

		

		return new ModelAndView("xml", "employeeDTO", employeeDTO);
	}



















}














