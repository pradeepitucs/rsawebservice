package com.ucs.rsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer_t")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name")
	private String userFirstName;

	@Column(name = "last_name")
	private String userLastName;
	
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "city_id")
	private int city;
	
	@Column(name = "gcm_id")
	private String gcmId;
	
	@Column(name = "folder_name")
	private String folderName;

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getGcmId() {
		return gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@Override
	public String toString() {
		return "Customer [userFirstName=" + userFirstName + ", userLastName="
				+ userLastName + ", emailId=" + emailId + ", city=" + city+ ", gcmId=" + gcmId+ ", folderName =" + folderName+ "]" + super.toString();
	}
	
	
}
