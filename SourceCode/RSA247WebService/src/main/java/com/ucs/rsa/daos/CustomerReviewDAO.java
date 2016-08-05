package com.ucs.rsa.daos;

import com.ucs.rsa.model.CustomerReviewModel;

public interface CustomerReviewDAO extends BaseDAO{
	
	public CustomerReviewModel updateCustomerReview(CustomerReviewModel iCustomerReviewModel);

}
