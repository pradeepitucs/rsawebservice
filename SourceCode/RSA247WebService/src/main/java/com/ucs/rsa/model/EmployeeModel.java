package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "service_provider_employee_t")
@PrimaryKeyJoinColumn(name = "userId")
@NamedQuery(name = "EmployeeModel.findAll", query = "SELECT c FROM EmployeeModel c")
public class EmployeeModel extends UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_email")
	private String employeeEmail;

	@Column(name = "is_owner")
	private boolean isOnwer;

	@Column(name = "service_provider_id")
	private int serviceProviderID;

	@Column(name = "older_employee_id")
	private int olderEmployeeID;

	@Column(name = "gcm_id")
	private String gcmId;

	@Column(name = "is_send_approval_notification")
	private boolean isSendArrovalNotification;
	
	// bi-directional many-to-one association to CustomerRequestModel
		@OneToMany(mappedBy = "employeeModel", fetch = FetchType.LAZY)
		private List<CustomerRequestModel> customerRequestModels;

		// bi-directional many-to-one association to CustomerReviewModel
		@OneToMany(mappedBy = "employeeModel", fetch = FetchType.LAZY)
		private List<CustomerReviewModel> customerReviewModels;

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
	
	public CustomerRequestModel addCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		getCustomerRequestModels().add(customerRequestModel);
		customerRequestModel.setEmployeeModel(this);
		return customerRequestModel;
	}

	public CustomerRequestModel removeCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		getCustomerRequestModels().remove(customerRequestModel);
		customerRequestModel.setEmployeeModel(null);
		return customerRequestModel;
	}
	
	public List<CustomerRequestModel> getCustomerRequestModels() {
		return customerRequestModels;
	}

	public void setCustomerRequestModels(List<CustomerRequestModel> customerRequestModels) {
		this.customerRequestModels = customerRequestModels;
	}

	public List<CustomerReviewModel> getCustomerReviewModels() {
		return customerReviewModels;
	}

	public void setCustomerReviewModels(List<CustomerReviewModel> customerReviewModels) {
		this.customerReviewModels = customerReviewModels;
	}

	public CustomerReviewModel addCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().add(customerReviewModel);
		customerReviewModel.setEmployeeModel(this);
		return customerReviewModel;
	}

	public CustomerReviewModel removeCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().remove(customerReviewModel);
		customerReviewModel.setEmployeeModel(null);
		return customerReviewModel;
	}

	@Override
	public String toString() {
		return "ServiceProviderEmployee [ employeeName=" + employeeName + ", employeeEmail=" + employeeEmail
				+ ", serviceProviderID=" + serviceProviderID + ", isSendArrovalNotification="
				+ isSendArrovalNotification + ", isOnwer =" + isOnwer + ", gcmId=" + gcmId + ", olderEmployeeID="
				+ olderEmployeeID + "]" + super.toString();
	}

}
