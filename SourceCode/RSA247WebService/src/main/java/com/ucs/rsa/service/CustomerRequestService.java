package com.ucs.rsa.service;

import com.ucs.rsa.model.AmbulanceRequest;

public interface ICustomerRequestService extends BaseService {
	
	public AmbulanceRequest updateAmbulanceRequest(AmbulanceRequest iAmbulanceRequest, boolean isCreate);

}
