/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.UserModel;
import com.ucs.rsa.model.UserVehicleModel;


// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService extends BaseService
{

	/**
	 * Update customer.
	 *
	 * @param iCustomerModel
	 *           the i customer model
	 * @return the customer model
	 */
	public CustomerModel updateCustomer(CustomerModel iCustomerModel);

	/**
	 * Update service provider.
	 *
	 * @param iCustomerModel
	 *           the i customer model
	 * @return the service provider model
	 */
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iCustomerModel);

	/**
	 * Update employee.
	 *
	 * @param iCustomerModel
	 *           the i customer model
	 * @return the employee model
	 */
	public EmployeeModel updateEmployee(EmployeeModel iCustomerModel);

	/**
	 * Login.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iGcmId
	 *           the i gcm id
	 * @return the string
	 */
	public String login(long iMobileNo, String iGcmId);

	/**
	 * Employee login.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iGcmId
	 *           the i gcm id
	 * @return the string
	 */
	public String employeeLogin(long iMobileNo, String iGcmId);

	/**
	 * Gets the service providermatching model.
	 *
	 * @param serviceProviderServiceMatchingModelList
	 *           the service provider service matching model list
	 * @return the service providermatching model
	 */
	public ServiceProviderServiceMatchingModel getServiceProvidermatchingModel(
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList);

	/**
	 * Insert employees data.
	 *
	 * @param employees
	 *           the employees
	 * @return the employee model
	 */
	public EmployeeModel insertEmployeesData(EmployeeModel employees);

	/**
	 * Approve service provider.
	 *
	 * @param serviceProviderId
	 *           the service provider id
	 * @return the string
	 */
	public String approveServiceProvider(int serviceProviderId);

	/**
	 * Approve employee.
	 *
	 * @param employeeId
	 *           the employee id
	 * @return the string
	 */
	public String approveEmployee(int employeeId);

	/**
	 * Accept term and condition.
	 *
	 * @param imageFolderName
	 *           the image folder name
	 * @param accepttermAndCondition
	 *           the acceptterm and condition
	 * @return the string
	 */
	public String acceptTermAndCondition(String imageFolderName, boolean accepttermAndCondition);

	/**
	 * Update member ship.
	 *
	 * @param userId
	 *           the user id
	 * @param isMembership
	 *           the is membership
	 * @return the customer model
	 */
	public CustomerModel updateMemberShip(int userId, boolean isMembership);

	/**
	 * Gets the uservehicle detail.
	 *
	 * @param userId
	 *           the user id
	 * @return the uservehicle detail
	 */
	public UserVehicleModel getUservehicleDetail(int userId);

	/**
	 * Gets the employee from number.
	 *
	 * @param employeeNumber
	 *           the employee number
	 * @return the employee from number
	 */
	public EmployeeModel getEmployeeFromNumber(long employeeNumber);

	/**
	 * Gets the service provider from number.
	 *
	 * @param serviceProviderNumber
	 *           the service provider number
	 * @return the service provider from number
	 */
	public ServiceProviderModel getServiceProviderFromNumber(long serviceProviderNumber);

	/**
	 * Gets the user by username.
	 *
	 * @param username
	 *           the username
	 * @return the user by username
	 */
	public UserModel getUserByUsername(String username);

	/**
	 * Find all service providers.
	 *
	 * @param iPageNo
	 *           the i page no
	 * @param iRecordsPerPage
	 *           the i records per page
	 * @return the list
	 */
	public List<ServiceProviderModel> findAllServiceProviders(int iPageNo, int iRecordsPerPage);

	/**
	 * Find no of records.
	 *
	 * @return the int
	 */
	public int findNoOfRecords();

	/**
	 * Find all employees.
	 *
	 * @param iPageNo
	 *           the i page no
	 * @param iRecordsPerPage
	 *           the i records per page
	 * @return the list
	 */
	public List<EmployeeModel> findAllEmployees(int iPageNo, int iRecordsPerPage);

	/**
	 * Search employees by mobile no.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @return the list
	 */
	public List<EmployeeModel> searchEmployeesByMobileNo(String iMobileNo);

	/**
	 * Find all cities.
	 *
	 * @return the sets the
	 */
	public Set<String> findAllCities();

	/**
	 * Filtered service providers.
	 *
	 * @param iCity
	 *           the i city
	 * @param iApprove
	 *           the i approve
	 * @return the list
	 */
	public List<ServiceProviderModel> filteredServiceProviders(String iCity, String iApprove);

	/**
	 * Search customer by mobile no.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @return the list
	 */
	public List<CustomerModel> searchCustomerByMobileNo(String iMobileNo);

	/**
	 * Search service provider by mobile no.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @return the list
	 */
	public List<ServiceProviderModel> searchServiceProviderByMobileNo(String iMobileNo);

	/**
	 * @param iApprove
	 * @return
	 */
	public List<EmployeeModel> filteredEmployees(String iApprove);

}
