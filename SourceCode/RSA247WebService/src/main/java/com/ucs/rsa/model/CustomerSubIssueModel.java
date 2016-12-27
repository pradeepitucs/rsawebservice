/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The Class CustomerSubIssueModel.
 */
@Entity
@Table(name = "customer_sub_issue_t")
@NamedQuery(name = "CustomerSubIssueModel.findAll", query = "SELECT u FROM CustomerSubIssueModel u")
public class CustomerSubIssueModel implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The update issue id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "update_issue_id")
	private int updateIssueId;
	
	/** The service type model. */
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;
	
	/** The customer request model. */
	@ManyToOne
	@JoinColumn(name="issue_id")
	private CustomerRequestModel customerRequestModel;

	/**
	 * Gets the update issue id.
	 *
	 * @return the update issue id
	 */
	public int getUpdateIssueId() {
		return updateIssueId;
	}

	/**
	 * Sets the update issue id.
	 *
	 * @param updateIssueId the new update issue id
	 */
	public void setUpdateIssueId(int updateIssueId) {
		this.updateIssueId = updateIssueId;
	}

	/**
	 * Gets the service type model.
	 *
	 * @return the service type model
	 */
	public ServiceTypeModel getServiceTypeModel() {
		return serviceTypeModel;
	}

	/**
	 * Sets the service type model.
	 *
	 * @param serviceTypeModel the new service type model
	 */
	public void setServiceTypeModel(ServiceTypeModel serviceTypeModel) {
		this.serviceTypeModel = serviceTypeModel;
	}
	
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
	public String toString() {
		return "CustomerSubIssueModel [ issueId=" + customerRequestModel + ", updateIssueId=" + updateIssueId
				 + ", serviceTypeModel="
				+ serviceTypeModel  + "]" + super.toString();
	}

}
