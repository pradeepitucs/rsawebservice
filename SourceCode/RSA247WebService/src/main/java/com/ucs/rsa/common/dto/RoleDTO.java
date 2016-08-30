/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class RoleDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "role", namespace = "com.ucs.rsa.common.dto")

public class RoleDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role id. */
	private int roleId;

	/** The role name. */
	private String roleName;
	//	private List<UserDTO> userDTOs;


	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public int getRoleId()
	{
		return this.roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId
	 *           the new role id
	 */
	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName()
	{
		return this.roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName
	 *           the new role name
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	//	public List<UserDTO> getUserModels() {
	//		return this.userDTOs;
	//	}
	//
	//	public void setUserModels(List<UserDTO> userDTOs) {
	//		this.userDTOs = userDTOs;
	//	}

}
