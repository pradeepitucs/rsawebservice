/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.CitiesDTO;
import com.ucs.rsa.common.dto.CityDTO;
import com.ucs.rsa.common.dto.CustomerDTO;
import com.ucs.rsa.common.dto.CustomersDTO;
import com.ucs.rsa.common.dto.EmployeeDTO;
import com.ucs.rsa.common.dto.EmployeesDTO;
import com.ucs.rsa.common.dto.RoleDTO;
import com.ucs.rsa.common.dto.RolesDTO;
import com.ucs.rsa.common.dto.ServiceProviderDTO;
import com.ucs.rsa.common.dto.ServiceProvidersDTO;
import com.ucs.rsa.common.dto.ServiceTypeDTO;
import com.ucs.rsa.common.dto.StringBuilderDTO;
import com.ucs.rsa.common.notification.SendNotification;
import com.ucs.rsa.common.sms.SmsLane;
import com.ucs.rsa.model.CityModel;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.RoleModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.service.BillGeneratorService;
import com.ucs.rsa.service.GmailService;
import com.ucs.rsa.service.UserService;
import org.apache.commons.codec.binary.Base64;


/**
 * The Class UserManagementResource.
 */
@Controller
@RequestMapping("/user")
public class UserManagementResource
{

	/** The bill generator. */
	@Autowired
	BillGeneratorService billGenerator;

	/** The gmail service. */
	@Autowired
	GmailService gmailService;


	/** The user service. */
	@Autowired
	UserService userService;

	/**
	 * Abc.
	 *
	 * @param aa
	 *           the aa
	 */
	public void abc(String aa)
	{
		System.out.println(aa);
	}

	/**
	 * Accept term and condition.
	 *
	 * @param imageFolderName
	 *           the image folder name
	 * @param acceptTermAndCondition
	 *           the accept term and condition
	 * @return the model and view
	 */
	@RequestMapping(value = "/acceptTermAndCondition", method = RequestMethod.POST)
	public ModelAndView acceptTermAndCondition(@RequestParam(value = "imageFolderName") final String imageFolderName,
			@RequestParam(value = "acceptTermAndCondition") final boolean acceptTermAndCondition)
	{

		String result = getUserService().acceptTermAndCondition(imageFolderName, acceptTermAndCondition);

		return new ModelAndView("xml", "result", result);
	}

	/**
	 * Adds the employees.
	 *
	 * @param employeesNumber
	 *           the employees number
	 * @param employeesName
	 *           the employees name
	 * @param serviceProviderId
	 *           the service provider id
	 * @return the model and view
	 */
	@RequestMapping(value = "/addEmployees", method = RequestMethod.POST)
	public ModelAndView addEmployees(@RequestParam(value = "employeesNumber") final String employeesNumber,
			@RequestParam(value = "employeesName") final String employeesName,
			@RequestParam(value = "serviceProviderId") final int serviceProviderId)
	{
		String[] mobiles = employeesNumber.split(",");
		String[] names = employeesName.split(",");
		String status = "";
		for (int i = 0; i < mobiles.length; i++)
		{
			EmployeeModel employee = new EmployeeModel();
			employee.setIsEnabled(false);
			employee.setMobileNo(Long.parseLong(mobiles[i]));
			if (names[i] == null)
			{
				employee.setEmployeeName(null);
			}
			else
			{
				employee.setEmployeeName(names[i]);
			}
			employee.setSendArrovalNotification(false);

			RoleModel roleModel1 = new RoleModel();
			roleModel1.setRoleId(3);

			employee.setRoleModel(roleModel1);
			employee.setUserId(0);
			employee.setOnwer(false);
			employee.setServiceProviderID(serviceProviderId);
			employee.setOlderEmployeeID(1);
			final EmployeeModel employeeModel = getUserService().insertEmployeesData(employee);
			System.out.println(employeeModel);
			if (employeeModel != null)
			{
				status = "Inserted Data";
				final String smsForEmployees = " Mr " + employeeModel.getEmployeeName()
						+ ", Your boss has registered you in the RSA 247 network. Please click the link below to complete the registration. Please use this number for registration.";
				//SmsLane.SMSSender("pradeepit", "pradeep143", "91" + employeeModel.getMobileNo(),
				//smsForEmployees, "WebSMS", "0");

				Runnable r2 = new Runnable()
				{
					@Override
					public void run()
					{

						sendSMS(smsForEmployees, employeeModel.getMobileNo());
					}
				};
				new Thread(r2).start();

			}
		}
		return new ModelAndView("xml", "employees", status);

	}

	/**
	 * Approve employee.
	 *
	 * @param employeeId
	 *           the employee id
	 * @return the model and view
	 */
	@RequestMapping(value = "/approve/employee", method = RequestMethod.POST)
	public ModelAndView approveEmployee(@RequestParam(value = "employeeId") final int employeeId)
	{

		String result = getUserService().approveEmployee(employeeId);
		if (result.equalsIgnoreCase("Approved"))
		{

			EmployeeModel employeeModel = new EmployeeModel();
			employeeModel = getUserService().get(EmployeeModel.class, employeeId);
			//String msg = "approval_status:Approved," + "employeeId:" + employeeModel.getUserId()+",serviceproviderId:"+employeeModel.getServiceProviderID()+",owner:" +employeeModel.isOnwer();
			JSONArray jsonArrayObj = new JSONArray();
			JSONObject js = new JSONObject();
			try
			{
				js.put("approval_status", "Approved");
				js.put("employeeId", employeeModel.getUserId());
				js.put("serviceproviderId", employeeModel.getServiceProviderID());
				js.put("owner", employeeModel.isOnwer());
			}
			catch (JSONException e1)
			{
				e1.printStackTrace();
			}
			jsonArrayObj.put(js);
			String msg = jsonArrayObj.toString();
			ArrayList<String> deviceID = new ArrayList<>();
			deviceID.add(employeeModel.getGcmId());
			SendNotification sendNotification = new SendNotification();
			@SuppressWarnings("unused")
			String notificationStatus = sendNotification.sendNotificationData(deviceID, msg);
			final String smsForEmployee = "Your Business has been approved. You can use the app now to access RSA 247 customers.";
			//SmsLane.SMSSender("pradeepit", "pradeep143", "91" + employeeModel.getMobileNo(), smsForEmployee, "WebSMS",
			//"0");
			final long number = employeeModel.getMobileNo();
			Runnable r2 = new Runnable()
			{
				@Override
				public void run()
				{

					sendSMS(smsForEmployee, number);
				}
			};
			new Thread(r2).start();

		}
		return new ModelAndView("xml", "result", result);
	}
	
