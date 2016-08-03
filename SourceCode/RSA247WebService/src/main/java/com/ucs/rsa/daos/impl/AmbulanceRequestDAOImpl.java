package com.ucs.rsa.daos.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.ICustomerRequestDAO;
import com.ucs.rsa.model.AmbulanceRequest;

@Repository(value="customerRequestDAO")
public class AmbulanceRequestDAOImpl extends DefaultBaseDAO implements
		ICustomerRequestDAO {

	@Override
	public AmbulanceRequest updateAmbulanceRequest(
			AmbulanceRequest iCustomerRequestDTO, boolean isCreate) {
		
		AmbulanceRequest ambulanceRequest=iCustomerRequestDTO;
		Session theSession = null;
		try {
			theSession = currentSession();		
			theSession.saveOrUpdate(ambulanceRequest);
			
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return ambulanceRequest;
	}

}
