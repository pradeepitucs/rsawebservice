/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos;

import com.ucs.rsa.model.CustomerReviewModel;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Interface CustomerReviewDAO.
 */
public interface CustomerReviewDAO extends BaseDAO
{

	/**
	 * Update customer review.
	 *
	 * @param iCustomerReviewModel
	 *           the i customer review model
	 * @return the customer review model
	 */
	public CustomerReviewModel updateCustomerReview(CustomerReviewModel iCustomerReviewModel);

}
