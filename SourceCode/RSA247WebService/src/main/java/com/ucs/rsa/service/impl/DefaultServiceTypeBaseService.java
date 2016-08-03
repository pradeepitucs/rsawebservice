package com.ucs.rsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.service.ServiceTypeService;

@Component
public class DefaultServiceTypeBaseService extends DefaultBaseService implements ServiceTypeService {

	/*@Autowired
	ServiceTypeDAO serviceTypeDAO;

	public ServiceTypeDAO getServiceTypeDAO() {
		return serviceTypeDAO;
	}

	public void setServiceTypeDAO(ServiceTypeDAO serviceTypeDAO) {
		this.serviceTypeDAO = serviceTypeDAO;
	}

	@Override
	public ServiceTypeModel updateServiceType(ServiceTypeModel servieTypeModel) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
