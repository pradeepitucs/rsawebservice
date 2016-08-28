/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
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


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class CustomerRequestModel.
 */
@Entity
@Table(name = "customer_request_t")
@NamedQuery(name = "CustomerRequestModel.findAll", query = "SELECT u FROM CustomerRequestModel u")
public class CustomerRequestModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The issue id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	/**
	 * Gets the issue start time.
	 *
	 * @return the issue start time
	 */
	public Time getIssueStartTime()
	{
		return issueStartTime;
	}

	/**
	 * Sets the issue start time.
	 *
	 * @param issueStartTime
	 *           the new issue start time
	 */
	public void setIssueStartTime(Time issueStartTime)
	{
		this.issueStartTime = issueStartTime;
	}

	/** The service type model. */
	//bi-directional many-to-one association to ServiceTypeModel
	@ManyToOne
	@JoinColumn(name = "service_type_id")
	private ServiceTypeModel serviceTypeModel;

	/** The customer model. */
	//bi-directional many-to-one association to CustomerModel
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerModel customerModel;

	/** The employee model. */
	//bi-directional many-to-one association to ServiceProviderModel
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeModel employeeModel;

	/**
	 * Gets the employee model.
	 *
	 * @return the employee model
	 */
	public EmployeeModel getEmployeeModel()
	{
		return employeeModel;
	}

	/**
	 * Sets the employee model.
	 *
	 * @param employeeModel
	 *           the new employee model
	 */
	public void setEmployeeModel(EmployeeModel employeeModel)
	{
		this.employeeModel = employeeModel;
	}

	/** The customer review models. */
	// bi-directional many-to-one association to CustomerReviewModel
	@OneToMany(mappedBy = "customerRequestModel", fetch = FetchType.LAZY)
	private List<CustomerReviewModel> customerReviewModels;

	/**
	 * Instantiates a new customer request model.
	 */
	public CustomerRequestModel()
	{
	}

	/**
	 * Gets the issue id.
	 *
	 * @return the issue id
	 */
	public int getIssueId()
	{
		return issueId;
	}

	/**
	 * Sets the issue id.
	 *
	 * @param issueId
	 *           the new issue id
	 */
	public void setIssueId(int issueId)
	{
		this.issueId = issueId;
	}

	/**
	 * Gets the customer latitude.
	 *
	 * @return the customer latitude
	 */
	public double getCustomerLatitude()
	{
		return customerLatitude;
	}

	/**
	 * Sets the customer latitude.
	 *
	 * @param customerLatitude
	 *           the new customer latitude
	 */
	public void setCustomerLatitude(double customerLatitude)
	{
		this.customerLatitude = customerLatitude;
	}

	/**
	 * Gets the customer longitude.
	 *
	 * @return the customer longitude
	 */
	public double getCustomerLongitude()
	{
		return customerLongitude;
	}

	/**
	 * Sets the customer longitude.
	 *
	 * @param customerLongitude
	 *           the new customer longitude
	 */
	public void setCustomerLongitude(double customerLongitude)
	{
		this.customerLongitude = customerLongitude;
	}

	/**
	 * Gets the issue status.
	 *
	 * @return the issue status
	 */
	public String getIssueStatus()
	{
		return issueStatus;
	}

	/**
	 * Sets the issue status.
	 *
	 * @param issueStatus
	 *           the new issue status
	 */
	public void setIssueStatus(String issueStatus)
	{
		this.issueStatus = issueStatus;
	}

	/**
	 * Gets the service type model.
	 *
	 * @return the service type model
	 */
	public ServiceTypeModel getServiceTypeModel()
	{
		return serviceTypeModel;
	}

	/**
	 * Sets the service type model.
	 *
	 * @param serviceTypeModel
	 *           the new service type model
	 */
	public void setServiceTypeModel(ServiceTypeModel serviceTypeModel)
	{
		this.serviceTypeModel = serviceTypeModel;
	}

	/**
	 * Gets the customer model.
	 *
	 * @return the customer model
	 */
	public CustomerModel getCustomerModel()
	{
		return customerModel;
	}

	/**
	 * Sets the customer model.
	 *
	 * @param customerModel
	 *           the new customer model
	 */
	public void setCustomerModel(CustomerModel customerModel)
	{
		this.customerModel = customerModel;
	}

	/**
	 * Gets the customer review models.
	 *
	 * @return the customer review models
	 */
	public List<CustomerReviewModel> getCustomerReviewModels()
	{
		return customerReviewModels;
	}

	/**
	 * Sets the customer review models.
	 *
	 * @param customerReviewModels
	 *           the new customer review models
	 */
	public void setCustomerReviewModels(List<CustomerReviewModel> customerReviewModels)
	{
		this.customerReviewModels = customerReviewModels;
	}

	/**
	 * Adds the customer review model.
	 *
	 * @param customerReviewModel
	 *           the customer review model
	 * @return the customer review model
	 */
	public CustomerReviewModel addCustomerReviewModel(CustomerReviewModel customerReviewModel)
	{
		getCustomerReviewModels().add(customerReviewModel);
		customerReviewModel.setCustomerRequestModel(this);
		return customerReviewModel;
	}

	/**
	 * Removes the customer review model.
	 *
	 * @param customerReviewModel
	 *           the customer review model
	 * @return the customer review model
	 */
	public CustomerReviewModel removeCustomerReviewModel(CustomerReviewModel customerReviewModel)
	{
		getCustomerReviewModels().remove(customerReviewModel);
		customerReviewModel.setCustomerRequestModel(null);
		return customerReviewModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CustomerRequestModel [ issueId=" + issueId + ", issueStatus=" + issueStatus + ", issueStartTime=" + issueStartTime
				+ ", customerLatitude=" + customerLatitude + ", customerLongitude =" + customerLongitude + ", employeeModel="
				+ employeeModel + ", customerModel=" + customerModel + ", serviceTypeModel=" + serviceTypeModel + "]"
				+ super.toString();
	}

}
