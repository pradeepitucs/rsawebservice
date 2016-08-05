package com.ucs.rsa.daos.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerReviewDAO;
import com.ucs.rsa.model.CustomerReviewModel;

@Repository(value = "customerReviewDAO")
public class DefaultCustomerReviewDAO extends DefaultBaseDAO implements CustomerReviewDAO {

	@Override
	public CustomerReviewModel updateCustomerReview(CustomerReviewModel iCustomerReviewModel) {
		CustomerReviewModel customerReviewModel = iCustomerReviewModel;
		Session theSession = null;
		try {
			theSession = currentSession();
			theSession.saveOrUpdate(customerReviewModel);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerReviewModel;
	}

}
