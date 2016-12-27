/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * The Class CustomerRequestDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "customer_request", namespace = "com.ucs.rsa.dto")
public class CustomerRequestDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6325865187874911617L;

	/** The issue id. */
	private int issueId;

	/** The customer latitude. */
	private double customerLatitude;

	/** The customer longitude. */
	private double customerLongitude;

	/** The issue status. */
	private String issueStatus;

	/** The issue start time. */
	private Time issueStartTime;

	/** The customer vehicle number. */
	private String customerVehicleNumber;

	/** The issue date. */
	private Date issueDate;

	/** The issue time. */
	private Time issueTime;

	/** The service type model. */
	private ServiceTypeDTO serviceTypeModel;

	/** The customer model. */
	private CustomerDTO customerModel;

	/** The employee ID. */
	private int employeeID;


	/**
	 * Gets the employee ID.
	 *
	 * @return the employee ID
	 */
	public int getEmployeeID()
	{
		return employeeID;
	}

	/**
	 * Sets the employee ID.
	 *
	 * @param employeeID
	 *           the new employee ID
	 */
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}

	/**
	 * Gets the service type model.
	 *
	 * @return the service type model
	 */
	public ServiceTypeDTO getServiceTypeModel()
	{
		return serviceTypeModel;
	}

	/**
	 * Sets the service type model.
	 *
	 * @param serviceTypeModel
	 *           the new service type model
	 */
	public void setServiceTypeModel(ServiceTypeDTO serviceTypeModel)
	{
		this.serviceTypeModel = serviceTypeModel;
	}

	/**
	 * Gets the customer model.
	 *
	 * @return the customer model
	 */
	public CustomerDTO getCustomerModel()
	{
		return customerModel;
	}

	/**
	 * Sets the customer model.
	 *
	 * @param customerModel
	 *           the new customer model
	 */
	public void setCustomerModel(CustomerDTO customerModel)
	{
		this.customerModel = customerModel;
	}

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

	/**
	 * Gets the customer vehicle number.
	 *
	 * @return the customer vehicle number
	 */
	public String getCustomerVehicleNumber()
	{
		return customerVehicleNumber;
	}

	/**
	 * Sets the customer vehicle number.
	 *
	 * @param customerVehicleNumber
	 *           the new customer vehicle number
	 */
	public void setCustomerVehicleNumber(String customerVehicleNumber)
	{
		this.customerVehicleNumber = customerVehicleNumber;
	}

	/**
	 * Gets the issue date.
	 *
	 * @return the issue date
	 */
	public Date getIssueDate()
	{
		return issueDate;
	}

	/**
	 * Sets the issue date.
	 *
	 * @param issueDate
	 *           the new issue date
	 */
	public void setIssueDate(Date issueDate)
	{
		this.issueDate = issueDate;
	}

	/**
	 * Gets the issue time.
	 *
	 * @return the issue time
	 */
	public Time getIssueTime()
	{
		return issueTime;
	}

	/**
	 * Sets the issue time.
	 *
	 * @param issueTime
	 *           the new issue time
	 */
	public void setIssueTime(Time issueTime)
	{
		this.issueTime = issueTime;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CustomerRequest [issueId=" + issueId + ", customerLatitude=" + customerLatitude + ", customerLongitude="
				+ customerLongitude + " issueStatus=" + issueStatus + "]";
	}

}
