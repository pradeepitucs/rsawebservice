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

@Entity
@Table(name = "service_provider_comment_t")
@NamedQuery(name = "ServiceProviderCommentModel.findAll", query = "SELECT u FROM ServiceProviderCommentModel u")
public class ServiceProviderCommentModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public ServiceProviderCommentModel() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "service_provider_comment_id")
	private int serviceProviderCommentID;
	
	@Column(name = "service_provider_comment")
	private String serviceProviderComment;
	
	@ManyToOne
	@JoinColumn(name="issue_id")
	private CustomerRequestModel customerRequestModel;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserModel userModel;

	public int getServiceProviderCommentID() {
		return serviceProviderCommentID;
	}

	public void setServiceProviderCommentID(int serviceProviderCommentID) {
		this.serviceProviderCommentID = serviceProviderCommentID;
	}

	public String getServiceProviderComment() {
		return serviceProviderComment;
	}

	public void setServiceProviderComment(String serviceProviderComment) {
		this.serviceProviderComment = serviceProviderComment;
	}

	public CustomerRequestModel getCustomerRequestModel() {
		return customerRequestModel;
	}

	public void setCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		this.customerRequestModel = customerRequestModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	@Override
	public String toString() {
		return "ServiceProviderCommentModel [serviceProviderCommentID=" + serviceProviderCommentID
				+ ",serviceProviderComment=" + serviceProviderComment + ",userModel="
				+ userModel + ",customerRequestModel="
						+ customerRequestModel + "]";
	}

}
