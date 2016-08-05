package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer_review", namespace = "com.ucs.rsa.dto")
public class CustomerReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int customerReviewId;
	private int approvalStatus;

	private boolean blocked;

	private byte[] comment;

	private Date creationTime;

	private String headline;

	private float rating;

	public CustomerReviewDTO() {
	}

	public int getCustomerReviewId() {
		return customerReviewId;
	}

	public void setCustomerReviewId(int customerReviewId) {
		this.customerReviewId = customerReviewId;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public byte[] getComment() {
		return comment;
	}

	public void setComment(byte[] comment) {
		this.comment = comment;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}