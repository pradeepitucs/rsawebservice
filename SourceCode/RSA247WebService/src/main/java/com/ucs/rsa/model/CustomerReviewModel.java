/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The Class CustomerReviewModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "customer_review_t")
@NamedQuery(name = "CustomerReviewModel.findAll", query = "SELECT c FROM CustomerReviewModel c")
public class CustomerReviewModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The customer review id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_review_id")
	private int customerReviewId;

	/** The approval status. */
	@Column(name = "approval_status")
	private int approvalStatus;

	/** The blocked. */
	private boolean blocked;

	/** The comment. */
	@Lob
	private String comment;

	/** The creation time. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time")
	private Date creationTime;

	/** The headline. */
	private String headline;

	/** The rating. */
	private float rating;

	/** The modification. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date modification;

	/** The service provider model. */
	// bi-directional many-to-one association to ServiceProviderModel
	@ManyToOne
	@JoinColumn(name = "service_provider_id")
	private ServiceProviderModel serviceProviderModel;

	/** The customer model. */
	// bi-directional many-to-one association to CustomerT
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerModel customerModel;

	/** The employee model. */
	// bi-directional many-to-one association to ServiceProviderT
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeModel employeeModel;

	/** The customer request model. */
	// bi-directional many-to-one association to ServiceProviderT
	@ManyToOne
	@JoinColumn(name = "issueId")
	private CustomerRequestModel customerRequestModel;

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

	/**
	 * Instantiates a new customer review model.
	 */
	public CustomerReviewModel()
	{
	}

	/**
	 * Gets the customer review id.
	 *
	 * @return the customer review id
	 */
	public int getCustomerReviewId()
	{
		return customerReviewId;
	}

	/**
	 * Sets the customer review id.
	 *
	 * @param customerReviewId
	 *           the new customer review id
	 */
	public void setCustomerReviewId(int customerReviewId)
	{
		this.customerReviewId = customerReviewId;
	}

	/**
	 * Gets the approval status.
	 *
	 * @return the approval status
	 */
	public int getApprovalStatus()
	{
		return approvalStatus;
	}

	/**
	 * Sets the approval status.
	 *
	 * @param approvalStatus
	 *           the new approval status
	 */
	public void setApprovalStatus(int approvalStatus)
	{
		this.approvalStatus = approvalStatus;
	}

	/**
	 * Gets the blocked.
	 *
	 * @return the blocked
	 */
	public boolean getBlocked()
	{
		return blocked;
	}

	/**
	 * Sets the blocked.
	 *
	 * @param blocked
	 *           the new blocked
	 */
	public void setBlocked(boolean blocked)
	{
		this.blocked = blocked;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment
	 *           the new comment
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}

	/**
	 * Gets the creation time.
	 *
	 * @return the creation time
	 */
	public Date getCreationTime()
	{
		return creationTime;
	}

	/**
	 * Sets the creation time.
	 *
	 * @param creationTime
	 *           the new creation time
	 */
	public void setCreationTime(Date creationTime)
	{
		this.creationTime = creationTime;
	}

	/**
	 * Gets the headline.
	 *
	 * @return the headline
	 */
	public String getHeadline()
	{
		return headline;
	}

	/**
	 * Sets the headline.
	 *
	 * @param headline
	 *           the new headline
	 */
	public void setHeadline(String headline)
	{
		this.headline = headline;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public float getRating()
	{
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating
	 *           the new rating
	 */
	public void setRating(float rating)
	{
		this.rating = rating;
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
	 * Gets the customer request model.
	 *
	 * @return the customer request model
	 */
	public CustomerRequestModel getCustomerRequestModel()
	{
		return customerRequestModel;
	}

	/**
	 * Sets the customer request model.
	 *
	 * @param customerRequestModel
	 *           the new customer request model
	 */
	public void setCustomerRequestModel(CustomerRequestModel customerRequestModel)
	{
		this.customerRequestModel = customerRequestModel;
	}

	/**
	 * Gets the modification.
	 *
	 * @return the modification
	 */
	public Date getModification()
	{
		return modification;
	}

	/**
	 * Sets the modification.
	 *
	 * @param modification
	 *           the new modification
	 */
	public void setModification(Date modification)
	{
		this.modification = modification;
	}

	/**
	 * Gets the service provider model.
	 *
	 * @return the service provider model
	 */
	public ServiceProviderModel getServiceProviderModel()
	{
		return serviceProviderModel;
	}

	/**
	 * Sets the service provider model.
	 *
	 * @param serviceProviderModel
	 *           the new service provider model
	 */
	public void setServiceProviderModel(ServiceProviderModel serviceProviderModel)
	{
		this.serviceProviderModel = serviceProviderModel;
	}

}
