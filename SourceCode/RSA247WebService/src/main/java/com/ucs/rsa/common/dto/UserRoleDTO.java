package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "role", namespace = "com.ucs.rsa.common.dto")
public class UserRoleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int roleId;

	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public boolean equals(final Object arg0) {
		if (arg0 == null) {
			return false;
		}
		if (!(arg0 instanceof UserRoleDTO)) {
			return false;
		}
		UserRoleDTO arg1 = (UserRoleDTO) arg0;
		return (this.roleId == arg1.getRoleId())
				&& (arg1.getRoleName().equals(this.roleName));

	}

	@Override
	public int hashCode() {
		int code = 0;
		code += roleId;
		if (roleName != null) {
			code += roleName.hashCode();
		}
		return code;
	}

	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
