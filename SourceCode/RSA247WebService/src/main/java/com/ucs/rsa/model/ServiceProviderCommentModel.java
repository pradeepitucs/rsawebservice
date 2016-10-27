/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceProviderCommentModel.
 */
@Entity
@Table(name = "service_provider_comment_t")
@NamedQuery(name = "ServiceProviderCommentModel.findAll", query = "SELECT u FROM ServiceProviderCommentModel u")
public class ServiceProviderCommentModel implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new service provider comment model.
	 */
	public ServiceProviderCommentModel() {
		
	}
	
	/** The service provider comment ID. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "service_provider_comment_id")
	private int serviceProviderCommentID;
	
	/** The service provider comment. */
	@Column(name = "service_provider_comment")
	private String serviceProviderComment;
	
	/** The customer request model. */
	@ManyToOne
	@JoinColumn(name="issue_id")
	private CustomerRequestModel customerRequestModel;
	
	/** The user model. */
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserModel userModel;

	/**
	 * Gets the service provider comment ID.
	 *
	 * @return the service provider comment ID
	 */
	public int getServiceProviderCommentID() {
		return serviceProviderCommentID;
	}

	/**
	 * Sets the service provider comment ID.
	 *
	 * @param serviceProviderCommentID the new service provider comment ID
	 */
	public void setServiceProviderCommentID(int serviceProviderCommentID) {
		this.serviceProviderCommentID = serviceProviderCommentID;
	}

	/**
	 * Gets the service provider comment.
	 *
	 * @return the service provider comment
	 */
	public String getServiceProviderComment() {
		return serviceProviderComment;
	}

	/**
	 * Sets the service provider comment.
	 *
	 * @param serviceProviderComment the new service provider comment
	 */
	public void setServiceProviderComment(String serviceProviderComment) {
		this.serviceProviderComment = serviceProviderComment;
	}

	/**
	 * Gets the customer request model.
	 *
	 * @return the customer request model
	 */
	public CustomerRequestModel getCustomerRequestModel() {
		return customerRequestModel;
	}

	/**
	 * Sets the customer request model.
	 *
	 * @param customerRequestModel the new customer request model
	 */
	public void setCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		this.customerRequestModel = customerRequestModel;
	}

	/**
	 * Gets the user model.
	 *
	 * @return the user model
	 */
	public UserModel getUserModel() {
		return userModel;
	}

	/**
	 * Sets the user model.
	 *
	 * @param userModel the new user model
	 */
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceProviderCommentModel [serviceProviderCommentID=" + serviceProviderCommentID
				+ ",serviceProviderComment=" + serviceProviderComment + ",userModel="
				+ userModel + ",customerRequestModel="
						+ customerRequestModel + "]";
	}

}
