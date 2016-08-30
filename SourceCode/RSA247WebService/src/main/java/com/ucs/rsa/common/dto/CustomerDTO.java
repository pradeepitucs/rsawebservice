/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class CustomerDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "customer", namespace = "com.ucs.rsa.common.dto")

public class CustomerDTO extends UserDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The email id. */
	private String emailId;

	/** The first name. */
	private String firstName;

	/** The folder name. */
	private String folderName;

	/** The gcm id. */
	private String gcmId;

	/** The last name. */
	private String lastName;
	//	private CityDTO cityDTO;
	//	private UserDTO userDTO;


	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId()
	{
		return this.emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId
	 *           the new email id
	 */
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return this.firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *           the new first name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Gets the folder name.
	 *
	 * @return the folder name
	 */
	public String getFolderName()
	{
		return this.folderName;
	}

	/**
	 * Sets the folder name.
	 *
	 * @param folderName
	 *           the new folder name
	 */
	public void setFolderName(String folderName)
	{
		this.folderName = folderName;
	}

	/**
	 * Gets the gcm id.
	 *
	 * @return the gcm id
	 */
	public String getGcmId()
	{
		return this.gcmId;
	}

	/**
	 * Sets the gcm id.
	 *
	 * @param gcmId
	 *           the new gcm id
	 */
	public void setGcmId(String gcmId)
	{
		this.gcmId = gcmId;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return this.lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *           the new last name
	 */
	public void setLastName(String lastName)
	{
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
