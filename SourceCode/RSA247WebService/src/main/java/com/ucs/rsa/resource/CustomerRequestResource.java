package com.ucs.rsa.resource;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

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
import com.ucs.rsa.common.dto.CustomerRequestsDTO;
import com.ucs.rsa.common.notification.SendNotification;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.service.CustomerRequestService;

@Controller
@RequestMapping("/servicerequest")
public class CustomerRequestResource {

	@Autowired
	private CustomerRequestService customerRequestService;

	public CustomerRequestService getCustomerRequestService() {
		return customerRequestService;
	}

	public void setCustomerRequestService(CustomerRequestService customerRequestService) {
		this.customerRequestService = customerRequestService;
	}

	@RequestMapping(value = "/updatecustomerrequest", method = { RequestMethod.POST })
	private ModelAndView updateCustomerRequest(@RequestParam("issueId") final int issueId,
			@RequestParam("issueTypeId") final int issueTypeId,
			@RequestParam("customerLatitude") final double customerLatitude,
			@RequestParam("customerLongitude") final double customerLongitude,
			@RequestParam("customerId") final int customerId, @RequestParam("issueStatus") final String issueStatus,
			@RequestParam("amount") final long amount, @RequestParam("employeeId") final int employeeId) {

		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setCustomerLatitude(customerLatitude);
		customerRequestModel.setCustomerLongitude(customerLongitude);
		customerRequestModel.setIssueId(issueId);
		customerRequestModel.setIssueStatus(issueStatus);

		ServiceTypeModel serverType = new ServiceTypeModel();
		serverType.setServiceTypeId(issueTypeId);
		customerRequestModel.setServiceTypeModel(serverType);

		CustomerModel customerModel = new CustomerModel();
		customerModel.setUserId(customerId);
		customerRequestModel.setCustomerModel(customerModel);
		
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel.setUserId(employeeId);
		customerRequestModel.setServiceProviderModel(serviceProviderModel);
		
		CustomerRequestModel customerRequestModel1 = getCustomerRequestService()
				.updateCustomerRequest(customerRequestModel);

		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setCustomerLatitude(customerRequestModel1.getCustomerLatitude());
		customerRequestDTO.setCustomerLongitude(customerRequestModel1.getCustomerLongitude());
		customerRequestDTO.setIssueId(customerRequestModel1.getIssueId());
		customerRequestDTO.setIssueStatus(customerRequestModel1.getIssueStatus());
		if(customerRequestModel1!= null){
			 Runnable r = new Runnable() {
		         public void run() {
		        	assigningIssueAndSendNotificationstatus(customerRequestModel1);
		         }
		     };
		     new Thread(r).start();	
			}
		return new ModelAndView("xml", "customerRequest", customerRequestDTO);

	}

	@RequestMapping(value = "/customerrequests", method = { RequestMethod.GET })
	public ModelAndView getAllCustomerRequests() {

		List<CustomerRequestModel> customerRequestModels = new ArrayList<>();
		customerRequestModels = getCustomerRequestService().loadAll(CustomerRequestModel.class);

		CustomerRequestsDTO customerRequestsDTO = new CustomerRequestsDTO();
		List<CustomerRequestDTO> CustomerRequestDTOs = new ArrayList<>();

		for (CustomerRequestModel customerRequestModel : customerRequestModels) {
			CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
			CustomerRequestDTOs.add(customerRequestDTO);
		}
		customerRequestsDTO.setCustomerRequests(CustomerRequestDTOs);
		return new ModelAndView("xml", "customers", customerRequestsDTO);
	}

	@RequestMapping(value = "/customerrequest", method = { RequestMethod.GET })
	public ModelAndView getCustomerRequest(@RequestParam("customerrequestid") final int iCustomerRequestId) {

		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel = getCustomerRequestService().get(CustomerRequestModel.class, iCustomerRequestId);

		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		if (customerRequestModel != null) {
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
		}
		return new ModelAndView("xml", "customerrequest", customerRequestDTO);
	}
	
