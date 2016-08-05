package com.ucs.rsa.daos;

import com.ucs.rsa.model.AmbulanceRequest;

public interface ICustomerRequestDAO extends BaseDAO{
	
	public AmbulanceRequest updateAmbulanceRequest(AmbulanceRequest iAmbulanceRequest, boolean isCreate);

}
