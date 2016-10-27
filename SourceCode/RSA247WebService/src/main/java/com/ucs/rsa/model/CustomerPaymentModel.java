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
 * The Class CustomerPaymentModel.
 */
@Entity
@Table(name = "customer_payment_t")
@PrimaryKeyJoinColumn(name = "payment_id")
@NamedQuery(name = "CustomerPaymentModel.findAll", query = "SELECT c FROM CustomerPaymentModel c")
public class CustomerPaymentModel extends PaymentModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The customer model. */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private CustomerModel customerModel;

	/**
	 * Gets the customer model.
	 *
	 * @return the customer model
	 */
	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	/**
	 * Sets the customer model.
	 *
	 * @param customerModel the new customer model
	 */
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CustomerPaymentModel [customerModel=" + customerModel + "]";
	}
	
}
