package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "roles", namespace = "com.ucs.rsa.common.dto")
public class UserRolesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RoleDTO> userRole;

	public List<RoleDTO> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<RoleDTO> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRolesDTO [userRole=" + userRole + "]";
	}

}
