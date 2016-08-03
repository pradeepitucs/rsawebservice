package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "roles", namespace = "com.ucs.rsa.common.dto")

public class RolesDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<RoleDTO> roleDTOs;

	@XmlElement(name = "role")
	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}

	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}

}