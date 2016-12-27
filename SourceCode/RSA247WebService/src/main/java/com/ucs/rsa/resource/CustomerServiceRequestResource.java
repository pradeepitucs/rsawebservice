package com.ucs.rsa.resource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ucs.rsa.common.dto.CustomerServiceRequestDTO;
import com.ucs.rsa.common.dto.ServiceProviderDTO;
import com.ucs.rsa.common.dto.ServiceTypeDTO;
import com.ucs.rsa.common.notification.SendNotification;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerServiceRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.VehicleBodyTypeModel;
import com.ucs.rsa.model.VehicleServiceTypeModel;
import com.ucs.rsa.service.CustomerServiceRequestService;

/**
 * The Class CustomerServiceRequestResource.
 */
@Controller
@RequestMapping("/servicerequest")
public class CustomerServiceRequestResource {

	/** The customer service request service. */
	@Autowired
	private CustomerServiceRequestService customerServiceRequestService;

	/**
	 * Gets the customer service request service.
	 *
	 * @return the customer service request service
	 */
	public CustomerServiceRequestService getCustomerServiceRequestService() {
		return customerServiceRequestService;
	}

	/**
	 * Sets the customer service request service.
	 *
	 * @param customerServiceRequestService the new customer service request service
	 */
	public void setCustomerServiceRequestService(CustomerServiceRequestService customerServiceRequestService) {
		this.customerServiceRequestService = customerServiceRequestService;
	}
	
