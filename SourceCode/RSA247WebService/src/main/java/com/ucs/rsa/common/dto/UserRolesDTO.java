package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "roles", namespace = "com.ucs.rsa.common.dto")
public class UserRolesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UserRoleDTO> userRole;

	public List<UserRoleDTO> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRoleDTO> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRolesDTO [userRole=" + userRole + "]";
	}

}
