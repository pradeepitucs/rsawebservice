package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer", namespace = "com.ucs.rsa.dto")
public class CustomerDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	private String userFirstName;
	private String userLastName;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@Override
	public String toString() {
		return "CustomerDTO [userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + "]" + super.toString();
	}

	
	
}
