package com.ucs.rsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer_t")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name")
	private String userFirstName;

	@Column(name = "last_name")
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
		return "Customer [userFirstName=" + userFirstName + ", userLastName="
				+ userLastName + "]" + super.toString();
	}
	
	
}
