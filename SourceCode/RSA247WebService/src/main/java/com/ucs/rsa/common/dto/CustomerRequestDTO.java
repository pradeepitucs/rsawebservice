/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.xml.bind.annotation.XmlRootElement;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceTypeModel;


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
	
	private Time issueStartTime;
	
	private String customerVehicleNumber;
	
	private Date issueDate;
	
	private Time issueTime;
	
	private ServiceTypeDTO serviceTypeModel;

	private CustomerDTO customerModel;

	private int employeeID;


	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public ServiceTypeDTO getServiceTypeModel() {
		return serviceTypeModel;
	}

	public void setServiceTypeModel(ServiceTypeDTO serviceTypeModel) {
		this.serviceTypeModel = serviceTypeModel;
	}

	public CustomerDTO getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerDTO customerModel) {
		this.customerModel = customerModel;
	}

	public Time getIssueStartTime() {
		return issueStartTime;
	}

	public void setIssueStartTime(Time issueStartTime) {
		this.issueStartTime = issueStartTime;
	}

	public String getCustomerVehicleNumber() {
		return customerVehicleNumber;
	}

	public void setCustomerVehicleNumber(String customerVehicleNumber) {
		this.customerVehicleNumber = customerVehicleNumber;
	}

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
