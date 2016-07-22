package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer", namespace = "com.ucs.rsa.dto")
public class CustomerDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	private String userFirstName;
	private String userLastName;
	private String emailId;
	private int city;
	private String gcmId;
	private String folderName;

	public int getCity() {
		return city;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setCity(int city) {
		this.city = city;
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
		return "CustomerDTO [userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", emailId=" + emailId + ", city=" + city+ ", gcmId=" + gcmId+ ", folderName =" + folderName+ "]" + super.toString();
	}

	
	
}
