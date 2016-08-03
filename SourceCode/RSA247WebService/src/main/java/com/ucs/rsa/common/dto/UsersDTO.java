package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users", namespace = "com.ucs.rsa.common.dto")

public class UsersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<UserDTO> userDTOs;

	@XmlElement(name = "user")
	public List<UserDTO> getUserDTOs() {
		return userDTOs;
	}

	public void setUserDTOs(List<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}

}