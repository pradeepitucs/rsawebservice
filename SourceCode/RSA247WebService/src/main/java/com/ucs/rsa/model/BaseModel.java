/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.NotAudited;



/**
 * The Class BaseModel.
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The created by. */
	@Column(name = "CREATEDBY", length = 100, nullable = false)
	@NotAudited
	private String createdBy;

	/** The created datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATEDDATETIME", nullable = false)
	@OrderBy(value = "desc")
	@NotAudited
	private Date createdDatetime;

	/** The updated by. */
	@Column(name = "UPDATEDBY", length = 100)
	private String updatedBy;

	/** The updated datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATEDDATETIME", nullable = false)
	private Date updatedDatetime;

	/** The version no. */
	@Column(name = "HIBVERSION")
	@Version
	@NotAudited
	private int versionNo;


	/**
	 * On create.
	 */
	@PrePersist
	protected void onCreate()
	{
		updatedDatetime = createdDatetime = new Date();
	}

	/**
	 * On update.
	 */
	@PreUpdate
	protected void onUpdate()
	{
		updatedDatetime = new Date();
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy
	 *           the new created by
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created datetime.
	 *
	 * @return the created datetime
	 */
	public Date getCreatedDatetime()
	{
		return createdDatetime;
	}

	/**
	 * Sets the created datetime.
	 *
	 * @param createdDatetime
	 *           the new created datetime
	 */
	public void setCreatedDatetime(Date createdDatetime)
	{
		this.createdDatetime = createdDatetime;
	}

	/**
	 * Gets the updated by.
	 *
	 * @return the updated by
	 */
	public String getUpdatedBy()
	{
		return updatedBy;
	}

	/**
	 * Sets the updated by.
	 *
	 * @param updatedBy
	 *           the new updated by
	 */
	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	/**
	 * Gets the updated datetime.
	 *
	 * @return the updated datetime
	 */
	public Date getUpdatedDatetime()
	{
		return updatedDatetime;
	}

	/**
	 * Sets the updated datetime.
	 *
	 * @param updatedDatetime
	 *           the new updated datetime
	 */
	public void setUpdatedDatetime(Date updatedDatetime)
	{
		this.updatedDatetime = updatedDatetime;
	}

	/**
	 * Gets the version no.
	 *
	 * @return the version no
	 */
	public int getVersionNo()
	{
		return versionNo;
	}

	/**
	 * Sets the version no.
	 *
	 * @param versionNo
	 *           the new version no
	 */
	public void setVersionNo(int versionNo)
	{
		this.versionNo = versionNo;
	}


}
