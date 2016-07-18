package com.ucs.rsa.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Transient;

public class BaseDomain implements Serializable {

	private static final long serialVersionUID = 1000L;

	private Long createdBy;
	
	private Timestamp createdDatetime;
	
	private Long updatedBy;
	
	private Timestamp updatedDatetime;

	@Transient
	private Integer versionNo = new Integer(0);

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public BaseDomain() {
		super();
	}

	public BaseDomain(Long createdBy, Date createdDatetime) {
		this.createdBy = createdBy;
		this.createdDatetime = createdDatetime == null ? null : new Timestamp(
				createdDatetime.getTime());
	}

	public BaseDomain(Long createdBy, Date createdDatetime, Long updatedBy,
			Date updatedDatetime) {
		this.createdBy = createdBy;
		this.createdDatetime = createdDatetime == null ? null : new Timestamp(
				createdDatetime.getTime());
		this.updatedBy = updatedBy;
		this.updatedDatetime = updatedDatetime == null ? null : new Timestamp(
				updatedDatetime.getTime());
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(Timestamp updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

}
