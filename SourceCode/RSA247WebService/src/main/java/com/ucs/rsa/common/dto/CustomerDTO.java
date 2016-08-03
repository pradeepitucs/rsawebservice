package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "customer", namespace = "com.ucs.rsa.common.dto")

public class CustomerDTO extends UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String emailId;
	private String firstName;
	private String folderName;
	private String gcmId;
	private String lastName;
//	private CityDTO cityDTO;
//	private UserDTO userDTO;


	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFolderName() {
		return this.folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getGcmId() {
		return this.gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public CityDTO getCityModel() {
//		return this.cityDTO;
//	}
//
//	public void setCityModel(CityDTO cityDTO) {
//		this.cityDTO = cityDTO;
//	}
//
//	public UserDTO getUserModel() {
//		return this.userDTO;
//	}
//
//	public void setUserModel(UserDTO userDTO) {
//		this.userDTO = userDTO;
//	}

}