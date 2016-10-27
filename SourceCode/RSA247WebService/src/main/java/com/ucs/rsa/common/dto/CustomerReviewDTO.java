/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class CustomerReviewDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "customer_review", namespace = "com.ucs.rsa.dto")
public class CustomerReviewDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The customer review id. */
	private int customerReviewId;

	/** The approval status. */
	private int approvalStatus;

	/** The blocked. */
	private boolean blocked;

	/** The comment. */
	private String comment;

	/** The creation time. */
	private Date creationTime;

	/** The headline. */
	private String headline;

	/** The rating. */
	private float rating;

	/**
	 * Instantiates a new customer review DTO.
	 */
	public CustomerReviewDTO()
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

}
