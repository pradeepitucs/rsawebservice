package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer_request", namespace = "com.ucs.rsa.dto")
public class CustomerRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 6325865187874911617L;

	private int issueId;

	private String issueType;

	private double customerLatitude;

	private double customerLongitude;

	private int userId;

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
