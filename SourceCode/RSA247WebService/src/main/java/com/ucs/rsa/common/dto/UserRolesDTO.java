/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class UserRolesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "roles", namespace = "com.ucs.rsa.common.dto")
public class UserRolesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user role. */
	private List<UserRoleDTO> userRole;

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public List<UserRoleDTO> getUserRole()
	{
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole
	 *           the new user role
	 */
	public void setUserRole(List<UserRoleDTO> userRole)
	{
		this.userRole = userRole;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UserRolesDTO [userRole=" + userRole + "]";
	}

}
