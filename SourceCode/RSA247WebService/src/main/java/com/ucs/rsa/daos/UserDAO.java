package com.ucs.rsa.daos;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;

public interface UserDAO extends BaseDAO {

	public CustomerModel updateCustomer(CustomerModel iCustomerModel);
	
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iCustomerModel);
	
	public EmployeeModel updateEmployee(EmployeeModel iCustomerModel);
	
	public String login(Integer iMobileNo, String iGcmId);
	
}