	/**
	 * Update customer service request.
	 *
	 * @param issueId the issue id
	 * @param issueTypeId the issue type id
	 * @param customerLatitude the customer latitude
	 * @param customerLongitude the customer longitude
	 * @param customerId the customer id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updatecustomerservicerequest", method = { RequestMethod.POST })
	private ModelAndView updateCustomerServiceRequest(@RequestParam("issueId") final int issueId,
			@RequestParam("issueTypeId") final int issueTypeId,
			@RequestParam("customerLatitude") final double customerLatitude,
			@RequestParam("customerLongitude") final double customerLongitude,
			@RequestParam("customerId") final int customerId) {

		CustomerServiceRequestModel customerRequestModel = new CustomerServiceRequestModel();
		customerRequestModel.setCustomerLatitude(customerLatitude);
		customerRequestModel.setCustomerLongitude(customerLongitude);
		customerRequestModel.setServiceRequestStatus("Open");
		customerRequestModel.setCustomerServiceRequestID(issueId);
	    java.sql.Date startDate = new java.sql.Date(System.currentTimeMillis());
		
		DateFormat df = new SimpleDateFormat("yyyy_mm_dd HH:mm:ss");
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		System.out.println(df.format(date));
		String timeStamp = df.format(date);
		String[] timeAndDate = timeStamp.split(" ");
		customerRequestModel.setRequestTime(Time.valueOf(timeAndDate[1]));
		customerRequestModel.setRequestDate(startDate);
		ServiceTypeModel serverType = new ServiceTypeModel();
		serverType.setServiceTypeId(issueTypeId);
		customerRequestModel.setServiceTypeModel(serverType);

		CustomerModel customerModel = new CustomerModel();
		customerModel.setUserId(customerId);
		customerRequestModel.setCustomerModel(customerModel);
		
		customerRequestModel.setEmployeeID(0);
		
		final CustomerServiceRequestModel customerRequestModel1 = getCustomerServiceRequestService()
				.updateCustomerServiceRequest(customerRequestModel);

		CustomerServiceRequestDTO customerRequestDTO = new CustomerServiceRequestDTO();
		customerRequestDTO.setCustomerLatitude(customerRequestModel1.getCustomerLatitude());
		customerRequestDTO.setCustomerLongitude(customerRequestModel1.getCustomerLongitude());
		customerRequestDTO.setCustomerServiceRequestId(customerRequestModel1.getCustomerServiceRequestID());
		customerRequestDTO.setServiceRequestedStatus(customerRequestModel1.getServiceRequestStatus());
		customerRequestDTO.setServiceTypeModel(customerRequestModel1.getServiceTypeModel());
		List<ServiceProviderDTO> serviceProviderDTOs =  new ArrayList<ServiceProviderDTO>();
		if(customerRequestModel1!= null){
			ArrayList<ServiceProviderModel> finalServiceProvidermodel =  assigningIssueAndSendNotificationstatus(customerRequestModel1);
			for (ServiceProviderModel serviceProviderModel : finalServiceProvidermodel) {
				ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO();
				serviceProviderDTO.setEnabled(serviceProviderModel.isEnabled());
				serviceProviderDTO.setMobileNo(serviceProviderModel.getServiceProviderPhoneNumber());
				serviceProviderDTO.setUserId(serviceProviderModel.getServiceProviderId());
				serviceProviderDTO.setEnabled(serviceProviderModel.isEnabled());
				serviceProviderDTO.setMobileNo(serviceProviderModel.getServiceProviderPhoneNumber());
				serviceProviderDTO.setBodyRepair(serviceProviderModel.isBodyRepair());
				serviceProviderDTO.setElectricalType(serviceProviderModel.isElectricalType());
				serviceProviderDTO.setFourWheeler(serviceProviderModel.getFourWheeler());
				serviceProviderDTO.setImageFolderName(serviceProviderModel.getImageFolderName());
				serviceProviderDTO.setMechanicalType(serviceProviderModel.isMechanicalType());
				serviceProviderDTO.setOlderServiceProviderId(serviceProviderModel.getOlderServiceProviderId());
				serviceProviderDTO.setRating(serviceProviderModel.getRating());
				serviceProviderDTO.setServiceProviderCity(serviceProviderModel.getServiceProviderCity());
				serviceProviderDTO.setServiceProviderComments(serviceProviderModel.getServiceProviderComments());
				serviceProviderDTO.setServiceProviderLatitude(serviceProviderModel.getServiceProviderLatitude());
				serviceProviderDTO.setServiceProviderLongitude(serviceProviderModel.getServiceProviderLongitude());
				serviceProviderDTO.setServiceProviderMaxDistanceToOperate(
						serviceProviderModel.getServiceProviderMaxDistanceToOperate());
				serviceProviderDTO.setServiceProviderName(serviceProviderModel.getServiceProviderName());
				serviceProviderDTO.setServiceProviderNightOperation(serviceProviderModel.isServiceProviderNightOperation());
				serviceProviderDTO.setServiceProviderPremium(serviceProviderModel.getServiceProviderPremium());
				serviceProviderDTO.setServiceProviderTimestamp(serviceProviderModel.getServiceProviderTimestamp());
				serviceProviderDTO.setServiceProvidertiming(serviceProviderModel.getServiceProvidertiming());
				serviceProviderDTO.setServiceProviderWebsite(serviceProviderModel.getServiceProviderWebsite());
				serviceProviderDTO.setTwoWheeler(serviceProviderModel.isTwoWheeler());
				ServiceTypeModel abc = new ServiceTypeModel();
				abc = serviceProviderModel.getServiceTypeModel();
				ServiceTypeDTO abc1 = new ServiceTypeDTO();
				abc1.setServiceTypeId(abc.getServiceTypeId());
				serviceProviderDTO.setServiceproviderExperties(abc1);
				serviceProviderDTOs.add(serviceProviderDTO);
			}
		}
		return new ModelAndView("xml", "customerServiceRequest", serviceProviderDTOs);

	}
	
	/**
	 * Update vehicle service type.
	 *
	 * @param issueId the issue id
	 * @param vehicleServiceTypeId the vehicle service type id
	 * @param serviceProviderId the service provider id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateVehicleServiceType", method = { RequestMethod.POST })
	private ModelAndView updateVehicleServiceType(@RequestParam("issueId") final int issueId,
			@RequestParam("vehicleServiceTypeId") final int vehicleServiceTypeId,
			@RequestParam("serviceProviderId") final int serviceProviderId){
		String status ;
		CustomerServiceRequestModel customerServiceRequestmodel = new CustomerServiceRequestModel();
		customerServiceRequestmodel.setVehicleServiceTypeID(vehicleServiceTypeId);
		customerServiceRequestmodel.setCustomerServiceRequestID(issueId);
		final CustomerServiceRequestModel customerServiceRequestmodel1 = getCustomerServiceRequestService().updateVehicleServiceType(customerServiceRequestmodel);
		if(customerServiceRequestmodel1!=null){
			status = "Request Updated";
			Runnable r = new Runnable() {
		         public void run() {
		        	sendNotificationtoServiceProvider(customerServiceRequestmodel1,serviceProviderId);
		         }
		     };
		     new Thread(r).start();
		} else {
			status = "not updated";
		}
				return new ModelAndView("xml", "updateSOSRequest",status );
		
	}
	
	/**
	 * Send notificationto service provider.
	 *
	 * @param customerServiceRequestmodel1 the customer service requestmodel1
	 * @param serviceProviderId the service provider id
	 */
	private void sendNotificationtoServiceProvider(CustomerServiceRequestModel customerServiceRequestmodel1,
			int serviceProviderId) {
		ArrayList<EmployeeModel> employeesList = getCustomerServiceRequestService().getEmployees(serviceProviderId);
		ArrayList<String> deviceIds = new ArrayList<String>();
		for(EmployeeModel employee:employeesList) {
			deviceIds.add(employee.getGcmId());
		}
		JSONArray jsonArrayObj = new JSONArray();
		JSONObject js = new JSONObject();
		try {
			js.put("issueId", customerServiceRequestmodel1.getCustomerServiceRequestID());
			js.put("issueTime", customerServiceRequestmodel1.getRequestTime());
			js.put("issueDate", customerServiceRequestmodel1.getRequestDate());
			js.put("vehicleType", getVehicleTypeWithTypeID(customerServiceRequestmodel1.getVehicleServiceTypeID()));
			js.put("customerPhoneNumber", String.valueOf(getCustomerMobileFromId(customerServiceRequestmodel1.getCustomerModel().getUserId())));
			js.put("customerLocation", customerServiceRequestmodel1.getCustomerLatitude()+","+customerServiceRequestmodel1.getCustomerLongitude());
			js.put("issueType", getServiceTypeWithTypeID(customerServiceRequestmodel1.getServiceTypeModel().getServiceTypeId()));
		} catch (JSONException e1) {
			e1.printStackTrace();
		}	
		jsonArrayObj.put(js);
		String msg = jsonArrayObj.toString();
		SendNotification sendNotification = new SendNotification();
		String notificationStatus = sendNotification.sendNotificationData(deviceIds, msg); //sent it to the notification //sendGCMNotification(arraylistOfDevices, msg);
		
	}
	
