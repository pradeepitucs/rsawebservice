package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users", namespace = "com.ucs.rsa.common.dto")
public class UsersDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<UserDTO> usersDTO;

	public List<UserDTO> getUsersDTO() {
		return usersDTO;
	}

	public void setUsersDTO(List<UserDTO> usersDTO) {
		this.usersDTO = usersDTO;
	}

	@Override
	public String toString() {
		return "UsersDTO [usersDTO=" + usersDTO + "]";
	}

}
