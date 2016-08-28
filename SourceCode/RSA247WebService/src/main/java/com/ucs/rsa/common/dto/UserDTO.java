/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class UserDTO.
 */
@XmlRootElement(name = "user", namespace = "com.ucs.rsa.common.dto")

public class UserDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	private int userId;

	/** The is enabled. */
	private boolean isEnabled;

	/** The mobile no. */
	private long mobileNo;
	//	private CustomerDTO customerModel;
	//	private RoleDTO roleDTO;

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId()
	{
		return this.userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *           the new user id
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * Gets the checks if is enabled.
	 *
	 * @return the checks if is enabled
	 */
	public boolean getIsEnabled()
	{
		return this.isEnabled;
	}

	/**
	 * Sets the checks if is enabled.
	 *
	 * @param isEnabled
	 *           the new checks if is enabled
	 */
	public void setIsEnabled(boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public long getMobileNo()
	{
		return this.mobileNo;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo
	 *           the new mobile no
	 */
	public void setMobileNo(long mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	//	public CustomerDTO getCustomerModel() {
	//		return this.customerModel;
	//	}
	//
	//	public void setCustomerModel(CustomerDTO customerModel) {
	//		this.customerModel = customerModel;
	//	}
	//
	//	public RoleDTO getRoleModel() {
	//		return this.roleDTO;
	//	}
	//
	//	public void setRoleModel(RoleDTO roleDTO) {
	//		this.roleDTO = roleDTO;
	//	}

}
