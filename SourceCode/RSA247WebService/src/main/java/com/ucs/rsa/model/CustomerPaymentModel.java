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
@NamedQuery(name = "CustomerPaymentModel.findAll", query = "SELECT c FROM CustomerPaymentModel c")
public class CustomerPaymentModel extends PaymentModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private CustomerModel customerModel;

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	
}
