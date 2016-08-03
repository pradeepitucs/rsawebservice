package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "user", namespace = "com.ucs.rsa.common.dto")

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;
	private boolean isEnabled;
	private long mobileNo;
//	private CustomerDTO customerModel;
//	private RoleDTO roleDTO;

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

//	public CustomerDTO getCustomerModel() {
//		return this.customerModel;
//	}
//
//	public void setCustomerModel(CustomerDTO customerModel) {
//		this.customerModel = customerModel;
//	}
//
//	public RoleDTO getRoleModel() {
//		return this.roleDTO;
//	}
//
//	public void setRoleModel(RoleDTO roleDTO) {
//		this.roleDTO = roleDTO;
//	}

}