/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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


/**
 * The Class EmployeeModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "service_provider_employee_t")
@PrimaryKeyJoinColumn(name = "userId")
@NamedQuery(name = "EmployeeModel.findAll", query = "SELECT c FROM EmployeeModel c")
public class EmployeeModel extends UserModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee name. */
	@Column(name = "employee_name")
	private String employeeName;

	/** The employee email. */
	@Column(name = "employee_email")
	private String employeeEmail;

	/** The is onwer. */
	@Column(name = "is_owner")
	private boolean isOnwer;

	/** The service provider ID. */
	@Column(name = "service_provider_id")
	private int serviceProviderID;

	/** The older employee ID. */
	@Column(name = "older_employee_id")
	private int olderEmployeeID;

	/** The gcm id. */
	@Column(name = "gcm_id")
	private String gcmId;

	/** The is send arroval notification. */
	@Column(name = "is_send_approval_notification")
	private boolean isSendArrovalNotification;

	/** The customer request models. */
	// bi-directional many-to-one association to CustomerRequestModel
	@OneToMany(mappedBy = "employeeModel", fetch = FetchType.LAZY)
	private List<CustomerRequestModel> customerRequestModels;

	/** The customer review models. */
	// bi-directional many-to-one association to CustomerReviewModel
	@OneToMany(mappedBy = "employeeModel", fetch = FetchType.LAZY)
	private List<CustomerReviewModel> customerReviewModels;

	/**
	 * Checks if is send arroval notification.
	 *
	 * @return true, if is send arroval notification
	 */
	public boolean isSendArrovalNotification()
	{
		return isSendArrovalNotification;
	}

	/**
	 * Sets the send arroval notification.
	 *
	 * @param isSendArrovalNotification
	 *           the new send arroval notification
	 */
	public void setSendArrovalNotification(boolean isSendArrovalNotification)
	{
		this.isSendArrovalNotification = isSendArrovalNotification;
	}

	/**
	 * Gets the employee name.
	 *
	 * @return the employee name
	 */
	public String getEmployeeName()
	{
		return employeeName;
	}

	/**
	 * Sets the employee name.
	 *
	 * @param employeeName
	 *           the new employee name
	 */
	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}

	/**
	 * Gets the employee email.
	 *
	 * @return the employee email
	 */
	public String getEmployeeEmail()
	{
		return employeeEmail;
	}

	/**
	 * Sets the employee email.
	 *
	 * @param employeeEmail
	 *           the new employee email
	 */
	public void setEmployeeEmail(String employeeEmail)
	{
		this.employeeEmail = employeeEmail;
	}

	/**
	 * Checks if is onwer.
	 *
	 * @return true, if is onwer
	 */
	public boolean isOnwer()
	{
		return isOnwer;
	}

	/**
	 * Sets the onwer.
	 *
	 * @param isOnwer
	 *           the new onwer
	 */
	public void setOnwer(boolean isOnwer)
	{
		this.isOnwer = isOnwer;
	}

	/**
	 * Gets the service provider ID.
	 *
	 * @return the service provider ID
	 */
	public int getServiceProviderID()
	{
		return serviceProviderID;
	}

	/**
	 * Sets the service provider ID.
	 *
	 * @param serviceProviderID
	 *           the new service provider ID
	 */
	public void setServiceProviderID(int serviceProviderID)
	{
		this.serviceProviderID = serviceProviderID;
	}

	/**
	 * Gets the older employee ID.
	 *
	 * @return the older employee ID
	 */
	public int getOlderEmployeeID()
	{
		return olderEmployeeID;
	}

	/**
	 * Sets the older employee ID.
	 *
	 * @param olderEmployeeID
	 *           the new older employee ID
	 */
	public void setOlderEmployeeID(int olderEmployeeID)
	{
		this.olderEmployeeID = olderEmployeeID;
	}

	/**
	 * Gets the gcm id.
	 *
	 * @return the gcm id
	 */
	public String getGcmId()
	{
		return gcmId;
	}

	/**
	 * Sets the gcm id.
	 *
	 * @param gcmId
	 *           the new gcm id
	 */
	public void setGcmId(String gcmId)
	{
		this.gcmId = gcmId;
	}

	/**
	 * Adds the customer request model.
	 *
	 * @param customerRequestModel
	 *           the customer request model
	 * @return the customer request model
	 */
	public CustomerRequestModel addCustomerRequestModel(CustomerRequestModel customerRequestModel)
	{
		getCustomerRequestModels().add(customerRequestModel);
		customerRequestModel.setEmployeeModel(this);
		return customerRequestModel;
	}

	/**
	 * Removes the customer request model.
	 *
	 * @param customerRequestModel
	 *           the customer request model
	 * @return the customer request model
	 */
	public CustomerRequestModel removeCustomerRequestModel(CustomerRequestModel customerRequestModel)
	{
		getCustomerRequestModels().remove(customerRequestModel);
		customerRequestModel.setEmployeeModel(null);
		return customerRequestModel;
	}

	/**
	 * Gets the customer request models.
	 *
	 * @return the customer request models
	 */
	public List<CustomerRequestModel> getCustomerRequestModels()
	{
		return customerRequestModels;
	}

	/**
	 * Sets the customer request models.
	 *
	 * @param customerRequestModels
	 *           the new customer request models
	 */
	public void setCustomerRequestModels(List<CustomerRequestModel> customerRequestModels)
	{
		this.customerRequestModels = customerRequestModels;
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
		customerReviewModel.setEmployeeModel(this);
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
		customerReviewModel.setEmployeeModel(null);
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
		return "ServiceProviderEmployee [ employeeName=" + employeeName + ", employeeEmail=" + employeeEmail
				+ ", serviceProviderID=" + serviceProviderID + ", isSendArrovalNotification=" + isSendArrovalNotification
				+ ", isOnwer =" + isOnwer + ", gcmId=" + gcmId + ", olderEmployeeID=" + olderEmployeeID + "]" + super.toString();
	}

}
