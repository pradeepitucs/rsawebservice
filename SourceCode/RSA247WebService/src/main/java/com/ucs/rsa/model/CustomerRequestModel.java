package com.ucs.rsa.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
	
	@Column(name = "issue_start_time")
	private Time issueStartTime;
	
	@Column(name = "customer_vehicle_number")
	private String customerVehicleNumber;
	
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column(name = "issue_time")
	private Time issueTime;

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Time getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(Time issueTime) {
		this.issueTime = issueTime;
	}

	public String getCustomerVehicleNumber() {
		return customerVehicleNumber;
	}

	public void setCustomerVehicleNumber(String customerVehicleNumber) {
		this.customerVehicleNumber = customerVehicleNumber;
	}

	public Time getIssueStartTime() {
		return issueStartTime;
	}

	public void setIssueStartTime(Time issueStartTime) {
		this.issueStartTime = issueStartTime;
	}

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
	private EmployeeModel employeeModel;
	
	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	// bi-directional many-to-one association to CustomerReviewModel
	@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
	private List<CustomerReviewModel> customerReviewModels;
	
	// bi-directional many-to-one association to CustomerRequestModel
	@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
	private List<CustomerSubIssueModel> customerSubIssueModel;
	
	@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
	private List<ServiceProviderCommentModel> serviceProviderCommentModel;

	public List<ServiceProviderCommentModel> getServiceProviderCommentModel() {
		return serviceProviderCommentModel;
	}

	public void setServiceProviderCommentModel(List<ServiceProviderCommentModel> serviceProviderCommentModel) {
		this.serviceProviderCommentModel = serviceProviderCommentModel;
	}

	public List<CustomerSubIssueModel> getCustomerSubIssueModel() {
		return customerSubIssueModel;
	}

	public void setCustomerSubIssueModel(List<CustomerSubIssueModel> customerSubIssueModel) {
		this.customerSubIssueModel = customerSubIssueModel;
	}

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
	
	public CustomerSubIssueModel addUpdateCustomerIssueModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().add(customerSubIssueModel);
		customerSubIssueModel.setCustomerRequestModel(this);
		return customerSubIssueModel;
	}

	public CustomerSubIssueModel removeCustomerReviewModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().remove(customerSubIssueModel);
		customerSubIssueModel.setCustomerRequestModel(null);
		return customerSubIssueModel;
	}
	
	public ServiceProviderCommentModel addServiceProviderCommentModel(ServiceProviderCommentModel serviceProviderCommentModel) {
		getServiceProviderCommentModel().add(serviceProviderCommentModel);
		serviceProviderCommentModel.setCustomerRequestModel(this);
		return serviceProviderCommentModel;
	}

	public ServiceProviderCommentModel removeServiceProviderCommentModel(ServiceProviderCommentModel serviceProviderCommentModel) {
		getServiceProviderCommentModel().remove(serviceProviderCommentModel);
		serviceProviderCommentModel.setCustomerRequestModel(null);
		return serviceProviderCommentModel;
	}
	
	/*@Override
	public String toString() {
		return "CustomerRequestModel [ issueId=" + issueId + ", issueStatus=" + issueStatus
				+ ", issueStartTime=" + issueStartTime + ", customerLatitude=" + customerLatitude + ", customerLongitude ="
				+ customerLongitude + ", employeeModel=" + employeeModel
				+ ", customerModel=" + customerModel + ", serviceTypeModel="
				+ serviceTypeModel  + ", customerVehicleNumber="
						+ customerVehicleNumber+ ", issueTime="
								+ issueTime+ ", issueDate="
										+ issueDate+ "]" + super.toString();
	}*/
	
}
