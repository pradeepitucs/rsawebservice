package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	
	@Column(name = "is_member")
	private boolean isMember;

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

	// bi-directional many-to-one association to CustomerRequestModel
	@OneToMany(mappedBy = "customerModel", fetch = FetchType.LAZY)
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<CustomerRequestModel> customerRequestModels;
	
	@OneToMany(mappedBy = "customerModel", fetch = FetchType.LAZY)
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<CustomerPaymentModel> customerPaymentModel;

	public List<CustomerPaymentModel> getCustomerPaymentModel() {
		return customerPaymentModel;
	}

	public void setCustomerPaymentModel(List<CustomerPaymentModel> customerPaymentModel) {
		this.customerPaymentModel = customerPaymentModel;
	}

	// bi-directional many-to-one association to CustomerReviewModel
	@OneToMany(mappedBy = "customerModel", fetch = FetchType.LAZY)
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<CustomerReviewModel> customerReviewModels;

	public CustomerModel() {
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
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

	public List<CustomerRequestModel> getCustomerRequestModels() {
		return customerRequestModels;
	}

	public void setCustomerRequestModels(List<CustomerRequestModel> customerRequestModels) {
		this.customerRequestModels = customerRequestModels;
	}

	public List<CustomerReviewModel> getCustomerReviewModels() {
		return customerReviewModels;
	}

	public void setCustomerReviewModels(List<CustomerReviewModel> customerReviewModels) {
		this.customerReviewModels = customerReviewModels;
	}

	public CustomerRequestModel addCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		getCustomerRequestModels().add(customerRequestModel);
		customerRequestModel.setCustomerModel(this);
		return customerRequestModel;
	}

	public CustomerRequestModel removeCustomerRequestModel(CustomerRequestModel customerRequestModel) {
		getCustomerRequestModels().remove(customerRequestModel);
		customerRequestModel.setCustomerModel(null);
		return customerRequestModel;
	}
	
	public CustomerPaymentModel addCustomerPaymentModel(CustomerPaymentModel customerPaymentModel) {
		getCustomerPaymentModel().add(customerPaymentModel);
		customerPaymentModel.setCustomerModel(this);
		return customerPaymentModel;
	}

	public CustomerPaymentModel removeCustomerPaymentModel(CustomerPaymentModel customerPaymentModel) {
		getCustomerPaymentModel().remove(customerPaymentModel);
		customerPaymentModel.setCustomerModel(null);
		return customerPaymentModel;
	}

	public CustomerReviewModel addCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().add(customerReviewModel);
		customerReviewModel.setCustomerModel(this);
		return customerReviewModel;
	}

	public CustomerReviewModel removeCustomerReviewModel(CustomerReviewModel customerReviewModel) {
		getCustomerReviewModels().remove(customerReviewModel);
		customerReviewModel.setCustomerModel(null);
		return customerReviewModel;
	}
}