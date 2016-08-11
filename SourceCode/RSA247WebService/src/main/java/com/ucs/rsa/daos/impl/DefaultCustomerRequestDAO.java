package com.ucs.rsa.daos.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerRequestDAO;
import com.ucs.rsa.model.CustomerRequestModel;

@Repository(value = "customerRequestDAO")
public class DefaultCustomerRequestDAO extends DefaultBaseDAO implements CustomerRequestDAO {

	@Override
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel) {
		CustomerRequestModel customerRequestModel = iCustomerRequestModel;
		Session theSession = null;
		try {
			theSession = currentSession();
			theSession.saveOrUpdate(customerRequestModel);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerRequestModel;
	}

}