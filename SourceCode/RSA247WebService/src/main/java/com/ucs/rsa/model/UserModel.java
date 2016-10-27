/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


// TODO: Auto-generated Javadoc
/**
 * The Class UserModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "user_t", uniqueConstraints = @UniqueConstraint(columnNames =
{ "mobile_no", "role_id" }))
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "UserModel.findAll", query = "SELECT u FROM UserModel u")
public class UserModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, insertable = true, updatable = false)
	private int userId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The mobile no. */
	@Column(name = "mobile_no")
	private long mobileNo;

	//	//bi-directional one-to-one association to CustomerModel
	//	@OneToOne(mappedBy="userModel")
	//	private CustomerModel customerModel;
	//
	//	//bi-directional one-to-one association to ServiceProviderModel
	//	@OneToOne(mappedBy="userModel")
	//	private ServiceProviderModel serviceProviderModel;

	/** The role model. */
	//bi-directional many-to-one association to RoleModel
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleModel roleModel;

	/**
	 * Instantiates a new user model.
	 */
	public UserModel()
	{
	}

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

	/**
	 * Gets the role model.
	 *
	 * @return the role model
	 */
	public RoleModel getRoleModel()
	{
		return this.roleModel;
	}

	/**
	 * Sets the role model.
	 *
	 * @param roleModel
	 *           the new role model
	 */
	public void setRoleModel(RoleModel roleModel)
	{
		this.roleModel = roleModel;
	}

}
