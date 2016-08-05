package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "customer_request_t")
@NamedQuery(name="CustomerRequest.findAll", query="SELECT u FROM CustomerRequest u")
public class CustomerRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issue_id", unique = true, insertable = true, updatable = false)
	private int issueId;

	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;

	@Column(name = "customer_latitude")
	private double customerLatitude;

	@Column(name = "customer_longitude")
	private double customerLongitude;

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserModel userModel;

	@Column(name = "issue_status")
	private String issueStatus;

	public CustomerRequest() {
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
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

	public ServiceTypeModel getServiceTypeModel() {
		return serviceTypeModel;
	}

	public void setServiceTypeModel(ServiceTypeModel serviceTypeModel) {
		this.serviceTypeModel = serviceTypeModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	@Override
	public String toString() {
		return "CustomerRequest [issueId=" + issueId + ", serviceTypeModel=" + serviceTypeModel + ", customerLatitude="
				+ customerLatitude + ", customerLongitude=" + customerLongitude + ", userModel=" + userModel
				+ ", issueStatus=" + issueStatus + "]";
	}

}
