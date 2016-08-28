/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Interface UserService.
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
	public String login(String iMobileNo, String iGcmId);

}