	/**
	 * Assigning issue and send notificationstatus.
	 *
	 * @param entities the entities
	 * @return the array list
	 */
	private ArrayList<ServiceProviderModel> assigningIssueAndSendNotificationstatus(final CustomerServiceRequestModel entities) {
		ArrayList<ServiceProviderModel> notificationStatus = sendNotification(entities);
		return notificationStatus;
	}
	
	/**
	 * Send notification.
	 *
	 * @param entities the entities
	 * @return the array list
	 */
	private	ArrayList<ServiceProviderModel> sendNotification(CustomerServiceRequestModel entities) {
		ArrayList<ServiceProviderModel> finalServiceProviderID = new ArrayList<ServiceProviderModel>();
				double fixedRange = 0;
				double incrementRangeForLast = 0;
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
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String notificationStatus = null;
			for (int i = 0; i < numberOfLoop; i++) {
				if(i!=0 && i<=3) {
					fixedRange = fixedRange + incrementRange;
				} if(i>3) {
					fixedRange = fixedRange + incrementRangeForLast;
				}
				ArrayList<Double> ratingArray = new ArrayList<Double>();
				ratingArray.add(highStartRating);
				ratingArray.add(highEndRating);
			
			ArrayList<ServiceProviderModel> serviceProviderID = new ArrayList<ServiceProviderModel>();
				serviceProviderID = getServiceProviderList(entities, fixedRange, ratingArray);
				if (serviceProviderID.isEmpty()) {
					ratingArray.clear();
					ratingArray.add(lowStartRating);
					ratingArray.add(lowEndRating);
					serviceProviderID = getServiceProviderList( entities, fixedRange, ratingArray);
					if (serviceProviderID.isEmpty()) {
						/*String smsForAdmin = "No Service Provider Near Issue:-" + entities.getIssueId();
						SmsLane.SMSSender("pradeepit", "pradeep143", "91" + "8892755277", smsForAdmin, "WebSMS",
								"0");*/
					} else {
						Set<ServiceProviderModel> hs = new HashSet<>();
						hs.addAll(serviceProviderID);
						serviceProviderID.clear();
						serviceProviderID.addAll(hs);
						for(int j=0;j<serviceProviderID.size() && j<5 && finalServiceProviderID.size()<6;j++){
							finalServiceProviderID.add(serviceProviderID.get(j));
						} if(finalServiceProviderID.size()==5){
							break;
						}
					// notificationStatus = sendGCMNotificationAndGetStatus(serviceProviderID,entities);
					// break;
					}
				} else {
					Set<ServiceProviderModel> hs = new HashSet<>();
					hs.addAll(serviceProviderID);
					serviceProviderID.clear();
					serviceProviderID.addAll(hs);
					for(int j=0;j<serviceProviderID.size() && j<5 && finalServiceProviderID.size()<6;j++){
						finalServiceProviderID.add(serviceProviderID.get(j));
					} if(finalServiceProviderID.size()==5){
						break;
					}
					// notificationStatus = sendGCMNotificationAndGetStatus(serviceProviderID,entities);
					 //break;
				}
			}
				return finalServiceProviderID;
			}
	
