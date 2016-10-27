/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerReviewDAO;
import com.ucs.rsa.model.CustomerReviewModel;
import com.ucs.rsa.model.ServiceProviderModel;


// TODO: Auto-generated Javadoc
/**
 * The Class DefaultCustomerReviewDAO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Repository(value = "customerReviewDAO")
public class DefaultCustomerReviewDAO extends DefaultBaseDAO implements CustomerReviewDAO
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerReviewDAO#updateCustomerReview(com.ucs.rsa.model.CustomerReviewModel)
	 */
	@Override
	public CustomerReviewModel updateCustomerReview(CustomerReviewModel iCustomerReviewModel)
	{
		CustomerReviewModel customerReviewModel = iCustomerReviewModel;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			theSession.saveOrUpdate(customerReviewModel);

			if (customerReviewModel.getServiceProviderModel() != null
					&& customerReviewModel.getServiceProviderModel().getServiceProviderId() != 0)
			{
				updateServiceProviderRateing(customerReviewModel.getServiceProviderModel().getServiceProviderId());
			}
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerReviewModel;
	}

	/**
	 * Update service provider rateing.
	 *
	 * @param serviceProviderId
	 *           the service provider id
	 */
	private void updateServiceProviderRateing(int serviceProviderId)
	{
		Session theSession = null;
		try
		{
			theSession = currentSession();

			ServiceProviderModel serviceProviderModel = (ServiceProviderModel) theSession
					.createCriteria(ServiceProviderModel.class, "serviceProviderModel")
					.add(Restrictions.eq("serviceProviderId", serviceProviderId)).uniqueResult();

			double rate = (double) theSession.createCriteria(CustomerReviewModel.class, "serviceProviderModel")
					.createAlias("serviceProviderModel", "serviceProviderModel1")
					.add(Restrictions.eq("serviceProviderModel1.serviceProviderId", serviceProviderId))
					.setProjection(Projections.avg("rating")).uniqueResult();

			if (serviceProviderModel.getRating() != rate)
			{
				serviceProviderModel.setRating(rate);
				theSession.update(serviceProviderModel);
			}

		}
		catch (Exception e)
		{
			System.out.println(e.getStackTrace());
		}

	}


}
