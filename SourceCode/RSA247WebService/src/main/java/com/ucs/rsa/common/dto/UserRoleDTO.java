/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class UserRoleDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "role", namespace = "com.ucs.rsa.common.dto")
public class UserRoleDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role id. */
	private int roleId;

	/** The role name. */
	private String roleName;

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public int getRoleId()
	{
		return roleId;
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
		return roleName;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object arg0)
	{
		if (arg0 == null)
		{
			return false;
		}
		if (!(arg0 instanceof UserRoleDTO))
		{
			return false;
		}
		UserRoleDTO arg1 = (UserRoleDTO) arg0;
		return (this.roleId == arg1.getRoleId()) && (arg1.getRoleName().equals(this.roleName));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		int code = 0;
		code += roleId;
		if (roleName != null)
		{
			code += roleName.hashCode();
		}
		return code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RoleDTO [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
