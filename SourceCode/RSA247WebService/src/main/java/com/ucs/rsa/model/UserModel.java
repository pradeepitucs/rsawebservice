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


/**
 * The persistent class for the user_t database table.
 * 
 */
@Entity
@Table(name="user_t", uniqueConstraints=
@UniqueConstraint(columnNames={"mobile_no", "role_id"}))
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name="UserModel.findAll", query="SELECT u FROM UserModel u")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", unique = true, insertable = true, updatable = false)
	private int userId;

	@Column(name="is_enabled")
	private boolean isEnabled;

	@Column(name="mobile_no")
	private long mobileNo;

//	//bi-directional one-to-one association to CustomerModel
//	@OneToOne(mappedBy="userModel")
//	private CustomerModel customerModel;
//
//	//bi-directional one-to-one association to ServiceProviderModel
//	@OneToOne(mappedBy="userModel")
//	private ServiceProviderModel serviceProviderModel;
	
	//bi-directional many-to-one association to RoleModel
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleModel roleModel;

	public UserModel() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public RoleModel getRoleModel() {
		return this.roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	
}