	/**
	 * Gets the service provider list.
	 *
	 * @param entities the entities
	 * @param fixedRange the fixed range
	 * @param ratingArray the rating array
	 * @return the service provider list
	 */
	private ArrayList<ServiceProviderModel> getServiceProviderList( CustomerServiceRequestModel entities,
			double fixedRange, ArrayList<Double> ratingArray) {
		ArrayList<ServiceProviderModel> serviceProviderID = new ArrayList<ServiceProviderModel>();
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
		serviceProviderID = getCustomerServiceRequestService().getServiceProviders(ratingArray, entities.getServiceTypeModel().getServiceTypeId());
		return serviceProviderID;
	}
	
	/**
	 * Gets the service type with type id.
	 *
	 * @param serviceTypeId the service type id
	 * @return the service type with type id
	 */
	private String getServiceTypeWithTypeID(int serviceTypeId) {
		ServiceTypeModel serviceTypeModel = new ServiceTypeModel();
		serviceTypeModel = getCustomerServiceRequestService().get(ServiceTypeModel.class, serviceTypeId);
		return serviceTypeModel.getServiceType();
	}
	
	/**
	 * Gets the customer mobile from id.
	 *
	 * @param customerId the customer id
	 * @return the customer mobile from id
	 */
	private long getCustomerMobileFromId(int customerId) {
		CustomerModel customerModel = new CustomerModel();
		customerModel = getCustomerServiceRequestService().get(CustomerModel.class, customerId);
		return customerModel.getMobileNo();
	}
	
	/**
	 * Gets the vehicle type with type id.
	 *
	 * @param vehicleTypeId the vehicle type id
	 * @return the vehicle type with type id
	 */
	private String getVehicleTypeWithTypeID(int vehicleTypeId) {
		VehicleServiceTypeModel vehicleServiceTypeModel = new VehicleServiceTypeModel();
		vehicleServiceTypeModel = getCustomerServiceRequestService().get(VehicleServiceTypeModel.class, vehicleTypeId);
		return vehicleServiceTypeModel.getVehicleServiceTypeName();
	}
	
}