	private void assigningIssueAndSendNotificationstatus(CustomerRequestModel entities) {
		 String notificationStatus = sendNotification(entities);
		String newTime = "";
		if(notificationStatus.contains("Notification Successfully")) {
			String[] statusAndTime = notificationStatus.split(",");
			TimerTask task = new TimerTask() {
			      @Override
			      public void run() {
			        // task to run goes here
			    	  checkForIssueStatus(entities.getIssueId());
			      }
			    };
			    
			    Timer timer = new Timer();
			    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		        Date d;
				try {
					d = df.parse(statusAndTime[1]);
					Calendar cal1 = Calendar.getInstance();
			        cal1.setTime(d);
			        cal1.add(Calendar.MINUTE, 10);
			        newTime = df.format(cal1.getTime());
			        System.out.println(newTime);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
			    long delay = 0;
			    long intevalPeriod = Long.parseLong(newTime); 
			    
			    // schedules the task to be run in an interval 
			    timer.scheduleAtFixedRate(task, delay,
			                                intevalPeriod);
		
		} else {
		}
		
	}
	
	private	String sendNotification(CustomerRequestModel entities) {
				double fixedRange = 0;
				double lowStartRating = 0;
				double lowEndRating = 0;
				double highStartRating = 0 ;
				double highEndRating = 0;
				double incrementRange = 0;
				int numberOfLoop = 0;
				Properties prop = new Properties();
				InputStream inputStream = CustomerRequestResource.class.getClassLoader()
					.getResourceAsStream("/constant.properties");
				try {
				prop.load(inputStream);
				String fixedRangeInString = prop.getProperty("FIXED_RADIUS_RANGE");
				String lowStartRatingInString = prop.getProperty("LOW_RATING_START");
				String lowEndRatingInString = prop.getProperty("LOW_RATING_END");
				String highStartRatingInString = prop.getProperty("HIGH_RATING_START");
				String highEndRatingInString = prop.getProperty("HIGH_RATING_END");
				String incrementRangeInString = prop.getProperty("INCREASED_RADIUS_RANGE");
				String numberOfLoopInString = prop.getProperty("NUMBER_OF_LOOP");
				fixedRange = Double.parseDouble(fixedRangeInString);
				lowStartRating = Double.parseDouble(lowStartRatingInString);
				lowEndRating = Double.parseDouble(lowEndRatingInString);
				highStartRating = Double.parseDouble(highStartRatingInString);
				highEndRating = Double.parseDouble(highEndRatingInString);
				incrementRange = Double.parseDouble(incrementRangeInString);
				numberOfLoop = Integer.parseInt(numberOfLoopInString);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String notificationStatus = null;
			for (int i = 0; i < numberOfLoop; i++) {
				if(i!=0) {
					fixedRange = fixedRange + incrementRange;
				}
				ArrayList<Double> ratingArray = new ArrayList<Double>();
				ratingArray.add(highStartRating);
				ratingArray.add(highEndRating);
			ArrayList<Integer> serviceProviderID = new ArrayList<Integer>();
				serviceProviderID = getServiceProviderList(entities, fixedRange, ratingArray);
				if (serviceProviderID.isEmpty()) {
					ratingArray.clear();
					ratingArray.add(lowStartRating);
					ratingArray.add(lowEndRating);
					serviceProviderID = getServiceProviderList( entities, fixedRange, ratingArray);
					if (serviceProviderID.isEmpty()) {

					} else {
					 notificationStatus = sendGCMNotificationAndGetStatus(serviceProviderID,entities);
					 break;
					}
				} else {
					 notificationStatus = sendGCMNotificationAndGetStatus(serviceProviderID,entities);
					 break;
				}
			}
				return notificationStatus;
			}
		
		private ArrayList<String> getServiceProviderDevicesIDWithServiceProviderID(ArrayList<Integer> listString) {
			
			ArrayList<String> listOfDevices = getCustomerRequestService().getDeviceIDSFromServiceProviderIDS(listString);
			return listOfDevices;
		}

		private String checkForIssueStatus(int issueID) {
			String issueStatus = getCustomerRequestService().getIssueStatus(issueID);
			return issueStatus;
		}

		private ArrayList<Integer> getServiceProviderList( CustomerRequestModel entities,
				double fixedRange, ArrayList<Double> ratingArray) {
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
			serviceProviderID = getCustomerRequestService().getServiceProviderIDS(ratingArray, issueType);
			return serviceProviderID;
		}

		private String getServiceTypeWithTypeID(int serviceTypeId) {
			ServiceTypeModel serviceTypeModel = new ServiceTypeModel();
			serviceTypeModel = getCustomerRequestService().get(ServiceTypeModel.class, serviceTypeId);
			return serviceTypeModel.getServiceType();
		}
		
		private String sendGCMNotificationAndGetStatus(ArrayList<Integer> serviceProviderID, CustomerRequestModel entities) {
			ArrayList<String> arraylistOfDevices =  new ArrayList<String>();
			JSONArray jsonArrayObj = new JSONArray();
			JSONObject js = new JSONObject();
			try {
				js.put("issueId", entities.getIssueId());
				js.put("customerVehicleNumber", entities.getCustomerModel().getUserId());
				js.put("customerPhoneNumber", entities.getCustomerModel().getMobileNo());
				js.put("customerLocation", entities.getCustomerLatitude()+","+entities.getCustomerLongitude());
				js.put("issueType", entities.getServiceTypeModel().getServiceType());
			} catch (JSONException e1) {
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
}
