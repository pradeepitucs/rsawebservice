/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerRequestModel.
 */
@Entity
@Table(name = "customer_request_t")
@NamedQuery(name = "CustomerRequestModel.findAll", query = "SELECT u FROM CustomerRequestModel u")
public class CustomerRequestModel implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The issue id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "issue_id")
	private int issueId;

	/** The customer latitude. */
	@Column(name = "customer_latitude")
	private double customerLatitude;

	/** The customer longitude. */
	@Column(name = "customer_longitude")
	private double customerLongitude;

	/** The issue status. */
	@Column(name = "issue_status")
	private String issueStatus;
	
	/** The issue start time. */
	@Column(name = "issue_start_time")
	private Time issueStartTime;
	
	/** The customer vehicle number. */
	@Column(name = "customer_vehicle_number")
	private String customerVehicleNumber;
	
	/** The issue date. */
	@Column(name = "issue_date")
	private Date issueDate;
	
	/** The issue time. */
	@Column(name = "issue_time")
	private Time issueTime;

	/**
	 * Gets the issue date.
	 *
	 * @return the issue date
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Sets the issue date.
	 *
	 * @param issueDate the new issue date
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Gets the issue time.
	 *
	 * @return the issue time
	 */
	public Time getIssueTime() {
		return issueTime;
	}

	/**
	 * Sets the issue time.
	 *
	 * @param issueTime the new issue time
	 */
	public void setIssueTime(Time issueTime) {
		this.issueTime = issueTime;
	}

	/**
	 * Gets the customer vehicle number.
	 *
	 * @return the customer vehicle number
	 */
	public String getCustomerVehicleNumber() {
		return customerVehicleNumber;
	}

	/**
	 * Sets the customer vehicle number.
	 *
	 * @param customerVehicleNumber the new customer vehicle number
	 */
	public void setCustomerVehicleNumber(String customerVehicleNumber) {
		this.customerVehicleNumber = customerVehicleNumber;
	}

	/**
	 * Gets the issue start time.
	 *
	 * @return the issue start time
	 */
	public Time getIssueStartTime() {
		return issueStartTime;
	}

	/**
	 * Sets the issue start time.
	 *
	 * @param issueStartTime the new issue start time
	 */
	public void setIssueStartTime(Time issueStartTime) {
		this.issueStartTime = issueStartTime;
	}

	/** The service type model. */
	//bi-directional many-to-one association to ServiceTypeModel
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;

	/** The customer model. */
	//bi-directional many-to-one association to CustomerModel
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerModel customerModel;

	//bi-directional many-to-one association to ServiceProviderModel
	/** The employee ID. */
	/*@ManyToOne
	@JoinColumn(name="employee_id")*/
	private int employeeID;

	/**
	 * Gets the employee ID.
	 *
	 * @return the employee ID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * Sets the employee ID.
	 *
	 * @param employeeID the new employee ID
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/** The customer review models. */
	// bi-directional many-to-one association to CustomerReviewModel
	@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
	private List<CustomerReviewModel> customerReviewModels;
	
	/** The issue payment model. */
	// bi-directional many-to-one association to CustomerPaymentModel
		@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
		private List<IssuePaymentModel> issuePaymentModel;

	/**
	 * Gets the issue payment model.
	 *
	 * @return the issue payment model
	 */
	public List<IssuePaymentModel> getIssuePaymentModel() {
			return issuePaymentModel;
		}

		/**
		 * Sets the issue payment model.
		 *
		 * @param issuePaymentModel the new issue payment model
		 */
		public void setIssuePaymentModel(List<IssuePaymentModel> issuePaymentModel) {
			this.issuePaymentModel = issuePaymentModel;
		}

	/** The customer sub issue model. */
	// bi-directional many-to-one association to CustomerRequestModel
	@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
	private List<CustomerSubIssueModel> customerSubIssueModel;
	
	/** The service provider comment model. */
	@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
	private List<ServiceProviderCommentModel> serviceProviderCommentModel;

	/**
	 * Gets the service provider comment model.
	 *
	 * @return the service provider comment model
	 */
	public List<ServiceProviderCommentModel> getServiceProviderCommentModel() {
		return serviceProviderCommentModel;
	}

	/**
	 * Sets the service provider comment model.
	 *
	 * @param serviceProviderCommentModel the new service provider comment model
	 */
	public void setServiceProviderCommentModel(List<ServiceProviderCommentModel> serviceProviderCommentModel) {
		this.serviceProviderCommentModel = serviceProviderCommentModel;
	}

	/**
	 * Gets the customer sub issue model.
	 *
	 * @return the customer sub issue model
	 */
	public List<CustomerSubIssueModel> getCustomerSubIssueModel() {
		return customerSubIssueModel;
	}

	/**
	 * Sets the customer sub issue model.
	 *
	 * @param customerSubIssueModel the new customer sub issue model
	 */
	public void setCustomerSubIssueModel(List<CustomerSubIssueModel> customerSubIssueModel) {
		this.customerSubIssueModel = customerSubIssueModel;
	}

	/**
	 * Instantiates a new customer request model.
	 */
	public CustomerRequestModel() {
	}

	/**
	 * Gets the issue id.
	 *
	 * @return the issue id
	 */
	public int getIssueId() {
		return issueId;
	}

	/**
	 * Sets the issue id.
	 *
	 * @param issueId the new issue id
	 */
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	/**
	 * Gets the customer latitude.
	 *
	 * @return the customer latitude
	 */
	public double getCustomerLatitude() {
		return customerLatitude;
	}

	/**
	 * Sets the customer latitude.
	 *
	 * @param customerLatitude the new customer latitude
	 */
	public void setCustomerLatitude(double customerLatitude) {
		this.customerLatitude = customerLatitude;
	}

	/**
	 * Gets the customer longitude.
	 *
	 * @return the customer longitude
	 */
	public double getCustomerLongitude() {
		return customerLongitude;
	}

	/**
	 * Sets the customer longitude.
	 *
	 * @param customerLongitude the new customer longitude
	 */
	public void setCustomerLongitude(double customerLongitude) {
		this.customerLongitude = customerLongitude;
	}

	/**
	 * Gets the issue status.
	 *
	 * @return the issue status
	 */
	public String getIssueStatus() {
		return issueStatus;
	}

	/**
	 * Sets the issue status.
	 *
	 * @param issueStatus the new issue status
	 */
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
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
	 * Gets the customer model.
	 *
	 * @return the customer model
	 */
	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	/**
	 * Sets the customer model.
	 *
	 * @param customerModel the new customer model
	 */
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	
	/**
	 * Gets the customer review models.
	 *
	 * @return the customer review models
	 */
	public List<CustomerReviewModel> getCustomerReviewModels() {
		return customerReviewModels;
	}

	/**
	 * Sets the customer review models.
	 *
	 * @param customerReviewModels the new customer review models
	 */
	public void setCustomerReviewModels(List<CustomerReviewModel> customerReviewModels) {
		this.customerReviewModels = customerReviewModels;
	}

	/**
	 * Adds the issue payment model.
	 *
	 * @param issuePaymentModel the issue payment model
	 * @return the issue payment model
	 */
	public IssuePaymentModel addIssuePaymentModel(IssuePaymentModel issuePaymentModel) {
		getIssuePaymentModel().add(issuePaymentModel);
		issuePaymentModel.setCustomerRequestModel(this);
		return issuePaymentModel;
	}

	/**
	 * Removes the issue payment model.
	 *
	 * @param issuePaymentModel the issue payment model
	 * @return the issue payment model
	 */
	public IssuePaymentModel removeIssuePaymentModel(IssuePaymentModel issuePaymentModel) {
		getIssuePaymentModel().remove(issuePaymentModel);
		issuePaymentModel.setCustomerRequestModel(null);
		return issuePaymentModel;
	}
	
	/**
	 * Adds the customer review model.
	 *
	 * @param customerReviewModel the customer review model
	 * @return the customer review model
	 */
	public CustomerReviewModel addCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().add(customerReviewModel);
		customerReviewModel.setCustomerRequestModel(this);
		return customerReviewModel;
	}

	/**
	 * Removes the customer review model.
	 *
	 * @param customerReviewModel the customer review model
	 * @return the customer review model
	 */
	public CustomerReviewModel removeCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().remove(customerReviewModel);
		customerReviewModel.setCustomerRequestModel(null);
		return customerReviewModel;
	}
	
	/**
	 * Adds the update customer issue model.
	 *
	 * @param customerSubIssueModel the customer sub issue model
	 * @return the customer sub issue model
	 */
	public CustomerSubIssueModel addUpdateCustomerIssueModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().add(customerSubIssueModel);
		customerSubIssueModel.setCustomerRequestModel(this);
		return customerSubIssueModel;
	}

	/**
	 * Removes the customer review model.
	 *
	 * @param customerSubIssueModel the customer sub issue model
	 * @return the customer sub issue model
	 */
	public CustomerSubIssueModel removeCustomerReviewModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().remove(customerSubIssueModel);
		customerSubIssueModel.setCustomerRequestModel(null);
		return customerSubIssueModel;
	}
	
	/**
	 * Adds the service provider comment model.
	 *
	 * @param serviceProviderCommentModel the service provider comment model
	 * @return the service provider comment model
	 */
	public ServiceProviderCommentModel addServiceProviderCommentModel(ServiceProviderCommentModel serviceProviderCommentModel) {
		getServiceProviderCommentModel().add(serviceProviderCommentModel);
		serviceProviderCommentModel.setCustomerRequestModel(this);
		return serviceProviderCommentModel;
	}

	/**
	 * Removes the service provider comment model.
	 *
	 * @param serviceProviderCommentModel the service provider comment model
	 * @return the service provider comment model
	 */
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
