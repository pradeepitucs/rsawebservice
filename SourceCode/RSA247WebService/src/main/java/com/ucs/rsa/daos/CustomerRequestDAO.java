package com.ucs.rsa.daos;

import com.ucs.rsa.model.CustomerRequestModel;

public interface CustomerRequestDAO extends BaseDAO{
	
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel);

}
