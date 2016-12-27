package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.xml.bind.annotation.XmlRootElement;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.VehicleServiceTypeModel;


/**
 * The Class CustomerServiceRequestDTO.
 */
@XmlRootElement(name = "customer_request", namespace = "com.ucs.rsa.dto")
public class CustomerServiceRequestDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6325865187874911617L;

	/** The customer service request id. */
	private int customerServiceRequestId;

	/** The customer latitude. */
	private double customerLatitude;

	/** The customer longitude. */
	private double customerLongitude;

	/** The issue status. */
	private String serviceRequestedStatus;

	/** The service type model. */
	private ServiceTypeModel serviceTypeModel;

	/** The vehicle service type model. */
	private VehicleServiceTypeModel vehicleServiceTypeModel;

	/** The customer model. */
	private CustomerModel customerModel;

	/** The employee id. */
	private int employeeID;

	/** The service price. */
	private double servicePrice;

	/** The extra service price. */
	private double extraServicePrice;

	/** The request date. */
	private Date requestDate;

	/** The request time. */
	private Time requestTime;

	/**
	 * Gets the customer service request id.
	 *
	 * @return the customer service request id
	 */
	public int getCustomerServiceRequestId()
	{
		return customerServiceRequestId;
	}

	/**
	 * Sets the customer service request id.
	 *
	 * @param customerServiceRequestId
	 *           the new customer service request id
	 */
	public void setCustomerServiceRequestId(int customerServiceRequestId)
	{
		this.customerServiceRequestId = customerServiceRequestId;
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
	 * Gets the service requested status.
	 *
	 * @return the service requested status
	 */
	public String getServiceRequestedStatus()
	{
		return serviceRequestedStatus;
	}

	/**
	 * Sets the service requested status.
	 *
	 * @param serviceRequestedStatus
	 *           the new service requested status
	 */
	public void setServiceRequestedStatus(String serviceRequestedStatus)
	{
		this.serviceRequestedStatus = serviceRequestedStatus;
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
	 * Gets the vehicle service type model.
	 *
	 * @return the vehicle service type model
	 */
	public VehicleServiceTypeModel getVehicleServiceTypeModel()
	{
		return vehicleServiceTypeModel;
	}

	/**
	 * Sets the vehicle service type model.
	 *
	 * @param vehicleServiceTypeModel
	 *           the new vehicle service type model
	 */
	public void setVehicleServiceTypeModel(VehicleServiceTypeModel vehicleServiceTypeModel)
	{
		this.vehicleServiceTypeModel = vehicleServiceTypeModel;
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
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public int getEmployeeID()
	{
		return employeeID;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeID
	 *           the new employee id
	 */
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}

	/**
	 * Gets the service price.
	 *
	 * @return the service price
	 */
	public double getServicePrice()
	{
		return servicePrice;
	}

	/**
	 * Sets the service price.
	 *
	 * @param servicePrice
	 *           the new service price
	 */
	public void setServicePrice(double servicePrice)
	{
		this.servicePrice = servicePrice;
	}

	/**
	 * Gets the extra service price.
	 *
	 * @return the extra service price
	 */
	public double getExtraServicePrice()
	{
		return extraServicePrice;
	}

	/**
	 * Sets the extra service price.
	 *
	 * @param extraServicePrice
	 *           the new extra service price
	 */
	public void setExtraServicePrice(double extraServicePrice)
	{
		this.extraServicePrice = extraServicePrice;
	}

	/**
	 * Gets the request date.
	 *
	 * @return the request date
	 */
	public Date getRequestDate()
	{
		return requestDate;
	}

	/**
	 * Sets the request date.
	 *
	 * @param requestDate
	 *           the new request date
	 */
	public void setRequestDate(Date requestDate)
	{
		this.requestDate = requestDate;
	}

	/**
	 * Gets the request time.
	 *
	 * @return the request time
	 */
	public Time getRequestTime()
	{
		return requestTime;
	}

	/**
	 * Sets the request time.
	 *
	 * @param requestTime
	 *           the new request time
	 */
	public void setRequestTime(Time requestTime)
	{
		this.requestTime = requestTime;
	}

}
