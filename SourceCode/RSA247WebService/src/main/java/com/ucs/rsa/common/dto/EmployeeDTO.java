package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee", namespace = "com.ucs.rsa.dto")
public class EmployeeDTO extends UserDTO {
	
	private static final long serialVersionUID = 1L;
	
	private String employeeName;

	private String employeeEmail;

	private boolean isOnwer;

	private int serviceProviderID;

	private int olderEmployeeID;

	private String gcmId;

	private boolean isSendArrovalNotification;

	public boolean isSendArrovalNotification() {
		return isSendArrovalNotification;
	}

	public void setSendArrovalNotification(boolean isSendArrovalNotification) {
		this.isSendArrovalNotification = isSendArrovalNotification;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public boolean isOnwer() {
		return isOnwer;
	}

	public void setOnwer(boolean isOnwer) {
		this.isOnwer = isOnwer;
	}

	public int getServiceProviderID() {
		return serviceProviderID;
	}

	public void setServiceProviderID(int serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}

	public int getOlderEmployeeID() {
		return olderEmployeeID;
	}

	public void setOlderEmployeeID(int olderEmployeeID) {
		this.olderEmployeeID = olderEmployeeID;
	}

	public String getGcmId() {
		return gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}
	
	@Override
	public String toString() {
		return "ServiceProviderEmployee [ employeeName=" + employeeName + ", employeeEmail=" + employeeEmail
				+ ", serviceProviderID=" + serviceProviderID + ", isSendArrovalNotification="
				+ isSendArrovalNotification + ", isOnwer =" + isOnwer + ", gcmId=" + gcmId + ", olderEmployeeID="
				+ olderEmployeeID + "]" + super.toString();
	}

}
