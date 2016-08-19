package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the customer_review_t database table.
 * 
 */
@Entity
@Table(name = "customer_review_t")
@NamedQuery(name = "CustomerReviewModel.findAll", query = "SELECT c FROM CustomerReviewModel c")
public class CustomerReviewModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_review_id")
	private int customerReviewId;

	@Column(name = "approval_status")
	private int approvalStatus;

	private boolean blocked;

	@Lob
	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time")
	private Date creationTime;

	private String headline;

	private float rating;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modification;
	
	// bi-directional many-to-one association to ServiceProviderModel
	@ManyToOne
	@JoinColumn(name = "service_provider_id")
	private ServiceProviderModel serviceProviderModel;

	// bi-directional many-to-one association to CustomerT
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerModel customerModel;

	// bi-directional many-to-one association to ServiceProviderT
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeModel employeeModel;

	// bi-directional many-to-one association to ServiceProviderT
	@ManyToOne
	@JoinColumn(name = "issueId")
	private CustomerRequestModel customerRequestModel;

	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	public CustomerReviewModel() {
	}

	public int getCustomerReviewId() {
		return customerReviewId;
	}

	public void setCustomerReviewId(int customerReviewId) {
		this.customerReviewId = customerReviewId;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public CustomerRequestModel getCustomerRequestModel() {
		return customerRequestModel;
	}

	public void setCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		this.customerRequestModel = customerRequestModel;
	}

	public Date getModification() {
		return modification;
	}

	public void setModification(Date modification) {
		this.modification = modification;
	}

	public ServiceProviderModel getServiceProviderModel() {
		return serviceProviderModel;
	}

	public void setServiceProviderModel(ServiceProviderModel serviceProviderModel) {
		this.serviceProviderModel = serviceProviderModel;
	}

}