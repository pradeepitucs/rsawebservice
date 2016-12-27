package com.ucs.rsa.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class CustomerServiceRequestModel.
 */
@Entity
@Table(name="customer_service_request_t")
@NamedQuery(name="CustomerServiceRequestModel.findAll", query="SELECT u FROM CustomerServiceRequestModel u")
public class CustomerServiceRequestModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** The customer service request id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_service_request_id")
	private int customerServiceRequestID;
	
	/** The service type model. */
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;
	
	
	/** The vehicle service type id. */
	@Column(name="vehicle_service_type_id")
	private int vehicleServiceTypeID;

	/** The customer model. */
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerModel customerModel;
	
	/** The employee id. */
	@Column(name="employee_id")
	private int employeeID;
	
	/** The customer latitude. */
	@Column(name="customer_latitude")
	private double customerLatitude;
	
	/** The customer longitude. */
	@Column(name="customer_longitude")
	private double customerLongitude;
	
	/** The service price. */
	@Column(name="service_price")
	private double servicePrice;
	
	/** The extra service price. */
	@Column(name="extra_service_price")
	private double extraServicePrice;
	
	/** The request date. */
	@Column(name = "request_date")
	private Date requestDate;
	
	/** The request time. */
	@Column(name = "request_time")
	private Time requestTime;
	
	/** The service request status. */
	@Column(name = "service_request_status")
	private String serviceRequestStatus;

	/**
	 * Gets the vehicle service type id.
	 *
	 * @return the vehicle service type id
	 */
	public int getVehicleServiceTypeID() {
		return vehicleServiceTypeID;
	}

	/**
	 * Sets the vehicle service type id.
	 *
	 * @param vehicleServiceTypeID the new vehicle service type id
	 */
	public void setVehicleServiceTypeID(int vehicleServiceTypeID) {
		this.vehicleServiceTypeID = vehicleServiceTypeID;
	}

	/**
	 * Gets the customer service request id.
	 *
	 * @return the customer service request id
	 */
	public int getCustomerServiceRequestID() {
		return customerServiceRequestID;
	}

	/**
	 * Sets the customer service request id.
	 *
	 * @param customerServiceRequestID the new customer service request id
	 */
	public void setCustomerServiceRequestID(int customerServiceRequestID) {
		this.customerServiceRequestID = customerServiceRequestID;
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
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeID the new employee id
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	 * Gets the service price.
	 *
	 * @return the service price
	 */
	public double getServicePrice() {
		return servicePrice;
	}

	/**
	 * Sets the service price.
	 *
	 * @param servicePrice the new service price
	 */
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	/**
	 * Gets the extra service price.
	 *
	 * @return the extra service price
	 */
	public double getExtraServicePrice() {
		return extraServicePrice;
	}

	/**
	 * Sets the extra service price.
	 *
	 * @param extraServicePrice the new extra service price
	 */
	public void setExtraServicePrice(double extraServicePrice) {
		this.extraServicePrice = extraServicePrice;
	}

	/**
	 * Gets the request date.
	 *
	 * @return the request date
	 */
	public Date getRequestDate() {
		return requestDate;
	}

	/**
	 * Sets the request date.
	 *
	 * @param requestDate the new request date
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * Gets the request time.
	 *
	 * @return the request time
	 */
	public Time getRequestTime() {
		return requestTime;
	}

	/**
	 * Sets the request time.
	 *
	 * @param requestTime the new request time
	 */
	public void setRequestTime(Time requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * Gets the service request status.
	 *
	 * @return the service request status
	 */
	public String getServiceRequestStatus() {
		return serviceRequestStatus;
	}

	/**
	 * Sets the service request status.
	 *
	 * @param serviceRequestStatus the new service request status
	 */
	public void setServiceRequestStatus(String serviceRequestStatus) {
		this.serviceRequestStatus = serviceRequestStatus;
	}

}
