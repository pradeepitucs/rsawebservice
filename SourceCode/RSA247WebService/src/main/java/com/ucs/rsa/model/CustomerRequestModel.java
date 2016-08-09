package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_request_t")
@NamedQuery(name = "CustomerRequestModel.findAll", query = "SELECT u FROM CustomerRequestModel u")
public class CustomerRequestModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "issue_id")
	private int issueId;

	@Column(name = "customer_latitude")
	private double customerLatitude;

	@Column(name = "customer_longitude")
	private double customerLongitude;

	@Column(name = "issue_status")
	private String issueStatus;

	//bi-directional many-to-one association to ServiceTypeModel
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;

	//bi-directional many-to-one association to CustomerModel
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerModel customerModel;

	//bi-directional many-to-one association to ServiceProviderModel
	@ManyToOne
	@JoinColumn(name="employee_id")
	private ServiceProviderModel serviceProviderModel;
	
	// bi-directional many-to-one association to CustomerReviewModel
	@OneToMany(mappedBy = "serviceProviderModel", fetch = FetchType.EAGER)
	private List<CustomerReviewModel> customerReviewModels;

	public CustomerRequestModel() {
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public double getCustomerLatitude() {
		return customerLatitude;
	}

	public void setCustomerLatitude(double customerLatitude) {
		this.customerLatitude = customerLatitude;
	}

	public double getCustomerLongitude() {
		return customerLongitude;
	}

	public void setCustomerLongitude(double customerLongitude) {
		this.customerLongitude = customerLongitude;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public ServiceTypeModel getServiceTypeModel() {
		return serviceTypeModel;
	}

	public void setServiceTypeModel(ServiceTypeModel serviceTypeModel) {
		this.serviceTypeModel = serviceTypeModel;
	}

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public ServiceProviderModel getServiceProviderModel() {
		return serviceProviderModel;
	}

	public void setServiceProviderModel(ServiceProviderModel serviceProviderModel) {
		this.serviceProviderModel = serviceProviderModel;
	}
	
	public List<CustomerReviewModel> getCustomerReviewModels() {
		return customerReviewModels;
	}

	public void setCustomerReviewModels(List<CustomerReviewModel> customerReviewModels) {
		this.customerReviewModels = customerReviewModels;
	}

	public CustomerReviewModel addCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().add(customerReviewModel);
		customerReviewModel.setCustomerRequestModel(this);
		return customerReviewModel;
	}

	public CustomerReviewModel removeCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().remove(customerReviewModel);
		customerReviewModel.setCustomerRequestModel(null);
		return customerReviewModel;
	}
}
