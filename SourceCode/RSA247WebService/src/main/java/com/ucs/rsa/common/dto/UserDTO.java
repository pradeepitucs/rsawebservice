package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user", namespace = "com.ucs.rsa.dto")
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 6325865187874911617L;

	private int userId;
	
	private int mobileNo;
	private int roleId;
	private boolean isEnabled;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", mobileNo=" + mobileNo
				+ ", roleId=" + roleId + ", isEnabled=" + isEnabled + "]";
	}
	
}
