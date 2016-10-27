/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerReviewDAO;
import com.ucs.rsa.model.CustomerReviewModel;
import com.ucs.rsa.service.CustomerReviewService;


// TODO: Auto-generated Javadoc
/**
 * The Class DefaultCustomerReviewService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Service
public class DefaultCustomerReviewService extends DefaultBaseService implements CustomerReviewService
{

	/** The customer review DAO. */
	@Autowired
	@Qualifier("customerReviewDAO")
	CustomerReviewDAO customerReviewDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.CustomerReviewService#updateCustomerReview(com.ucs.rsa.model.CustomerReviewModel)
	 */
	@Override
	public CustomerReviewModel updateCustomerReview(CustomerReviewModel iCustomerReviewModel)
	{
		CustomerReviewModel customerReviewModel = null;
		if (!"".equals(iCustomerReviewModel.getCustomerModel()) && !"".equals(iCustomerReviewModel.getEmployeeModel())
				&& !"".equals(iCustomerReviewModel.getRating()) && !"".equals(iCustomerReviewModel.getEmployeeModel().getUserId())
				&& !"".equals(iCustomerReviewModel.getCustomerModel().getUserId()))
		{
			customerReviewModel = customerReviewDAO.updateCustomerReview(iCustomerReviewModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerReviewModel;
	}

}
