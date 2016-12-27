/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * The Class UserDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
//@XmlRootElement(name = "base", namespace = "com.ucs.rsa.common.dto")
public class BaseDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The created by. */
	private String createdBy;

	/** The created datetime. */
	private Date createdDatetime;

	/** The updated by. */
	private String updatedBy;

	/** The updated datetime. */
	private Date updatedDatetime;

	/** The version no. */
	private int versionNo;

	/**
	 * Gets the created by.
	 *
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy
	 *           the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created datetime.
	 *
	 * @return the createdDatetime
	 */
	public Date getCreatedDatetime()
	{
		return createdDatetime;
	}

	/**
	 * Sets the created datetime.
	 *
	 * @param createdDatetime
	 *           the createdDatetime to set
	 */
	public void setCreatedDatetime(Date createdDatetime)
	{
		this.createdDatetime = createdDatetime;
	}

	/**
	 * Gets the updated by.
	 *
	 * @return the updatedBy
	 */
	public String getUpdatedBy()
	{
		return updatedBy;
	}

	/**
	 * Sets the updated by.
	 *
	 * @param updatedBy
	 *           the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	/**
	 * Gets the updated datetime.
	 *
	 * @return the updatedDatetime
	 */
	public Date getUpdatedDatetime()
	{
		return updatedDatetime;
	}

	/**
	 * Sets the updated datetime.
	 *
	 * @param updatedDatetime
	 *           the updatedDatetime to set
	 */
	public void setUpdatedDatetime(Date updatedDatetime)
	{
		this.updatedDatetime = updatedDatetime;
	}

	/**
	 * Gets the version no.
	 *
	 * @return the versionNo
	 */
	public int getVersionNo()
	{
		return versionNo;
	}

	/**
	 * Sets the version no.
	 *
	 * @param versionNo
	 *           the versionNo to set
	 */
	public void setVersionNo(int versionNo)
	{
		this.versionNo = versionNo;
	}



}
