/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class EmployeeDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "employee", namespace = "com.ucs.rsa.dto")
public class EmployeeDTO extends UserDTO
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee name. */
	private String employeeName;

	/** The employee email. */
	private String employeeEmail;

	/** The is onwer. */
	private boolean onwer;

	/** The service provider ID. */
	private int serviceProviderID;

	/** The older employee ID. */
	private int olderEmployeeID;

	/** The gcm id. */
	private String gcmId;

	/** The is send arroval notification. */
	private boolean isSendArrovalNotification;

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
	public boolean getOnwer()
	{
		return onwer;
	}

	/**
	 * Sets the onwer.
	 *
	 * @param isOnwer
	 *           the new onwer
	 */
	public void setOnwer(boolean onwer)
	{
		this.onwer = onwer;
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
				+ ", Onwer =" + onwer + ", gcmId=" + gcmId + ", olderEmployeeID=" + olderEmployeeID + "]" + super.toString();
	}

}
