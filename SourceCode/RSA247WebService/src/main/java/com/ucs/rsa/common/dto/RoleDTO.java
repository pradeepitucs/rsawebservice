package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "role", namespace = "com.ucs.rsa.common.dto")

public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int roleId;
	private String roleName;
//	private List<UserDTO> userDTOs;


	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

//	public List<UserDTO> getUserModels() {
//		return this.userDTOs;
//	}
//
//	public void setUserModels(List<UserDTO> userDTOs) {
//		this.userDTOs = userDTOs;
//	}

}