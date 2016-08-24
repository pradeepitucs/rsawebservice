package com.ucs.rsa.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.ucs.rsa.common.dto.RoleDTO;
import com.ucs.rsa.common.dto.RolesDTO;
import com.ucs.rsa.common.dto.ServiceProviderDTO;
import com.ucs.rsa.common.dto.ServiceProvidersDTO;
import com.ucs.rsa.model.CityModel;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.RoleModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.service.BillGeneratorService;
import com.ucs.rsa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserManagementResource {

	@Autowired
	UserService userService;
	
	@Autowired
	BillGeneratorService billGenerator;

	@RequestMapping(value = "/updateCustomer", method = { RequestMethod.POST, RequestMethod.GET })
	private ModelAndView updateCustomer(@RequestParam(value = "userid") final int iUserId,
			@RequestParam(value = "userfirstname") final String iUserFirstName,
			@RequestParam(value = "userlastname") final String iUserLastName,
			@RequestParam(value = "mobileno", required = true) final long iMobileNo,
			@RequestParam(value = "emailid", required = true) final String iEmailId,
			@RequestParam(value = "city") final int iCity,
			@RequestParam(value = "roleid", required = true) final int iRoleId,
			@RequestParam(value = "enabled") final boolean isEnabled,
			@RequestParam(value = "gcmid", required = true) final String iGcmId,
			@RequestParam(value = "foldername") final String iFolderName) {

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
		customerModel.setFolderName(iFolderName);

		CustomerModel customerModel1 = getUserService().updateCustomer(customerModel);

		CustomerDTO customerDTO = new CustomerDTO();
		if (customerModel1 != null) {
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
	
	@RequestMapping(value = "/updateEmployee", method = { RequestMethod.POST, RequestMethod.GET })
	private ModelAndView updateEmployee (
			@RequestParam(value = "userid") final int iUserId,
			@RequestParam(value = "employeeName") final String employeeName,
			@RequestParam(value = "employeeEmail") final String employeeEmail,
			@RequestParam(value = "mobileno", required = true) final long iMobileNo,
			@RequestParam(value = "roleid", required = true) final int iRoleId,
			@RequestParam(value = "enabled") final boolean isEnabled,
			@RequestParam(value = "isOnwer") final boolean isOnwer,
			@RequestParam(value = "isSendApprovalNotification") final boolean isSendApprovalNotification,
			@RequestParam(value = "gcmid", required = true) final String iGcmId,
			@RequestParam(value = "olderEmployeeId") final int olderEmployeeId,
			@RequestParam(value = "serviceProviderId") final int serviceProviderId) {

		EmployeeModel customerModel = new EmployeeModel();
		customerModel.setIsEnabled(isEnabled);
		customerModel.setMobileNo(iMobileNo);
		customerModel.setGcmId(iGcmId);
		customerModel.setEmployeeEmail(employeeEmail);
		customerModel.setEmployeeName(employeeName);
		customerModel.setSendArrovalNotification(isSendApprovalNotification);
		
		RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(iRoleId);
		
		customerModel.setRoleModel(roleModel);
		customerModel.setUserId(iUserId);
		customerModel.setOnwer(isOnwer);
		customerModel.setServiceProviderID(serviceProviderId);
		customerModel.setOlderEmployeeID(olderEmployeeId);
		
		EmployeeModel customerModel1 = getUserService().updateEmployee(customerModel);
		if(customerModel1 != null) {
		}
		
		return new ModelAndView("xml", "customer", "Inserted Data");
	}

	@RequestMapping(value = "/customers", method = { RequestMethod.GET })
	public ModelAndView getAllCustomers() {

		List<CustomerModel> customerModels = new ArrayList<>();
		customerModels = getUserService().loadAll(CustomerModel.class);

		CustomersDTO customersDTO = new CustomersDTO();
		List<CustomerDTO> customerDTOs = new ArrayList<>();

		for (CustomerModel customerModel : customerModels) {
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

	@RequestMapping(value = "/customer", method = { RequestMethod.GET })
	public ModelAndView getCustomer(@RequestParam("customerid") final int iCustomerId) {

		CustomerModel customerModel = new CustomerModel();
		customerModel = getUserService().get(CustomerModel.class, iCustomerId);

		CustomerDTO customerDTO = new CustomerDTO();
		if (customerModel != null) {
			customerDTO.setIsEnabled(customerModel.getIsEnabled());
			customerDTO.setEmailId(customerModel.getEmailId());
			customerDTO.setFirstName(customerModel.getFirstName());
			customerDTO.setFolderName(customerModel.getFolderName());
			customerDTO.setGcmId(customerModel.getGcmId());
			customerDTO.setLastName(customerModel.getLastName());
			customerDTO.setMobileNo(customerModel.getMobileNo());
			customerDTO.setUserId(customerModel.getUserId());
		}
		return new ModelAndView("xml", "customer", customerDTO);
	}

	@RequestMapping(value = "/serviceproviders", method = { RequestMethod.GET })
	public ModelAndView getAllServiceProviders() {

		List<ServiceProviderModel> serviceProviderModels = new ArrayList<>();
		serviceProviderModels = getUserService().loadAll(ServiceProviderModel.class);

		ServiceProvidersDTO serviceProvidersDTO = new ServiceProvidersDTO();
		List<ServiceProviderDTO> serviceProviderDTOs = new ArrayList<>();

		for (ServiceProviderModel serviceProviderModel : serviceProviderModels) {
			ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO();
			serviceProviderDTO.setEnabled(serviceProviderModel.isEnabled());
			serviceProviderDTO.setMobileNo(serviceProviderModel.getServiceProviderPhoneNumber());
			serviceProviderDTO.setUserId(serviceProviderModel.getServiceProviderId());
			serviceProviderDTOs.add(serviceProviderDTO);
		}
		serviceProvidersDTO.setServiceProviderDTOs(serviceProviderDTOs);
		return new ModelAndView("xml", "serviceproviders", serviceProvidersDTO);
	}

	@RequestMapping(value = "/serviceprovider", method = { RequestMethod.GET })
	public ModelAndView getServiceProviders(@RequestParam("serviceprovidersid") final int iServiceProvidersId) {

		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel = getUserService().get(ServiceProviderModel.class, iServiceProvidersId);

		ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO();
		if (serviceProviderModel != null) {
			serviceProviderDTO.setEnabled(serviceProviderModel.isEnabled());
			serviceProviderDTO.setMobileNo(serviceProviderModel.getServiceProviderPhoneNumber());
			serviceProviderDTO.setUserId(serviceProviderModel.getServiceProviderId());
		}
		return new ModelAndView("xml", "serviceProvider", serviceProviderDTO);
	}

	@RequestMapping(value = "/cities", method = { RequestMethod.GET })
	public ModelAndView getAllCities() {

		List<CityModel> vehicleTypeModelList = new ArrayList<>();
		vehicleTypeModelList = getUserService().loadAll(CityModel.class);

		CitiesDTO citiesDTO = new CitiesDTO();
		List<CityDTO> cityDTOs = new ArrayList<>();

		for (CityModel cityModel : vehicleTypeModelList) {
			CityDTO cityDTO = new CityDTO();
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setCityCode(cityModel.getCityCode());
			cityDTO.setCityName(cityModel.getCityName());
			cityDTO.setCityId(cityModel.getCityId());
			cityDTOs.add(cityDTO);
		}
		citiesDTO.setCityDTOs(cityDTOs);
		return new ModelAndView("xml", "cities", citiesDTO);
	}

	@RequestMapping(value = "/city", method = { RequestMethod.GET })
	public ModelAndView getCity(@RequestParam("cityid") final int iCityId) {

		CityModel cityModel = new CityModel();
		cityModel = getUserService().get(CityModel.class, iCityId);

		CityDTO cityDTO = new CityDTO();
		if (cityModel != null) {
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setCityCode(cityModel.getCityCode());
			cityDTO.setCityName(cityModel.getCityName());
			cityDTO.setCityId(cityModel.getCityId());
		}
		return new ModelAndView("xml", "city", cityDTO);
	}

	@RequestMapping(value = "/roles", method = { RequestMethod.GET })
	public ModelAndView getUserRoles() {

		List<RoleModel> roleModelList = new ArrayList<>();
		roleModelList = getUserService().loadAll(RoleModel.class);

		RolesDTO rolesDTO = new RolesDTO();
		List<RoleDTO> roleDTOs = new ArrayList<>();

		for (RoleModel roleModel : roleModelList) {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setRoleId(roleModel.getRoleId());
			roleDTO.setRoleName(roleModel.getRoleName());
			roleDTOs.add(roleDTO);
		}
		rolesDTO.setRoleDTOs(roleDTOs);
		return new ModelAndView("xml", "roles", rolesDTO);
	}

	@RequestMapping(value = "/role", method = { RequestMethod.GET })
	public ModelAndView getUserRole(@RequestParam("roleid") final int iRoleId) {

		RoleModel roleModel = new RoleModel();
		roleModel = getUserService().get(RoleModel.class, iRoleId);

		RoleDTO roleDTO = new RoleDTO();
		if (roleModel != null) {
			roleDTO.setRoleId(roleModel.getRoleId());
			roleDTO.setRoleName(roleModel.getRoleName());
		}
		return new ModelAndView("xml", "role", roleDTO);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Upload org img.
	 *
	 * @param files
	 *            the files
	 * @param fileName
	 *            the file name
	 * @return String : It gives the result like data inserted or not .
	 * @throws Exception
	 *             the exception
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "uploadCustomerImg", headers = "content-type=multipart/form-data")
	public @ResponseBody String uploadOrgImg(@RequestParam("file") MultipartFile[] files,
			@RequestParam("fileName") String fileName) throws Exception {
		String imageInserted = null;
		String rootPath = System.getProperty("catalina.home");
		File theDir = new File(rootPath + "/webapps/CustomerApp/" + fileName);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			boolean result = false;
			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				if (files != null && files.length > 0) {
					for (int i = 0; i < files.length; i++) {
						try {
							byte[] bytes = files[i].getBytes();
							BufferedOutputStream stream = new BufferedOutputStream(
									new FileOutputStream(theDir.getPath() + "/" + fileName + i + ".jpg"));
							stream.write(bytes);
							stream.flush();
							stream.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					throw new Exception("File not found ");
				}
				imageInserted = "Inserted Data";
			}
		}
		return imageInserted;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	private ModelAndView updateServiceProvider(@RequestParam("bodyRepair") final boolean bodyRepair,
			@RequestParam("electricalType") final boolean electricalType,
			@RequestParam("enabled") final boolean enabled,
			@RequestParam("imageFolderName") final String imageFolderName,
			@RequestParam("mechanicalType") final boolean mechanicalType, @RequestParam("mobileNo") final long mobileNo,
			@RequestParam("rating") final double rating, 
			@RequestParam("serviceProviderCity") final String serviceProviderCity,
			@RequestParam("serviceProviderComments") final String serviceProviderComments,
			@RequestParam("serviceproviderExperties") final String serviceproviderExperties,
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
			@RequestParam("twoWheeler") final Boolean twoWheeler,
			@RequestParam("fourWheeler") final Boolean fourWheeler,
			@RequestParam("serviceProviderTimeStamp") final Timestamp serviceProviderTimeStamp,
			@RequestParam("olderServiceProviderId") final Integer olderServiceProviderId) {
		ServiceProviderModel serviceProvider = new ServiceProviderModel();
		serviceProvider.setBodyRepair(bodyRepair);
		serviceProvider.setElectricalType(electricalType);
		serviceProvider.setImageFolderName(imageFolderName);
		serviceProvider.setMechanicalType(mechanicalType);
		serviceProvider.setServiceProviderPhoneNumber(mobileNo);
		serviceProvider.setRating(rating);
		serviceProvider.setServiceProviderCity(serviceProviderCity);
		serviceProvider.setServiceProviderComments(serviceProviderComments);
		serviceProvider.setServiceproviderExperties(serviceproviderExperties);
		serviceProvider.setServiceProviderId(serviceProviderId);
		serviceProvider.setServiceProviderLatitude(serviceProviderLatitude);
		serviceProvider.setServiceProviderLongitude(serviceProviderLongitude);
		serviceProvider.setServiceProviderMaxDistanceToOperate(serviceProviderMaxDistanceToOperate);
		serviceProvider.setServiceProviderName(serviceProviderName);
		serviceProvider.setServiceProviderNightOperation(serviceProviderNightOperation);
		serviceProvider.setServiceProviderotherServices(serviceProviderotherServices);
		serviceProvider.setServiceProviderPremium(serviceProviderPremium);
		serviceProvider.setServiceProvidertiming(serviceProvidertiming);
		serviceProvider.setServiceProviderWebsite(serviceProviderWebsite);
		serviceProvider.setFourWheeler(fourWheeler);
		serviceProvider.setTwoWheeler(twoWheeler);
		serviceProvider.setEnabled(enabled);
		serviceProvider.setOlderServiceProviderId(olderServiceProviderId);
		serviceProvider.setServiceProviderTimestamp(serviceProviderTimeStamp);
		System.out.println("ServiceProviderDTO " + serviceProvider);

		ServiceProviderModel userModel = userService.updateServiceProvider(serviceProvider);

		System.out.println("UserDTO " + userModel);
		return new ModelAndView("xml", "userDTO", "Inserted Data");

	}

	/**
	 * Upload ids img.
	 *
	 * @param files
	 *            the files
	 * @param phoneNumber
	 *            the phone number
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "uploadIDSImg", headers = "content-type=multipart/form-data")
	public @ResponseBody String uploadIDSImg(@RequestParam("file") MultipartFile[] files,
			@RequestParam("fileName") String phoneNumber) throws Exception {
		ArrayList<String> orgImageFolderAndEmployeeName = null;// surveyService.getOrgImageFolderAndEmployeeName(phoneNumber,constant);
		String imageInserted = null;
		String rootPath = System.getProperty("catalina.home");
		File theDir = new File(rootPath + "/webapps/ServiceProviderApp/" + orgImageFolderAndEmployeeName.get(1));
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			boolean result = false;
			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				se.printStackTrace();
			}
			if (result) {
				File finalEmpl = new File(theDir + "/" + "ID");
				if (!finalEmpl.exists()) {
					boolean result1 = false;
					try {
						finalEmpl.mkdir();
						result1 = true;
					} catch (SecurityException se) {
						se.printStackTrace();
					}
					if (result1) {
						if (files != null && files.length > 0) {
							for (int i = 0; i < files.length; i++) {
								try {
									byte[] bytes = files[i].getBytes();
									BufferedOutputStream stream = new BufferedOutputStream(
											new FileOutputStream(finalEmpl.getPath() + "/" + "ID" + i + ".jpg"));
									stream.write(bytes);
									stream.flush();
									stream.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else {
							throw new Exception("File not found ");
						}
						imageInserted = "Inserted Image";
					}
				} else {
					System.out.println("File Already exist");
					imageInserted = "Already Exist";
				}
			}
		} else {

			File finalEmpl = new File(theDir + "/" + "ID");
			if (!finalEmpl.exists()) {
				boolean result1 = false;
				try {
					finalEmpl.mkdir();
					result1 = true;
				} catch (SecurityException se) {
					se.printStackTrace();
				}
				if (result1) {
					if (files != null && files.length > 0) {
						for (int i = 0; i < files.length; i++) {
							try {
								byte[] bytes = files[i].getBytes();
								BufferedOutputStream stream = new BufferedOutputStream(
										new FileOutputStream(finalEmpl.getPath() + "/" + "ID" + i + ".jpg"));
								stream.write(bytes);
								stream.flush();
								stream.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else {
						throw new Exception("File not found ");
					}
					imageInserted = "Inserted Image";
				}
			} else {
				imageInserted = "Already Exist";
				System.out.println("File Already exist");
			}

		}

		return imageInserted;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "mobileno") final String iMobileNo,
			@RequestParam(value = "gcmid") final String iGcmId) {

		String result = getUserService().login(iMobileNo, iGcmId);

		return new ModelAndView("xml", "result", result);
	}

	@RequestMapping(value = "/genertbill", method = RequestMethod.GET)
	public ModelAndView genertBill() {
		StringBuilder result = getBillGenerator().genertBill();
		return new ModelAndView("xml", "result", result);
	}

	public BillGeneratorService getBillGenerator() {
		return billGenerator;
	}

	public void setBillGenerator(BillGeneratorService billGenerator) {
		this.billGenerator = billGenerator;
	}
	
	
}
