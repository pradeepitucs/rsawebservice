package com.ucs.rsa.service;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.ServiceProviderModel;

public interface UserService extends BaseService {

	public CustomerModel updateCustomer(CustomerModel iCustomerModel);
	
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iCustomerModel);
	
	public String login(String iMobileNo, String iGcmId);

}
