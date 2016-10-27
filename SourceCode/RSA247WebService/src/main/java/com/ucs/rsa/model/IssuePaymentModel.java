/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class IssuePaymentModel.
 */
@Entity
@Table(name = "issue_payment_t")
@PrimaryKeyJoinColumn(name = "payment_id")
@NamedQuery(name = "IssuePaymentModel.findAll", query = "SELECT c FROM IssuePaymentModel c")
public class IssuePaymentModel extends PaymentModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The customer request model. */
	@ManyToOne
	@JoinColumn(name = "issue_id")
	private CustomerRequestModel customerRequestModel;

	/**
	 * Gets the customer request model.
	 *
	 * @return the customer request model
	 */
	public CustomerRequestModel getCustomerRequestModel() {
		return customerRequestModel;
	}

	/**
	 * Sets the customer request model.
	 *
	 * @param customerRequestModel the new customer request model
	 */
	public void setCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		this.customerRequestModel = customerRequestModel;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "IssuePaymentModel [customerRequestModel=" + customerRequestModel + "]";
	}

}