	/**
	 * Approved service info.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/employeeapprovel", method = RequestMethod.POST)
	public @ResponseBody String approvedServiceInfo(@RequestParam(value="var1", required=true) String id ) {
		String result = getUserService().approveEmployee(Integer.parseInt(id));
		
		return result;
		}

	/**
	 * Approve service provider.
	 *
	 * @param serviceProviderId
	 *           the service provider id
	 * @return the model and view
	 */
	@RequestMapping(value = "/approve/serviceProvider", method = RequestMethod.POST)
	public ModelAndView approveServiceProvider(@RequestParam(value = "serviceProviderId") final int serviceProviderId)
	{

		String result = getUserService().approveServiceProvider(serviceProviderId);

		return new ModelAndView("xml", "result", result);
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	public @ResponseBody String approvedService(@RequestParam(value="var1", required=true) String id) {
		String result = getUserService().approveServiceProvider(Integer.parseInt(id));
		return result;
	}

	/**
	 * Employee login.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iGcmId
	 *           the i gcm id
	 * @return the model and view
	 */
	@RequestMapping(value = "/employeeLogin", method = RequestMethod.POST)
	public ModelAndView employeeLogin(@RequestParam(value = "mobileno") final long iMobileNo,
			@RequestParam(value = "gcmid") final String iGcmId)
	{

		String result = getUserService().employeeLogin(iMobileNo, iGcmId);
		if (result.contains("employeeName"))
		{
			String[] values = result.split(",");
			String[] id = values[1].split(":-");
			int serviceProviderId = Integer.parseInt(id[1]);
			ServiceProviderModel serviceprovider = new ServiceProviderModel();
			serviceprovider = getUserService().get(ServiceProviderModel.class, serviceProviderId);
			result = result + ",imageFoldername:-" + serviceprovider.getImageFolderName();
		}

		return new ModelAndView("xml", "result", result);
	}

	/**
	 * Find all employees.
	 *
	 * @param iPageNo
	 *           the i page no
	 * @return the model and view
	 */
	@RequestMapping(value = "/findAllEmployees", method =
	{ RequestMethod.GET })
	public ModelAndView findAllEmployees(@RequestParam(value = "page") final String iPageNo)
	{

		int page = 1;
		int recordsPerPage = 10;

		if (iPageNo != null && iPageNo != "")
			page = Integer.parseInt(iPageNo);

		List<EmployeeModel> employeeModels = new ArrayList<>();
		employeeModels = userService.findAllEmployees((page - 1) * recordsPerPage, recordsPerPage);

		EmployeesDTO employeesDTO = new EmployeesDTO();
		List<EmployeeDTO> employeesDTOs = new ArrayList<>();

		for (EmployeeModel employeeModel : employeeModels)
		{
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setIsEnabled(employeeModel.getIsEnabled());
			employeeDTO.setEmployeeEmail(employeeModel.getEmployeeEmail());
			employeeDTO.setEmployeeName(employeeModel.getEmployeeName());
			employeeDTO.setGcmId(employeeModel.getGcmId());
			employeeDTO.setOnwer(employeeModel.isOnwer());
			employeeDTO.setMobileNo(employeeModel.getMobileNo());
			employeeDTO.setUserId(employeeModel.getUserId());
			employeeDTO.setServiceProviderID(employeeModel.getServiceProviderID());
			employeesDTOs.add(employeeDTO);
		}
		employeesDTO.setEmployeeDTO(employeesDTOs);

		int noOfRecords = userService.findNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		ModelAndView modelAndView = new ModelAndView("findAllEmployees", "findAllEmployees", employeesDTO);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("noOfPages", noOfPages);

		return modelAndView;

	}

	/**
	 * Find all service providers.
	 *
	 * @param iPageNo
	 *           the i page no
	 * @return the model and view
	 */
	@RequestMapping(value = "/findAllServiceProviders", method =
	{ RequestMethod.GET })
	public ModelAndView findAllServiceProviders(@RequestParam(value = "page") final String iPageNo)
	{

		int page = 1;
		int recordsPerPage = 10;

		if (iPageNo != null && iPageNo != "")
			page = Integer.parseInt(iPageNo);

		List<ServiceProviderModel> serviceProviderModels = new ArrayList<>();
		serviceProviderModels = userService.findAllServiceProviders((page - 1) * recordsPerPage, recordsPerPage);

		ServiceProvidersDTO serviceProvidersDTO = new ServiceProvidersDTO();
		List<ServiceProviderDTO> serviceProviderDTOs = new ArrayList<>();

		for (ServiceProviderModel serviceProviderModel : serviceProviderModels)
		{
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
			serviceProviderDTO.setServiceProviderMaxDistanceToOperate(serviceProviderModel.getServiceProviderMaxDistanceToOperate());
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

		serviceProvidersDTO.setServiceProviderDTOs(serviceProviderDTOs);

		int noOfRecords = userService.findNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		Set<String> serviceProviderCities = new HashSet<>();
		// System Error Need to check
		//serviceProviderCities = userService.findAllCities();

		ModelAndView modelAndView = new ModelAndView("findAllServiceProviders", "findAllServiceProviders", serviceProvidersDTO);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("noOfPages", noOfPages);

		modelAndView.addObject("serviceProviderCities", serviceProviderCities);

		return modelAndView;
	}

	/**
	 * Genert bill.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/genertbill", method = RequestMethod.GET)
	public ModelAndView genertBill()
	{
		StringBuilder result = getBillGenerator().genertBill();
		StringBuilderDTO stringBuilderDTO = new StringBuilderDTO();
		stringBuilderDTO.setStrBuilder(result);
		return new ModelAndView("billGenerator", "stringBuilderDTO", stringBuilderDTO);
	}

	/**
	 * Gets the all cities.
	 *
	 * @return the all cities
	 */
	@RequestMapping(value = "/cities", method =
	{ RequestMethod.GET })
	public ModelAndView getAllCities()
	{

		List<CityModel> vehicleTypeModelList = new ArrayList<>();
		vehicleTypeModelList = getUserService().loadAll(CityModel.class);

		CitiesDTO citiesDTO = new CitiesDTO();
		List<CityDTO> cityDTOs = new ArrayList<>();

		for (CityModel cityModel : vehicleTypeModelList)
		{
			CityDTO cityDTO = new CityDTO();
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setCityCode(cityModel.getCityCode());
			cityDTO.setCityName(cityModel.getCityName());
			cityDTO.setCityId(cityModel.getCityId());
			cityDTOs.add(cityDTO);
		}
		citiesDTO.setCityDTOs(cityDTOs);
		return new ModelAndView("cities", "cities", citiesDTO);
	}

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 */
	@RequestMapping(value = "/customers", method =
	{ RequestMethod.GET })
	public ModelAndView getAllCustomers()
	{

		List<CustomerModel> customerModels = new ArrayList<>();
		customerModels = getUserService().loadAll(CustomerModel.class);

		CustomersDTO customersDTO = new CustomersDTO();
		List<CustomerDTO> customerDTOs = new ArrayList<>();

		for (CustomerModel customerModel : customerModels)
		{
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setIsEnabled(customerModel.getIsEnabled());
			customerDTO.setEmailId(customerModel.getEmailId());
			customerDTO.setFirstName(customerModel.getFirstName());
			customerDTO.setFolderName(customerModel.getFolderName());
			customerDTO.setGcmId(customerModel.getGcmId());
			customerDTO.setLastName(customerModel.getLastName());
			customerDTO.setMobileNo(customerModel.getMobileNo());
			customerDTO.setUserId(customerModel.getUserId());
			customerDTOs.add(customerDTO);
		}
		customersDTO.setCustomerDTOs(customerDTOs);
		return new ModelAndView("xml", "customers", customersDTO);
	}

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@RequestMapping(value = "/employees", method =
	{ RequestMethod.GET })
	public ModelAndView getAllEmployees()
	{

		List<EmployeeModel> employeeModels = new ArrayList<>();
		employeeModels = getUserService().loadAll(EmployeeModel.class);

		EmployeesDTO employeesDTO = new EmployeesDTO();
		List<EmployeeDTO> employeesDTOs = new ArrayList<>();

		for (EmployeeModel employeeModel : employeeModels)
		{
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setIsEnabled(employeeModel.getIsEnabled());
			employeeDTO.setEmployeeEmail(employeeModel.getEmployeeEmail());
			employeeDTO.setEmployeeName(employeeModel.getEmployeeName());
			employeeDTO.setGcmId(employeeModel.getGcmId());
			employeeDTO.setOnwer(employeeModel.isOnwer());
			employeeDTO.setMobileNo(employeeModel.getMobileNo());
			employeeDTO.setUserId(employeeModel.getUserId());
			employeeDTO.setServiceProviderID(employeeModel.getServiceProviderID());
			employeesDTOs.add(employeeDTO);
		}
		employeesDTO.setEmployeeDTO(employeesDTOs);
		return new ModelAndView("xml", "employees", employeesDTO);
	}

	/**
	 * Gets the all service providers.
	 *
	 * @return the all service providers
	 */
	@RequestMapping(value = "/serviceproviders", method =
	{ RequestMethod.GET })
	public ModelAndView getAllServiceProviders()
	{

		List<ServiceProviderModel> serviceProviderModels = new ArrayList<>();
		serviceProviderModels = getUserService().loadAll(ServiceProviderModel.class);

		ServiceProvidersDTO serviceProvidersDTO = new ServiceProvidersDTO();
		List<ServiceProviderDTO> serviceProviderDTOs = new ArrayList<>();

		for (ServiceProviderModel serviceProviderModel : serviceProviderModels)
		{
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
			serviceProviderDTO.setServiceProviderMaxDistanceToOperate(serviceProviderModel.getServiceProviderMaxDistanceToOperate());
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

		serviceProvidersDTO.setServiceProviderDTOs(serviceProviderDTOs);
		return new ModelAndView("xml", "serviceproviders", serviceProvidersDTO);
	}

	/**
	 * Gets the bill generator.
	 *
	 * @return the bill generator
	 */
	public BillGeneratorService getBillGenerator()
	{
		return billGenerator;
	}

	/**
	 * Gets the city.
	 *
	 * @param iCityId
	 *           the i city id
	 * @return the city
	 */
	@RequestMapping(value = "/city", method =
	{ RequestMethod.GET })
	public ModelAndView getCity(@RequestParam("cityid") final int iCityId)
	{

		CityModel cityModel = new CityModel();
		cityModel = getUserService().get(CityModel.class, iCityId);

		CityDTO cityDTO = new CityDTO();
		if (cityModel != null)
		{
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setCityCode(cityModel.getCityCode());
			cityDTO.setCityName(cityModel.getCityName());
			cityDTO.setCityId(cityModel.getCityId());
		}
		return new ModelAndView("xml", "city", cityDTO);
	}

	/**
	 * Gets the customer.
	 *
	 * @param iCustomerId
	 *           the i customer id
	 * @return the customer
	 */
	@RequestMapping(value = "/customer", method =
	{ RequestMethod.GET })
	public ModelAndView getCustomer(@RequestParam("customerid") final int iCustomerId)
	{

		CustomerModel customerModel = new CustomerModel();
		customerModel = getUserService().get(CustomerModel.class, iCustomerId);

		CustomerDTO customerDTO = new CustomerDTO();
		if (customerModel != null)
		{
			customerDTO.setIsEnabled(customerModel.getIsEnabled());
			customerDTO.setEmailId(customerModel.getEmailId());
			customerDTO.setFirstName(customerModel.getFirstName());
			customerDTO.setFolderName(customerModel.getFolderName());
			customerDTO.setGcmId(customerModel.getGcmId());
			customerDTO.setLastName(customerModel.getLastName());
			customerDTO.setMobileNo(customerModel.getMobileNo());
			customerDTO.setUserId(customerModel.getUserId());
		}
		return new ModelAndView("customer", "customer", customerDTO);
	}

	/**
	 * Gets the employee.
	 *
	 * @param employeeID
	 *           the employee ID
	 * @return the employee
	 */
	@RequestMapping(value = "/employee", method =
	{ RequestMethod.GET })
	public ModelAndView getEmployee(@RequestParam("employeeid") final int employeeID)
	{

		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel = getUserService().get(EmployeeModel.class, employeeID);

		EmployeeDTO employeeDTO = new EmployeeDTO();
		if (employeeModel != null)
		{
			employeeDTO.setIsEnabled(employeeModel.getIsEnabled());
			employeeDTO.setEmployeeEmail(employeeModel.getEmployeeEmail());
			employeeDTO.setEmployeeName(employeeModel.getEmployeeName());
			employeeDTO.setGcmId(employeeModel.getGcmId());
			employeeDTO.setOnwer(employeeModel.isOnwer());
			employeeDTO.setMobileNo(employeeModel.getMobileNo());
			employeeDTO.setUserId(employeeModel.getUserId());
		}
		return new ModelAndView("xml", "employee", employeeDTO);
	}

	/**
	 * Gets the employee from number.
	 *
	 * @param employeeNumber
	 *           the employee number
	 * @return the employee from number
	 */
	@RequestMapping(value = "/getEmployeeFromNumber", method = RequestMethod.POST)
	public ModelAndView getEmployeeFromNumber(@RequestParam(value = "employeeNumber") final long employeeNumber)
	{

		EmployeeModel employeeModel = getUserService().getEmployeeFromNumber(employeeNumber);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		if (employeeModel != null)
		{
			employeeDTO.setIsEnabled(employeeModel.getIsEnabled());
			employeeDTO.setEmployeeEmail(employeeModel.getEmployeeEmail());
			employeeDTO.setEmployeeName(employeeModel.getEmployeeName());
			employeeDTO.setGcmId(employeeModel.getGcmId());
			employeeDTO.setOnwer(employeeModel.isOnwer());
			employeeDTO.setMobileNo(employeeModel.getMobileNo());
			employeeDTO.setUserId(employeeModel.getUserId());
		}
		return new ModelAndView("xml", "employee", employeeDTO);
	}

	/**
	 * Gets the employee id from number.
	 *
	 * @param employeeNumber
	 *           the employee number
	 * @return the employee id from number
	 */
	@RequestMapping(value = "/getEmployeeIdFromNumber", method = RequestMethod.POST)
	public ModelAndView getEmployeeIdFromNumber(@RequestParam(value = "employeeNumber") final long employeeNumber)
	{

		EmployeeModel employeeModel = getUserService().getEmployeeFromNumber(employeeNumber);

		return new ModelAndView("xml", "employeeId", employeeModel.getUserId());
	}

	/**
	 * Gets the employee images.
	 *
	 * @param empID
	 *           the emp id
	 * @param request
	 *           the request
	 * @return the employee images
	 */
	@RequestMapping(value = "/getEmployeeImage", method = RequestMethod.POST)
	public @ResponseBody byte[][] getEmployeeImages(@RequestParam("employeeID") final int empID, HttpServletRequest request)
	{
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel = getUserService().get(EmployeeModel.class, empID);
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, employeeModel.getServiceProviderID());
		String imageFolderName = serviceProviderModel.getImageFolderName();
		String employeeName = employeeModel.getEmployeeName();
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		try
		{
			prop.load(inputStream);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[][] imagesByteArray = new byte[0][0];
		String rootPath = System.getProperty("catalina.home");
		if (imageFolderName != null)
		{
			try
			{
				int numberOfFiles = new File(rootPath + prop.getProperty("App_Name") + imageFolderName + "/" + employeeName)
						.listFiles().length;
				if (numberOfFiles != 0)
				{
					imagesByteArray = new byte[numberOfFiles][];
					// for(int i=0;i<numberOfFiles;i++) {
					try
					{
						// Retrieve image from the classpath
						String path = rootPath + prop.getProperty("App_Name") + imageFolderName + "/" + employeeName + "/"
								+ employeeName + ".jpg";
						InputStream is = new FileInputStream(path);
						// Prepare buffered image
						BufferedImage img = ImageIO.read(is);

						// Create a byte array output stream
						ByteArrayOutputStream bao = new ByteArrayOutputStream();

						// Write to output stream
						ImageIO.write(img, "jpg", bao);
						imagesByteArray[0] = bao.toByteArray();
					}
					catch (Exception e)
					{

					}
					// }
				}
				else
				{
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		return imagesByteArray;

	}
	
	@RequestMapping(value = "/employeeImages", method = RequestMethod.GET)
    public @ResponseBody  String employeeImages(Model model,
    		@RequestParam(value = "employeeID") int employeeID ) {
		String yy= "";
		String x="";
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel = getUserService().get(EmployeeModel.class, employeeID);
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, employeeModel.getServiceProviderID());
		String imageFolderName = serviceProviderModel.getImageFolderName();
		String employeeName = employeeModel.getEmployeeName();
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		try
		{
			prop.load(inputStream);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[][] imagesByteArray = new byte[0][0];
		String rootPath = System.getProperty("catalina.home");
		if ((employeeModel.getGcmId())!= null && imageFolderName != null  )
		{
			try
			{
				int numberOfFiles = new File(rootPath + prop.getProperty("App_Name") + imageFolderName + "/" + employeeName)
						.listFiles().length;
				numberOfFiles = 1;
				if (numberOfFiles != 0)
				{
					imagesByteArray = new byte[numberOfFiles][];
					for (int i = 0; i < numberOfFiles; i++)
					{
						try
						{
							//byte imageData[] = new byte[0];
							// Retrieve image from the classpath
							String path = rootPath + prop.getProperty("App_Name") + imageFolderName + "/" + employeeName + "/"
									+ employeeName + ".jpg";
							InputStream is = new FileInputStream(path);
							// Prepare buffered image
							BufferedImage img = ImageIO.read(is);

							// Create a byte array output stream
							ByteArrayOutputStream bao = new ByteArrayOutputStream();

							// Write to output stream
							ImageIO.write(img, "jpg", bao);
							imagesByteArray[i] = bao.toByteArray();
							
							byte imageData[] = new byte[1];
							is.read(imageData);
							String imag = encodeImage(imagesByteArray[0]);
							imag = imag.replaceAll("_", "/");
							imag = imag.replaceAll("-", "+");
							
							if (i == numberOfFiles - 1) {
								x = yy + imag;
								yy = x;
							} else {
								x = yy + imag + ",";
								yy = x;
							}
						}
						catch (Exception e)
						{

						}
					}
					
				}
				else
				{
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		} else {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("file/download.jpg").getFile());
			//File file = new File("/home/ucs-aditya/Downloads/download.jpg");
			 
	        try {            
	            // Reading a Image file from file system
	            FileInputStream imageInFile = new FileInputStream(file);
	            byte imageData[] = new byte[(int) file.length()];
	            imageInFile.read(imageData);
	 
	            // Converting Image byte array into Base64 String
	             yy = encodeImage(imageData);
	             yy = yy.replaceAll("_", "/");
	             yy = yy.replaceAll("-", "+");
	        } catch (Exception e){
	        	
	        }
		}
        model.addAttribute("files",yy );
        
       
        return yy;
    }

	/**
	 * Gets the gmail service.
	 *
	 * @return the gmail service
	 */
	public GmailService getGmailService()
	{
		return gmailService;
	}

	/**
	 * Gets the IDS images.
	 *
	 * @param serviceProviderID
	 *           the service provider ID
	 * @param request
	 *           the request
	 * @return the IDS images
	 */
	@RequestMapping(value = "/getIDSImages", method = RequestMethod.POST)
	public @ResponseBody byte[][] getIDSImages(@RequestParam("serviceProviderID") final int serviceProviderID,
			HttpServletRequest request)
	{
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, serviceProviderID);
		String imageFolderName = serviceProviderModel.getImageFolderName();
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		try
		{
			prop.load(inputStream);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[][] imagesByteArray = new byte[0][0];
		String rootPath = System.getProperty("catalina.home");
		if (imageFolderName != null)
		{
			try
			{
				int numberOfFiles = new File(rootPath + prop.getProperty("App_Name") + imageFolderName + "/ID").listFiles().length;
				if (numberOfFiles != 0)
				{
					imagesByteArray = new byte[numberOfFiles][];
					for (int i = 0; i < numberOfFiles; i++)
					{
						try
						{
							// Retrieve image from the classpath
							String path = rootPath + prop.getProperty("App_Name") + imageFolderName + "/ID" + "/ID" + i + ".jpg";
							InputStream is = new FileInputStream(path);
							// Prepare buffered image
							BufferedImage img = ImageIO.read(is);

							// Create a byte array output stream
							ByteArrayOutputStream bao = new ByteArrayOutputStream();

							// Write to output stream
							ImageIO.write(img, "jpg", bao);
							imagesByteArray[i] = bao.toByteArray();
						}
						catch (Exception e)
						{

						}
					}
				}
				else
				{
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		return imagesByteArray;

	}
	
	
	@RequestMapping(value = "/idImages", method = RequestMethod.GET)
    public @ResponseBody  String getIDImages(Model model,
    		@RequestParam(value = "serviceProviderID") int serviceProviderID ) {
		String yy= "";
		String x="";
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, serviceProviderID);
		String imageFolderName = serviceProviderModel.getImageFolderName();
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		try
		{
			prop.load(inputStream);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[][] imagesByteArray = new byte[0][0];
		String rootPath = System.getProperty("catalina.home");
		if (imageFolderName != null  )
		{
			try
			{
				int numberOfFiles = new File(rootPath + prop.getProperty("App_Name") + imageFolderName + "/" + "ID")
						.listFiles().length;
				if (numberOfFiles != 0)
				{
					imagesByteArray = new byte[numberOfFiles][];
					for (int i = 0; i < numberOfFiles; i++)
					{
						try
						{
							//byte imageData[] = new byte[0];
							// Retrieve image from the classpath
							String path = rootPath + prop.getProperty("App_Name") + imageFolderName + "/ID" + "/ID" + i + ".jpg";
							InputStream is = new FileInputStream(path);
							// Prepare buffered image
							BufferedImage img = ImageIO.read(is);

							// Create a byte array output stream
							ByteArrayOutputStream bao = new ByteArrayOutputStream();

							// Write to output stream
							ImageIO.write(img, "jpg", bao);
							imagesByteArray[i] = bao.toByteArray();
							
							
							String imag = encodeImage(imagesByteArray[i]);
							imag = imag.replaceAll("_", "/");
							imag = imag.replaceAll("-", "+");
							
							if (i == numberOfFiles - 1) {
								x = yy + imag;
								yy = x;
							} else {
								x = yy + imag + ",";
								yy = x;
							}
						}
						catch (Exception e)
						{

						}
					}
					
				}
				else
				{
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		} else {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("file/download.jpg").getFile());
			//File file = new File("/home/ucs-aditya/Downloads/download.jpg");
			 
	        try {            
	            // Reading a Image file from file system
	            FileInputStream imageInFile = new FileInputStream(file);
	            byte imageData[] = new byte[(int) file.length()];
	            imageInFile.read(imageData);
	 
	            // Converting Image byte array into Base64 String
	             yy = encodeImage(imageData);
	             yy = yy.replaceAll("_", "/");
	             yy = yy.replaceAll("-", "+");
	        } catch (Exception e){
	        	
	        }
		}
        model.addAttribute("files",yy );
        
       
        return yy;
    }

	/**
	 * Gets the service provider from number.
	 *
	 * @param serviceProviderNumber
	 *           the service provider number
	 * @return the service provider from number
	 */
	@RequestMapping(value = "/getServiceProviderFromNumber", method = RequestMethod.POST)
	public ModelAndView getServiceProviderFromNumber(
			@RequestParam(value = "serviceProviderNumber") final long serviceProviderNumber)
	{

		ServiceProviderModel serviceProviderModel = getUserService().getServiceProviderFromNumber(serviceProviderNumber);
		ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO();
		if (serviceProviderModel != null)
		{
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
			serviceProviderDTO.setServiceProviderMaxDistanceToOperate(serviceProviderModel.getServiceProviderMaxDistanceToOperate());
			serviceProviderDTO.setServiceProviderName(serviceProviderModel.getServiceProviderName());
			serviceProviderDTO.setServiceProviderNightOperation(serviceProviderModel.isServiceProviderNightOperation());
			serviceProviderDTO.setServiceProviderPremium(serviceProviderModel.getServiceProviderPremium());
			serviceProviderDTO.setServiceProviderTimestamp(serviceProviderModel.getServiceProviderTimestamp());
			serviceProviderDTO.setServiceProvidertiming(serviceProviderModel.getServiceProvidertiming());
			serviceProviderDTO.setServiceProviderWebsite(serviceProviderModel.getServiceProviderWebsite());
			ServiceTypeModel abc = new ServiceTypeModel();
			abc = serviceProviderModel.getServiceTypeModel();
			ServiceTypeDTO abc1 = new ServiceTypeDTO();
			abc1.setServiceTypeId(abc.getServiceTypeId());
			serviceProviderDTO.setServiceproviderExperties(abc1);
			serviceProviderDTO.setTwoWheeler(serviceProviderModel.isTwoWheeler());
		}
		return new ModelAndView("xml", "serviceProviderDTO", serviceProviderDTO);
	}

	/**
	 * Gets the service provider id from number.
	 *
	 * @param serviceProviderNumber
	 *           the service provider number
	 * @return the service provider id from number
	 */
	@RequestMapping(value = "/getServiceProviderIdFromNumber", method = RequestMethod.POST)
	public ModelAndView getServiceProviderIdFromNumber(
			@RequestParam(value = "serviceProviderNumber") final long serviceProviderNumber)
	{

		ServiceProviderModel serviceProviderModel = getUserService().getServiceProviderFromNumber(serviceProviderNumber);

		return new ModelAndView("xml", "serviceProviderId", serviceProviderModel.getServiceProviderId());
	}

	/**
	 * Gets the service provider images.
	 *
	 * @param serviceProviderID
	 *           the service provider ID
	 * @param request
	 *           the request
	 * @return the service provider images
	 */
	@RequestMapping(value = "/getServiceProviderImages", method = RequestMethod.POST)
	public @ResponseBody byte[][] getServiceProviderImages(@RequestParam("serviceProviderID") final int serviceProviderID,
			HttpServletRequest request)
	{
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, serviceProviderID);
		String imageFolderName = serviceProviderModel.getImageFolderName();
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		try
		{
			prop.load(inputStream);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[][] imagesByteArray = new byte[0][0];
		String rootPath = System.getProperty("catalina.home");
		if (imageFolderName != null)
		{
			try
			{
				int numberOfFiles = new File(rootPath + prop.getProperty("App_Name") + imageFolderName).listFiles().length;
				numberOfFiles = 1;
				if (numberOfFiles != 0)
				{
					imagesByteArray = new byte[numberOfFiles][];
					for (int i = 0; i < numberOfFiles; i++)
					{
						try
						{
							// Retrieve image from the classpath
							String path = rootPath + prop.getProperty("App_Name") + imageFolderName + "/" + imageFolderName + i + ".jpg";
							InputStream is = new FileInputStream(path);
							// Prepare buffered image
							BufferedImage img = ImageIO.read(is);

							// Create a byte array output stream
							ByteArrayOutputStream bao = new ByteArrayOutputStream();

							// Write to output stream
							ImageIO.write(img, "jpg", bao);
							imagesByteArray[i] = bao.toByteArray();
						}
						catch (Exception e)
						{

						}
					}
				}
				else
				{
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		return imagesByteArray;

	}
	
	@RequestMapping(value = "/orgImages", method = RequestMethod.GET)
    public @ResponseBody  String orgImages(Model model,
    		@RequestParam(value = "serviceProviderID") int serviceProviderID ) {
		String yy= "";
		String x="";
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, serviceProviderID);
		String imageFolderName = serviceProviderModel.getImageFolderName();
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		try
		{
			prop.load(inputStream);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[][] imagesByteArray = new byte[0][0];
		String rootPath = System.getProperty("catalina.home");
		if (imageFolderName != null)
		{
			try
			{
				int numberOfFiles = new File(rootPath + prop.getProperty("App_Name") + imageFolderName).listFiles().length;
				numberOfFiles = 1;
				if (numberOfFiles != 0)
				{
					imagesByteArray = new byte[numberOfFiles][];
					for (int i = 0; i < numberOfFiles; i++)
					{
						try
						{
							//byte imageData[] = new byte[0];
							// Retrieve image from the classpath
							String path = rootPath + prop.getProperty("App_Name") + imageFolderName + "/" + imageFolderName + i + ".jpg";
							InputStream is = new FileInputStream(path);
							// Prepare buffered image
							BufferedImage img = ImageIO.read(is);

							// Create a byte array output stream
							ByteArrayOutputStream bao = new ByteArrayOutputStream();

							// Write to output stream
							ImageIO.write(img, "jpg", bao);
							imagesByteArray[i] = bao.toByteArray();
							
							byte imageData[] = new byte[1];
							is.read(imageData);
							String imag = encodeImage(imagesByteArray[0]);
							imag = imag.replaceAll("_", "/");
							imag = imag.replaceAll("-", "+");
							
							if (i == numberOfFiles - 1) {
								x = yy + imag;
								yy = x;
							} else {
								x = yy + imag + ",";
								yy = x;
							}
						}
						catch (Exception e)
						{

						}
					}
					
				}
				else
				{
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		} else {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("file/download.jpg").getFile());
			//File file = new File("/home/ucs-aditya/Downloads/download.jpg");
			 
	        try {            
	            // Reading a Image file from file system
	            FileInputStream imageInFile = new FileInputStream(file);
	            byte imageData[] = new byte[(int) file.length()];
	            imageInFile.read(imageData);
	 
	            // Converting Image byte array into Base64 String
	             yy = encodeImage(imageData);
	             yy = yy.replaceAll("_", "/");
	             yy = yy.replaceAll("-", "+");
	        } catch (Exception e){
	        	
	        }
		}
        model.addAttribute("files",yy );
        
       
        return yy;
    }
	
	public static String encodeImage(byte[] imageByteArray) {
	    return Base64.encodeBase64URLSafeString(imageByteArray);
	}

	/**
	 * Gets the service providers.
	 *
	 * @param iServiceProvidersId
	 *           the i service providers id
	 * @return the service providers
	 */
	@RequestMapping(value = "/serviceprovider", method =
	{ RequestMethod.GET })
	public ModelAndView getServiceProviders(@RequestParam("serviceprovidersid") final int iServiceProvidersId)
	{

		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, iServiceProvidersId);

		ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO();
		if (serviceProviderModel != null)
		{
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
			serviceProviderDTO.setServiceProviderMaxDistanceToOperate(serviceProviderModel.getServiceProviderMaxDistanceToOperate());
			serviceProviderDTO.setServiceProviderName(serviceProviderModel.getServiceProviderName());
			serviceProviderDTO.setServiceProviderNightOperation(serviceProviderModel.isServiceProviderNightOperation());
			serviceProviderDTO.setServiceProviderPremium(serviceProviderModel.getServiceProviderPremium());
			serviceProviderDTO.setServiceProviderTimestamp(serviceProviderModel.getServiceProviderTimestamp());
			serviceProviderDTO.setServiceProvidertiming(serviceProviderModel.getServiceProvidertiming());
			serviceProviderDTO.setServiceProviderWebsite(serviceProviderModel.getServiceProviderWebsite());
			serviceProviderDTO.setTwoWheeler(serviceProviderModel.isTwoWheeler());
		}
		return new ModelAndView("xml", "serviceProvider", serviceProviderDTO);
	}

	/**
	 * Gets the user role.
	 *
	 * @param iRoleId
	 *           the i role id
	 * @return the user role
	 */
	@RequestMapping(value = "/role", method =
	{ RequestMethod.GET })
	public ModelAndView getUserRole(@RequestParam("roleid") final int iRoleId)
	{

		RoleModel roleModel = new RoleModel();
		roleModel = getUserService().get(RoleModel.class, iRoleId);

		RoleDTO roleDTO = new RoleDTO();
		if (roleModel != null)
		{
			roleDTO.setRoleId(roleModel.getRoleId());
			roleDTO.setRoleName(roleModel.getRoleName());
		}
		return new ModelAndView("xml", "role", roleDTO);
	}

	/**
	 * Gets the user roles.
	 *
	 * @return the user roles
	 */
	@RequestMapping(value = "/roles", method =
	{ RequestMethod.GET })
	public ModelAndView getUserRoles()
	{

		List<RoleModel> roleModelList = new ArrayList<>();
		roleModelList = getUserService().loadAll(RoleModel.class);

		RolesDTO rolesDTO = new RolesDTO();
		List<RoleDTO> roleDTOs = new ArrayList<>();

		for (RoleModel roleModel : roleModelList)
		{
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setRoleId(roleModel.getRoleId());
			roleDTO.setRoleName(roleModel.getRoleName());
			roleDTOs.add(roleDTO);
		}
		rolesDTO.setRoleDTOs(roleDTOs);
		return new ModelAndView("xml", "roles", rolesDTO);
	}

	/**
	 * Gets the user service.
	 *
	 * @return the user service
	 */
	public UserService getUserService()
	{
		return userService;
	}

	/**
	 * Login.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iGcmId
	 *           the i gcm id
	 * @return the model and view
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "mobileno") final long iMobileNo,
			@RequestParam(value = "gcmid") final String iGcmId)
	{

		String result = getUserService().login(iMobileNo, iGcmId);
		if (result.contains("userId"))
		{
			String[] data = result.split(",");
			String[] userId = data[1].split(":");
			UserVehicleModel userVehicle = getUserService().getUservehicleDetail(Integer.parseInt(userId[1]));
			if (userVehicle != null)
			{
				CustomerModel customer = new CustomerModel();
				customer = getUserService().get(CustomerModel.class, Integer.parseInt(userId[1]));
				result = result + ",UserVehicleNumber:" + userVehicle.getVehicleRegNo();
				result = result + ",IsPremium:" + customer.isMember();
			}
		}
		return new ModelAndView("xml", "result", result);
	}

	/**
	 * Search employees by mobile no.
	 *
	 * @param iPageNo
	 *           the i page no
	 * @param iMobileNo
	 *           the i mobile no
	 * @return the model and view
	 */
	@RequestMapping(value = "/searchEmployeesByMobileNo", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public ModelAndView searchEmployeesByMobileNo(@RequestParam(value = "page") final String iPageNo,
			@RequestParam(value = "mobileNo") final String iMobileNo)
	{

		int page = 1;
		int recordsPerPage = 10;

		List<EmployeeModel> employeeModels = new ArrayList<>();
		employeeModels = userService.searchEmployeesByMobileNo(iMobileNo);

		EmployeesDTO employeesDTO = new EmployeesDTO();
		List<EmployeeDTO> employeesDTOs = new ArrayList<>();

		for (EmployeeModel employeeModel : employeeModels)
		{
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setIsEnabled(employeeModel.getIsEnabled());
			employeeDTO.setEmployeeEmail(employeeModel.getEmployeeEmail());
			employeeDTO.setEmployeeName(employeeModel.getEmployeeName());
			employeeDTO.setGcmId(employeeModel.getGcmId());
			employeeDTO.setOnwer(employeeModel.isOnwer());
			employeeDTO.setMobileNo(employeeModel.getMobileNo());
			employeeDTO.setUserId(employeeModel.getUserId());
			employeeDTO.setServiceProviderID(employeeModel.getServiceProviderID());
			employeesDTOs.add(employeeDTO);
		}
		employeesDTO.setEmployeeDTO(employeesDTOs);

		int noOfRecords = employeeModels.size();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		ModelAndView modelAndView = new ModelAndView("findAllEmployees", "findAllEmployees", employeesDTO);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("noOfPages", noOfPages);

		return modelAndView;
	}

	/**
	 * Send mail.
	 *
	 * @param msg
	 *           the msg
	 * @param employeeEmail
	 *           the employee email
	 */
	private void sendMail(String msg, String employeeEmail)
	{
		// TODO Auto-generated method stub
		getGmailService().readyToSendEmail("aditya.s@ucs.consulting", employeeEmail, "Successful Service Provider Registration",
				msg);
	}

	/**
	 * Send mail to employee.
	 *
	 * @param msg
	 *           the msg
	 * @param employeeEmail
	 *           the employee email
	 */
	@SuppressWarnings("unused")
	private void sendMailToEmployee(String msg, String employeeEmail)
	{
		// TODO Auto-generated method stub
		getGmailService().readyToSendEmail("aditya.s@ucs.consulting", employeeEmail, "Your RSA247 Registration is pending", msg);
	}

	/**
	 * Send SMS.
	 *
	 * @param smsForEmployee
	 *           the sms for employee
	 * @param mobileNo
	 *           the mobile no
	 */
	private void sendSMS(String smsForEmployee, long mobileNo)
	{
		SmsLane.SMSSender("pradeepit", "pradeep143", "91" + mobileNo, smsForEmployee, "WebSMS", "0");
	}

	/**
	 * Sets the bill generator.
	 *
	 * @param billGenerator
	 *           the new bill generator
	 */
	public void setBillGenerator(BillGeneratorService billGenerator)
	{
		this.billGenerator = billGenerator;
	}

	/**
	 * Sets the gmail service.
	 *
	 * @param gmailService
	 *           the new gmail service
	 */
	public void setGmailService(GmailService gmailService)
	{




		this.gmailService = gmailService;
	}

	/**
	 * Sets the user service.
	 *
	 * @param userService
	 *           the new user service
	 */
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	/**
	 * Update customer.
	 *
	 * @param iUserId
	 *           the i user id
	 * @param iUserFirstName
	 *           the i user first name
	 * @param iUserLastName
	 *           the i user last name
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iEmailId
	 *           the i email id
	 * @param iCity
	 *           the i city
	 * @param iRoleId
	 *           the i role id
	 * @param isEnabled
	 *           the is enabled
	 * @param iGcmId
	 *           the i gcm id
	 * @param iFolderName
	 *           the i folder name
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateCustomer", method =
	{ RequestMethod.POST, RequestMethod.GET })
	private ModelAndView updateCustomer(@RequestParam(value = "userid") final int iUserId,
			@RequestParam(value = "userfirstname") final String iUserFirstName,
			@RequestParam(value = "userlastname") final String iUserLastName,
			@RequestParam(value = "mobileno", required = true) final long iMobileNo,
			@RequestParam(value = "emailid", required = true) final String iEmailId, @RequestParam(value = "city") final int iCity,
			@RequestParam(value = "roleid", required = true) final int iRoleId,
			@RequestParam(value = "enabled") final boolean isEnabled,
			@RequestParam(value = "gcmid", required = true) final String iGcmId,
			@RequestParam(value = "foldername") final String iFolderName)
	{

		CustomerModel customerModel = new CustomerModel();
		customerModel.setIsEnabled(isEnabled);
		customerModel.setMobileNo(iMobileNo);
		customerModel.setGcmId(iGcmId);
		customerModel.setEmailId(iEmailId);

		CityModel cityModel = new CityModel();
		cityModel.setCityId(iCity);

		customerModel.setCityModel(cityModel);
		customerModel.setFirstName(iUserFirstName);
		customerModel.setLastName(iUserLastName);

		RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(iRoleId);

		customerModel.setRoleModel(roleModel);
		customerModel.setUserId(iUserId);
		customerModel.setMember(false);
		customerModel.setFolderName(iFolderName);

		CustomerModel customerModel1 = getUserService().updateCustomer(customerModel);

		CustomerDTO customerDTO = new CustomerDTO();
		if (customerModel1 != null)
		{
			customerDTO.setEmailId(customerModel1.getEmailId());
			customerDTO.setUserId(customerModel1.getUserId());
			customerDTO.setFolderName(customerModel1.getFolderName());
			customerDTO.setFirstName(customerModel1.getFirstName());
			customerDTO.setLastName(customerModel1.getLastName());
			customerDTO.setGcmId(customerModel1.getGcmId());
			customerDTO.setIsEnabled(customerDTO.getIsEnabled());
		}

		return new ModelAndView("xml", "customer", customerDTO);
	}

	/**
	 * Update employee.
	 *
	 * @param iUserId
	 *           the i user id
	 * @param employeeName
	 *           the employee name
	 * @param employeeEmail
	 *           the employee email
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iRoleId
	 *           the i role id
	 * @param isEnabled
	 *           the is enabled
	 * @param isOnwer
	 *           the is onwer
	 * @param isSendApprovalNotification
	 *           the is send approval notification
	 * @param iGcmId
	 *           the i gcm id
	 * @param olderEmployeeId
	 *           the older employee id
	 * @param serviceProviderId
	 *           the service provider id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateEmployee", method =
	{ RequestMethod.POST, RequestMethod.GET })
	private ModelAndView updateEmployee(@RequestParam(value = "userid") final int iUserId,
			@RequestParam(value = "employeeName") final String employeeName,
			@RequestParam(value = "employeeEmail") final String employeeEmail,
			@RequestParam(value = "mobileno", required = true) final long iMobileNo,
			@RequestParam(value = "roleid", required = true) final int iRoleId,
			@RequestParam(value = "enabled") final boolean isEnabled, @RequestParam(value = "isOnwer") final boolean isOnwer,
			@RequestParam(value = "isSendApprovalNotification") final boolean isSendApprovalNotification,
			@RequestParam(value = "gcmid", required = true) final String iGcmId,
			@RequestParam(value = "olderEmployeeId") final int olderEmployeeId,
			@RequestParam(value = "serviceProviderId") final int serviceProviderId)
	{

		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setIsEnabled(isEnabled);
		employeeModel.setMobileNo(iMobileNo);
		employeeModel.setGcmId(iGcmId);
		employeeModel.setEmployeeEmail(employeeEmail);
		employeeModel.setEmployeeName(employeeName);
		employeeModel.setSendArrovalNotification(isSendApprovalNotification);

		RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(iRoleId);

		employeeModel.setRoleModel(roleModel);
		employeeModel.setUserId(iUserId);
		employeeModel.setOnwer(isOnwer);
		employeeModel.setServiceProviderID(serviceProviderId);
		employeeModel.setOlderEmployeeID(olderEmployeeId);

		final EmployeeModel customerModel1 = getUserService().updateEmployee(employeeModel);
		if (customerModel1 != null)
		{
			final String smsForEmployee = " Mr " + customerModel1.getEmployeeName()
					+ ", You has successfully registered in the RSA 247 network.";
			//SmsLane.SMSSender("pradeepit", "pradeep143", "91" + customerModel1.getMobileNo(), smsForEmployee, "WebSMS",
			//"0");
			Runnable r2 = new Runnable()
			{
				@Override
				public void run()
				{

					sendSMS(smsForEmployee, customerModel1.getMobileNo());

				}
			};
			new Thread(r2).start();
			final String msg = ",\n\n" + "\t Welcome to RSA247 Provider Network"
					+ "\n  Congratulations, you are a member of the provider network in RSA247. We will review your details and documents and approve your registration."
					+ " Please wait for the mobile app notification to start using the app." + "\n\n" + "\n\n" + "Thank you" + "\n\n"
					+ "RSA247";
			Runnable r1 = new Runnable()
			{
				@Override
				public void run()
				{

					sendMail(msg, customerModel1.getEmployeeEmail());
				}
			};
			new Thread(r1).start();
			//getGmailService().readyToSendEmail("aditya.s@ucs.consulting", customerModel1.getEmployeeEmail(),
			//"Successful Service Provider Registration", msg);

		}

		return new ModelAndView("xml", "employee", "Inserted Data");
	}

	/**
	 * Update member ship.
	 *
	 * @param userId
	 *           the user id
	 * @param isMembership
	 *           the is membership
	 * @return the model and view
	 */
	@RequestMapping(value = "/membership", method =
	{ RequestMethod.POST })
	public ModelAndView updateMemberShip(@RequestParam("userId") final int userId,
			@RequestParam("isMembership") final boolean isMembership)
	{
		String status = "";
		CustomerModel customer = getUserService().updateMemberShip(userId, isMembership);
		if (customer != null)
		{
			status = "Membership Updated";
		}
		return new ModelAndView("xml", "membership", status);
	}

	/**
	 * Update service provider.
	 *
	 * @param bodyRepair
	 *           the body repair
	 * @param electricalType
	 *           the electrical type
	 * @param enabled
	 *           the enabled
	 * @param imageFolderName
	 *           the image folder name
	 * @param mechanicalType
	 *           the mechanical type
	 * @param mobileNo
	 *           the mobile no
	 * @param rating
	 *           the rating
	 * @param serviceProviderCity
	 *           the service provider city
	 * @param serviceProviderComments
	 *           the service provider comments
	 * @param serviceproviderExperties
	 *           the serviceprovider experties
	 * @param serviceProviderId
	 *           the service provider id
	 * @param serviceProviderLatitude
	 *           the service provider latitude
	 * @param serviceProviderLongitude
	 *           the service provider longitude
	 * @param serviceProviderMaxDistanceToOperate
	 *           the service provider max distance to operate
	 * @param serviceProviderName
	 *           the service provider name
	 * @param serviceProviderNightOperation
	 *           the service provider night operation
	 * @param serviceProviderotherServices
	 *           the service providerother services
	 * @param serviceProviderPremium
	 *           the service provider premium
	 * @param serviceProvidertiming
	 *           the service providertiming
	 * @param serviceProviderWebsite
	 *           the service provider website
	 * @param twoWheeler
	 *           the two wheeler
	 * @param fourWheeler
	 *           the four wheeler
	 * @param serviceProviderTimeStamp
	 *           the service provider time stamp
	 * @param olderServiceProviderId
	 *           the older service provider id
	 * @return the model and view
	 */
	@RequestMapping(value = "/update", method =
	{ RequestMethod.POST })
	private ModelAndView updateServiceProvider(@RequestParam("bodyRepair") final boolean bodyRepair,
			@RequestParam("electricalType") final boolean electricalType, @RequestParam("enabled") final boolean enabled,
			@RequestParam("imageFolderName") final String imageFolderName,
			@RequestParam("mechanicalType") final boolean mechanicalType, @RequestParam("mobileNo") final long mobileNo,
			@RequestParam("rating") final double rating, @RequestParam("serviceProviderCity") final String serviceProviderCity,
			@RequestParam("serviceProviderComments") final String serviceProviderComments,
			@RequestParam("serviceproviderExperties") final int serviceproviderExperties,
			@RequestParam("serviceProviderId") final int serviceProviderId,
			@RequestParam("serviceProviderLatitude") final double serviceProviderLatitude,
			@RequestParam("serviceProviderLongitude") final double serviceProviderLongitude,
			@RequestParam("serviceProviderMaxDistanceToOperate") final int serviceProviderMaxDistanceToOperate,
			@RequestParam("serviceProviderName") final String serviceProviderName,
			@RequestParam("serviceProviderNightOperation") final boolean serviceProviderNightOperation,
			@RequestParam("serviceProviderotherServices") final String serviceProviderotherServices,
			@RequestParam("serviceProviderPremium") final String serviceProviderPremium,
			@RequestParam("serviceProvidertiming") final String serviceProvidertiming,
			@RequestParam("serviceProviderWebsite") final String serviceProviderWebsite,
			@RequestParam("twoWheeler") final Boolean twoWheeler, @RequestParam("fourWheeler") final Boolean fourWheeler,
			@RequestParam("serviceProviderTimeStamp") final Timestamp serviceProviderTimeStamp,
			@RequestParam("olderServiceProviderId") final Integer olderServiceProviderId)
	{
		ServiceProviderModel serviceProvider = new ServiceProviderModel();
		serviceProvider.setBodyRepair(bodyRepair);
		serviceProvider.setElectricalType(electricalType);
		serviceProvider.setImageFolderName(imageFolderName);
		serviceProvider.setMechanicalType(mechanicalType);
		serviceProvider.setServiceProviderPhoneNumber(mobileNo);
		serviceProvider.setRating(rating);
		serviceProvider.setServiceProviderCity(serviceProviderCity);
		serviceProvider.setServiceProviderComments(serviceProviderComments);
		ServiceTypeModel serviceTypeModel = new ServiceTypeModel();
		serviceTypeModel.setServiceTypeId(serviceproviderExperties);
		serviceProvider.setServiceTypeModel(serviceTypeModel);
		serviceProvider.setServiceProviderId(serviceProviderId);
		serviceProvider.setServiceProviderLatitude(serviceProviderLatitude);
		serviceProvider.setServiceProviderLongitude(serviceProviderLongitude);
		serviceProvider.setServiceProviderMaxDistanceToOperate(serviceProviderMaxDistanceToOperate);
		serviceProvider.setServiceProviderName(serviceProviderName);
		serviceProvider.setServiceProviderNightOperation(serviceProviderNightOperation);
		serviceProvider.setServiceProviderPremium(serviceProviderPremium);
		serviceProvider.setServiceProvidertiming(serviceProvidertiming);
		serviceProvider.setServiceProviderWebsite(serviceProviderWebsite);
		serviceProvider.setFourWheeler(fourWheeler);
		serviceProvider.setTwoWheeler(twoWheeler);
		serviceProvider.setAcceptTermCondition(false);
		serviceProvider.setEnabled(enabled);
		serviceProvider.setOlderServiceProviderId(olderServiceProviderId);
		serviceProvider.setServiceProviderTimestamp(serviceProviderTimeStamp);
		System.out.println("ServiceProviderDTO " + serviceProvider);
		String status = "";
		ServiceProviderModel userModel = userService.updateServiceProvider(serviceProvider);
		if (userModel != null)
		{
			ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
			serviceProviderModel.setServiceProviderId(userModel.getServiceProviderId());
			String[] serviceTypesID = serviceProviderotherServices.split(",");
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList = new ArrayList<ServiceProviderServiceMatchingModel>();
			for (int i = 0; i < serviceTypesID.length; i++)
			{
				ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel = new ServiceProviderServiceMatchingModel();
				ServiceTypeModel servicetypeModel = new ServiceTypeModel();
				servicetypeModel.setServiceTypeId(Integer.parseInt(serviceTypesID[i]));
				serviceProviderServiceMatchingModel.setServiceProviderModel(serviceProviderModel);
				serviceProviderServiceMatchingModel.setServiceTypeModel(servicetypeModel);
				serviceProviderServiceMatchingModelList.add(serviceProviderServiceMatchingModel);
			}
			ServiceProviderServiceMatchingModel serviceProviderMatch = getUserService()
					.getServiceProvidermatchingModel(serviceProviderServiceMatchingModelList);
			if (serviceProviderMatch != null)
			{
				status = "Inserted Data";
			}
		}
		System.out.println("UserDTO " + userModel);
		return new ModelAndView("xml", "serviceprovider", status);

	}

	/**
	 * Update service provider and employee.
	 *
	 * @param bodyRepair
	 *           the body repair
	 * @param electricalType
	 *           the electrical type
	 * @param imageFolderName
	 *           the image folder name
	 * @param mechanicalType
	 *           the mechanical type
	 * @param mobileNo
	 *           the mobile no
	 * @param serviceProviderCity
	 *           the service provider city
	 * @param serviceProviderComments
	 *           the service provider comments
	 * @param serviceproviderExperties
	 *           the serviceprovider experties
	 * @param serviceProviderId
	 *           the service provider id
	 * @param serviceProviderLatitude
	 *           the service provider latitude
	 * @param serviceProviderLongitude
	 *           the service provider longitude
	 * @param serviceProviderMaxDistanceToOperate
	 *           the service provider max distance to operate
	 * @param serviceProviderName
	 *           the service provider name
	 * @param serviceProviderNightOperation
	 *           the service provider night operation
	 * @param serviceProviderotherServices
	 *           the service providerother services
	 * @param serviceProviderPremium
	 *           the service provider premium
	 * @param serviceProvidertiming
	 *           the service providertiming
	 * @param serviceProviderWebsite
	 *           the service provider website
	 * @param twoWheeler
	 *           the two wheeler
	 * @param fourWheeler
	 *           the four wheeler
	 * @param serviceProviderTimeStamp
	 *           the service provider time stamp
	 * @param contactPersonName
	 *           the contact person name
	 * @param contactPersonEmail
	 *           the contact person email
	 * @param contactPersonPhoneNumber
	 *           the contact person phone number
	 * @param employeeName
	 *           the employee name
	 * @param employeeMobileNumber
	 *           the employee mobile number
	 * @param gcmID
	 *           the gcm ID
	 * @param userId
	 *           the user id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateServiceProviderAndEmployee", method =
	{ RequestMethod.POST })
	private ModelAndView updateServiceProviderAndEmployee(@RequestParam("bodyRepair") final boolean bodyRepair,
			@RequestParam("electricalType") final boolean electricalType,
			@RequestParam("imageFolderName") final String imageFolderName,
			@RequestParam("mechanicalType") final boolean mechanicalType, @RequestParam("mobileNo") final long mobileNo,
			@RequestParam("serviceProviderCity") final String serviceProviderCity,
			@RequestParam("serviceProviderComments") final String serviceProviderComments,
			@RequestParam("serviceproviderExperties") final int serviceproviderExperties,
			@RequestParam("serviceProviderId") final int serviceProviderId,
			@RequestParam("serviceProviderLatitude") final double serviceProviderLatitude,
			@RequestParam("serviceProviderLongitude") final double serviceProviderLongitude,
			@RequestParam("serviceProviderMaxDistanceToOperate") final int serviceProviderMaxDistanceToOperate,
			@RequestParam("serviceProviderName") final String serviceProviderName,
			@RequestParam("serviceProviderNightOperation") final boolean serviceProviderNightOperation,
			@RequestParam("serviceProviderotherServices") final String serviceProviderotherServices,
			@RequestParam("serviceProviderPremium") final String serviceProviderPremium,
			@RequestParam("serviceProvidertiming") final String serviceProvidertiming,
			@RequestParam("serviceProviderWebsite") final String serviceProviderWebsite,
			@RequestParam("twoWheeler") final Boolean twoWheeler, @RequestParam("fourWheeler") final Boolean fourWheeler,
			@RequestParam("serviceProviderTimeStamp") final Timestamp serviceProviderTimeStamp,
			@RequestParam("contactPersonName") final String contactPersonName,
			@RequestParam("contactPersonEmail") final String contactPersonEmail,
			@RequestParam("contactPersonPhoneNumber") final Long contactPersonPhoneNumber,
			@RequestParam("employeeName") final String employeeName,
			@RequestParam("employeeMobileNumber") final String employeeMobileNumber, @RequestParam("gcmID") final String gcmID,
			@RequestParam("userId") final int userId)
	{
		String status = "";
		ServiceProviderModel serviceProvider = new ServiceProviderModel();
		serviceProvider.setBodyRepair(bodyRepair);
		serviceProvider.setElectricalType(electricalType);
		serviceProvider.setImageFolderName(imageFolderName);
		serviceProvider.setMechanicalType(mechanicalType);
		serviceProvider.setServiceProviderPhoneNumber(mobileNo);
		serviceProvider.setRating(0.0);
		serviceProvider.setServiceProviderCity(serviceProviderCity);
		serviceProvider.setServiceProviderComments(serviceProviderComments);
		ServiceTypeModel serviceTypeModel = new ServiceTypeModel();
		serviceTypeModel.setServiceTypeId(serviceproviderExperties);
		serviceProvider.setServiceTypeModel(serviceTypeModel);
		serviceProvider.setServiceProviderId(serviceProviderId);
		serviceProvider.setServiceProviderLatitude(serviceProviderLatitude);
		serviceProvider.setServiceProviderLongitude(serviceProviderLongitude);
		serviceProvider.setServiceProviderMaxDistanceToOperate(serviceProviderMaxDistanceToOperate);
		serviceProvider.setServiceProviderName(serviceProviderName);
		serviceProvider.setServiceProviderNightOperation(serviceProviderNightOperation);
		serviceProvider.setServiceProviderPremium(serviceProviderPremium);
		serviceProvider.setServiceProvidertiming(serviceProvidertiming);
		serviceProvider.setServiceProviderWebsite(serviceProviderWebsite);
		serviceProvider.setFourWheeler(fourWheeler);
		serviceProvider.setAcceptTermCondition(false);
		serviceProvider.setTwoWheeler(twoWheeler);
		serviceProvider.setEnabled(false);
		serviceProvider.setOlderServiceProviderId(1);
		serviceProvider.setServiceProviderTimestamp(serviceProviderTimeStamp);
		System.out.println("ServiceProviderDTO " + serviceProvider);

		ServiceProviderModel userModel = userService.updateServiceProvider(serviceProvider);
		if (userModel != null)
		{
			ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
			serviceProviderModel.setServiceProviderId(userModel.getServiceProviderId());
			String[] serviceTypesID = serviceProviderotherServices.split(",");
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList = new ArrayList<ServiceProviderServiceMatchingModel>();
			for (int i = 0; i < serviceTypesID.length; i++)
			{
				ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel = new ServiceProviderServiceMatchingModel();
				ServiceTypeModel servicetypeModel = new ServiceTypeModel();
				servicetypeModel.setServiceTypeId(Integer.parseInt(serviceTypesID[i]));
				serviceProviderServiceMatchingModel.setServiceProviderModel(serviceProviderModel);
				serviceProviderServiceMatchingModel.setServiceTypeModel(servicetypeModel);
				serviceProviderServiceMatchingModelList.add(serviceProviderServiceMatchingModel);
			}
			@SuppressWarnings("unused")
			ServiceProviderServiceMatchingModel serviceProviderMatch = getUserService()
					.getServiceProvidermatchingModel(serviceProviderServiceMatchingModelList);
			ArrayList<EmployeeModel> employeeModels = new ArrayList<>();
			EmployeeModel customerModel = new EmployeeModel();
			customerModel.setIsEnabled(false);
			customerModel.setMobileNo(contactPersonPhoneNumber);
			customerModel.setGcmId(gcmID);
			customerModel.setEmployeeEmail(contactPersonEmail);
			customerModel.setEmployeeName(contactPersonName);
			customerModel.setSendArrovalNotification(false);

			RoleModel roleModel = new RoleModel();
			roleModel.setRoleId(3);

			customerModel.setRoleModel(roleModel);
			customerModel.setUserId(userId);
			customerModel.setOnwer(true);
			customerModel.setServiceProviderID(userModel.getServiceProviderId());
			customerModel.setOlderEmployeeID(1);
			employeeModels.add(customerModel);
			final EmployeeModel employeeModel1 = getUserService().insertEmployeesData(customerModel);
			if ( employeeModel1 != null)
			{
				final String smsForEmployee = " Mr " + employeeModel1.getEmployeeName()
						+ ", You has successfully registered in the RSA 247 network.";
				Runnable r = new Runnable()
				{
					@Override
					public void run()
					{
						sendSMS(smsForEmployee, employeeModel1.getMobileNo());
					}
				};
				new Thread(r).start();

				final String msg = ",\n\n" + "\t Welcome to RSA247 Provider Network"
						+ "\n  Congratulations, you are a member of the provider network in RSA247. We will review your details and documents and approve your registration."
						+ " Please wait for the mobile app notification to start using the app." + "\n\n" + "\n\n" + "Thank you"
						+ "\n\n" + "RSA247";
				Runnable r1 = new Runnable()
				{
					@Override
					public void run()
					{
						sendMail(msg, employeeModel1.getEmployeeEmail());
					}
				};
				new Thread(r1).start();
				if(!employeeMobileNumber.isEmpty() && !employeeName.isEmpty() ) {
				String[] mobiles = employeeMobileNumber.split(",");
				String[] names = employeeName.split(",");
				for (int i = 0; i < mobiles.length; i++)
				{
					EmployeeModel employee = new EmployeeModel();
					employee.setIsEnabled(false);
					employee.setMobileNo(Long.parseLong(mobiles[i]));
					if (names[i] == null)
					{
						employee.setEmployeeName(null);
					}
					else
					{
						employee.setEmployeeName(names[i]);
					}
					employee.setSendArrovalNotification(false);

					RoleModel roleModel1 = new RoleModel();
					roleModel1.setRoleId(3);

					employee.setRoleModel(roleModel1);
					employee.setUserId(userId);
					employee.setOnwer(false);
					employee.setServiceProviderID(userModel.getServiceProviderId());
					employee.setOlderEmployeeID(1);
					employeeModels.add(employee);
					final EmployeeModel employeeModel = getUserService().insertEmployeesData(employee);
					System.out.println(employeeModel);
					if (employeeModel != null)
					{
						status = "Inserted Data";
						final String smsForEmployees = " Mr " + employeeModel.getEmployeeName()
								+ ", Download the RSA247 mobile app from the below link. goo.gl/Axyn3?1";
						//SmsLane.SMSSender("pradeepit", "pradeep143", "91" + employeeModel.getMobileNo(),
						//	smsForEmployees, "WebSMS", "0");
						Runnable r2 = new Runnable()
						{
							@Override
							public void run()
							{
								sendSMS(smsForEmployees, employeeModel.getMobileNo());
							}
						};
						new Thread(r2).start();
						/*
						 * final String msg1 = ",\n\n" +
						 * "\t Please complete the registration by downloading the RSA247 app from the link below. Use the phone number below to register. goo.gl/Axyn3?1"
						 * + "\n"+ "\t MobileNumber = "+employeeModel.getMobileNo(); Runnable r3 = new Runnable() { public
						 * void run() { sendMailToEmployee(msg1, employeeModel.getEmployeeEmail()); } }; new
						 * Thread(r3).start();
						 */
					}
				}
				}
			}
			else
			{
				status = "Inserted Data";
			}

		}
		else
		{
			status = "error";
		}
		System.out.println("UserDTO " + userModel);
		return new ModelAndView("xml", "employees", status);
	}

	/**
	 * Upload org img.
	 *
	 * @param file
	 *           the file
	 * @param fileName
	 *           the file name
	 * @return String : It gives the result like data inserted or not .
	 * @throws Exception
	 *            the exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "uploadCustomerImg", headers = "content-type=multipart/form-data")
	public @ResponseBody String uploadCustomerImg(@RequestParam("file") MultipartFile file,
			@RequestParam("fileName") String fileName) throws Exception
	{
		String imageInserted = null;
		String rootPath = System.getProperty("catalina.home");
		File theDir = new File(rootPath + "/webapps/RSA247WebService/Customer/" + fileName);
		// if the directory does not exist, create it
		if (!theDir.exists())
		{
			boolean result = false;
			try
			{
				theDir.mkdir();
				result = true;
			}
			catch (SecurityException se)
			{
				// handle it
			}
			if (result)
			{
				if (file != null)
				{
					try
					{
						byte[] bytes = file.getBytes();
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(theDir.getPath() + "/" + fileName + ".jpg"));
						stream.write(bytes);
						stream.flush();
						stream.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}

				}
				else
				{
					throw new Exception("File not found ");
				}
				imageInserted = "Inserted Data";
			}
		}
		return imageInserted;
	}

	/**
	 * Upload employee img.
	 *
	 * @param file
	 *           the file
	 * @param folderName
	 *           the folder name
	 * @param employeeName
	 *           the employee name
	 * @return the string
	 * @throws Exception
	 *            the exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "uploadEmployeeImg", headers = "content-type=multipart/form-data")
	public @ResponseBody String uploadEmployeeImg(@RequestParam("file") MultipartFile file,
			@RequestParam("fileName") String folderName, @RequestParam("employeeName") String employeeName) throws Exception
	{
		String imageInserted = null;
		String rootPath = System.getProperty("catalina.home");
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		prop.load(inputStream);
		// File theDir = new File(rootPath + prop.getProperty("App_Name") +
		// orgImageFolderAndEmployeeName.get(1)+ "/"
		// +orgImageFolderAndEmployeeName.get(0).trim() );
		File theDir = new File(rootPath + prop.getProperty("App_Name") + folderName);
		// if the directory does not exist, create it
		if (!theDir.exists())
		{
			boolean result = false;
			try
			{
				theDir.mkdir();
				result = true;
			}
			catch (SecurityException se)
			{
				se.printStackTrace();
			}
			if (result)
			{
				File finalEmpl = new File(theDir + "/" + employeeName);
				if (!finalEmpl.exists())
				{
					boolean result1 = false;
					try
					{
						finalEmpl.mkdir();
						result1 = true;
					}
					catch (SecurityException se)
					{
						se.printStackTrace();
					}
					if (result1)
					{
						if (file != null)
						{
							try
							{
								byte[] bytes = file.getBytes();
								BufferedOutputStream stream = new BufferedOutputStream(
										new FileOutputStream(finalEmpl.getPath() + "/" + employeeName + ".jpg"));
								stream.write(bytes);
								stream.flush();
								stream.close();
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						}
						else
						{
							throw new Exception("File not found ");
						}
						imageInserted = "Inserted Data";
					}
				}
				else
				{
					imageInserted = "Inserted Data";
					System.out.println("File Already exist");
				}
			}
		}
		else
		{

			File finalEmpl = new File(theDir + "/" + employeeName);
			if (!finalEmpl.exists())
			{
				boolean result1 = false;
				try
				{
					finalEmpl.mkdir();
					result1 = true;
				}
				catch (SecurityException se)
				{
					se.printStackTrace();
				}
				if (result1)
				{
					if (file != null)
					{
						try
						{
							byte[] bytes = file.getBytes();
							BufferedOutputStream stream = new BufferedOutputStream(
									new FileOutputStream(finalEmpl.getPath() + "/" + employeeName + ".jpg"));
							stream.write(bytes);
							stream.flush();
							stream.close();
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
					else
					{
						throw new Exception("File not found ");
					}
					imageInserted = "Inserted Data";
				}
			}
			else
			{
				System.out.println("File Already exist");
				imageInserted = "Inserted Data";
			}

		}

		return imageInserted;
	}

	/**
	 * Upload ids img.
	 *
	 * @param files
	 *           the files
	 * @param foldername
	 *           the foldername
	 * @return the string
	 * @throws Exception
	 *            the exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "uploadIDSImg", headers = "content-type=multipart/form-data")
	public @ResponseBody String uploadIDSImg(@RequestParam("file") MultipartFile[] files,
			@RequestParam("fileName") String foldername) throws Exception
	{
		String imageInserted = null;
		String rootPath = System.getProperty("catalina.home");
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		prop.load(inputStream);
		// File theDir = new File(rootPath + prop.getProperty("App_Name") +
		// orgImageFolderAndEmployeeName.get(1)+ "/"
		// +orgImageFolderAndEmployeeName.get(0).trim() );
		File theDir = new File(rootPath + prop.getProperty("App_Name") + foldername);
		// if the directory does not exist, create it
		if (!theDir.exists())
		{
			boolean result = false;
			try
			{
				theDir.mkdir();
				result = true;
			}
			catch (SecurityException se)
			{
				se.printStackTrace();
			}
			if (result)
			{
				File finalEmpl = new File(theDir + "/" + "ID");
				if (!finalEmpl.exists())
				{
					boolean result1 = false;
					try
					{
						finalEmpl.mkdir();
						result1 = true;
					}
					catch (SecurityException se)
					{
						se.printStackTrace();
					}
					if (result1)
					{
						if (files != null && files.length > 0)
						{
							for (int i = 0; i < files.length; i++)
							{
								try
								{
									byte[] bytes = files[i].getBytes();
									BufferedOutputStream stream = new BufferedOutputStream(
											new FileOutputStream(finalEmpl.getPath() + "/" + "ID" + i + ".jpg"));
									stream.write(bytes);
									stream.flush();
									stream.close();
								}
								catch (Exception e)
								{
									e.printStackTrace();
								}
							}
						}
						else
						{
							throw new Exception("File not found ");
						}
						imageInserted = "Inserted Data";
					}
				}
				else
				{
					System.out.println("File Already exist");
					imageInserted = "Inserted Data";
				}
			}
		}
		else
		{

			File finalEmpl = new File(theDir + "/" + "ID");
			if (!finalEmpl.exists())
			{
				boolean result1 = false;
				try
				{
					finalEmpl.mkdir();
					result1 = true;
				}
				catch (SecurityException se)
				{
					se.printStackTrace();
				}
				if (result1)
				{
					if (files != null && files.length > 0)
					{
						for (int i = 0; i < files.length; i++)
						{
							try
							{
								byte[] bytes = files[i].getBytes();
								BufferedOutputStream stream = new BufferedOutputStream(
										new FileOutputStream(finalEmpl.getPath() + "/" + "ID" + i + ".jpg"));
								stream.write(bytes);
								stream.flush();
								stream.close();
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						}
					}
					else
					{
						throw new Exception("File not found ");
					}
					imageInserted = "Inserted Data";
				}
			}
			else
			{
				imageInserted = "Inserted Data";
				System.out.println("File Already exist");
			}

		}

		return imageInserted;
	}

	/**
	 * Upload org img.
	 *
	 * @param files
	 *           the files
	 * @param fileName
	 *           the file name
	 * @return String : It gives the result like data inserted or not .
	 * @throws Exception
	 *            the exception
	 * @Description This method is for upload the verification form images.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "uploadOrgImg", headers = "content-type=multipart/form-data")
	public @ResponseBody String uploadOrgImg(@RequestParam("file") MultipartFile[] files,
			@RequestParam("fileName") String fileName) throws Exception
	{
		String imageInserted = null;
		String rootPath = System.getProperty("catalina.home");
		Properties prop = new Properties();
		InputStream inputStream = UserManagementResource.class.getClassLoader().getResourceAsStream("/constant.properties");
		prop.load(inputStream);
		File theDir = new File(rootPath + prop.getProperty("App_Name") + fileName);
		// if the directory does not exist, create it
		if (!theDir.exists())
		{
			boolean result = false;
			try
			{
				theDir.mkdir();
				result = true;
			}
			catch (SecurityException se)
			{
				// handle it
			}
			if (result)
			{
				if (files != null && files.length > 0)
				{
					for (int i = 0; i < files.length; i++)
					{
						try
						{
							byte[] bytes = files[i].getBytes();
							BufferedOutputStream stream = new BufferedOutputStream(
									new FileOutputStream(theDir.getPath() + "/" + fileName + i + ".jpg"));
							stream.write(bytes);
							stream.flush();
							stream.close();
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				}
				else
				{
					throw new Exception("File not found ");
				}
				imageInserted = "Inserted Data";
			}
		}
		return imageInserted;
	}
}
