package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer_payment_t")
@PrimaryKeyJoinColumn(name = "payment_id")
@NamedQuery(name = "IssuePaymentModel.findAll", query = "SELECT c FROM IssuePaymentModel c")
public class IssuePaymentModel extends PaymentModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "issue_id")
	private CustomerRequestModel customerRequestModel;

	public CustomerRequestModel getCustomerRequestModel() {
		return customerRequestModel;
	}

	public void setCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		this.customerRequestModel = customerRequestModel;
	}

}
