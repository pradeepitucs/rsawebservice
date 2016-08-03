package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the customer_t database table.
 * 
 */
@Entity
@Table(name = "customer_t")
@PrimaryKeyJoinColumn(name = "user_id")
@NamedQuery(name = "CustomerModel.findAll", query = "SELECT c FROM CustomerModel c")
public class CustomerModel extends UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "folder_name")
	private String folderName;

	@Column(name = "gcm_id")
	private String gcmId;

	@Column(name = "last_name")
	private String lastName;

	// bi-directional many-to-one association to CityModel
	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityModel cityModel;

	public CustomerModel() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFolderName() {
		return this.folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getGcmId() {
		return this.gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CityModel getCityModel() {
		return this.cityModel;
	}

	public void setCityModel(CityModel cityModel) {
		this.cityModel = cityModel;
	}

	@Override
	public String toString() {
		return "CustomerModel [emailId=" + emailId + ", firstName=" + firstName + ", folderName=" + folderName
				+ ", gcmId=" + gcmId + ", lastName=" + lastName + ", cityModel=" + cityModel + "]";
	}

}