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

@Entity
@Table(name = "customer_sub_issue_t")
@NamedQuery(name = "CustomerSubIssueModel.findAll", query = "SELECT u FROM CustomerSubIssueModel u")
public class CustomerSubIssueModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "update_issue_id")
	private int updateIssueId;
	
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;
	
	@ManyToOne
	@JoinColumn(name="issue_id")
	private CustomerRequestModel customerRequestModel;

	public int getUpdateIssueId() {
		return updateIssueId;
	}

	public void setUpdateIssueId(int updateIssueId) {
		this.updateIssueId = updateIssueId;
	}

	public ServiceTypeModel getServiceTypeModel() {
		return serviceTypeModel;
	}

	public void setServiceTypeModel(ServiceTypeModel serviceTypeModel) {
		this.serviceTypeModel = serviceTypeModel;
	}
	
	public CustomerRequestModel getCustomerRequestModel() {
		return customerRequestModel;
	}

	public void setCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		this.customerRequestModel = customerRequestModel;
	}

	@Override
	public String toString() {
		return "CustomerSubIssueModel [ issueId=" + customerRequestModel + ", updateIssueId=" + updateIssueId
				 + ", serviceTypeModel="
				+ serviceTypeModel  + "]" + super.toString();
	}

}
