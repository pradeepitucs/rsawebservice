/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class RolesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "roles", namespace = "com.ucs.rsa.common.dto")

public class RolesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role DT os. */
	private List<RoleDTO> roleDTOs;

	/**
	 * Gets the role DT os.
	 *
	 * @return the role DT os
	 */
	@XmlElement(name = "role")
	public List<RoleDTO> getRoleDTOs()
	{
		return roleDTOs;
	}

	/**
	 * Sets the role DT os.
	 *
	 * @param roleDTOs
	 *           the new role DT os
	 */
	public void setRoleDTOs(List<RoleDTO> roleDTOs)
	{
		this.roleDTOs = roleDTOs;
	}

}
