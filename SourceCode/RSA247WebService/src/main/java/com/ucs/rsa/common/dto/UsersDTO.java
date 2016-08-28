/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class UsersDTO.
 */
@XmlRootElement(name = "users", namespace = "com.ucs.rsa.common.dto")

public class UsersDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The user DT os. */
	private List<UserDTO> userDTOs;

	/**
	 * Gets the user DT os.
	 *
	 * @return the user DT os
	 */
	@XmlElement(name = "user")
	public List<UserDTO> getUserDTOs()
	{
		return userDTOs;
	}

	/**
	 * Sets the user DT os.
	 *
	 * @param userDTOs
	 *           the new user DT os
	 */
	public void setUserDTOs(List<UserDTO> userDTOs)
	{
		this.userDTOs = userDTOs;
	}

}
