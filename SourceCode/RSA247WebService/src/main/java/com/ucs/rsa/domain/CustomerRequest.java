package com.ucs.rsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "customer_request_t")
public class CustomerRequest extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issue_id", unique = true, insertable = true, updatable = false)
	private int issueId;

	@Column(name = "issue_type")
	private String issueType;

	@Column(name = "customer_latitude")
	private double customerLatitude;

	@Column(name = "customer_longitude")
	private double customerLongitude;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "issue_status")
	private String issueStatus;

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

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CustomerRequest [issueId=" + issueId + ", issueType=" + issueType + ", customerLatitude="
				+ customerLatitude + ", customerLongitude=" + customerLongitude + ", userId=" + userId
				+ ", issueStatus=" + issueStatus + "]";
	}

}
