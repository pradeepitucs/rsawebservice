/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The persistent class for the customer_t database table.
 * 
 */
@Entity
@Table(name = "customer_t")
@PrimaryKeyJoinColumn(name = "user_id")
@NamedQuery(name = "CustomerModel.findAll", query = "SELECT c FROM CustomerModel c")
public class CustomerModel extends UserModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The email id. */
	@Column(name = "email_id")
	private String emailId;

	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The folder name. */
	@Column(name = "folder_name")
	private String folderName;

	/** The gcm id. */
	@Column(name = "gcm_id")
	private String gcmId;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The city model. */
	// bi-directional many-to-one association to CityModel
	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityModel cityModel;

	/** The customer request models. */
	// bi-directional many-to-one association to CustomerRequestModel
	@OneToMany(mappedBy = "customerModel", fetch = FetchType.LAZY)
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<CustomerRequestModel> customerRequestModels;

	/** The customer review models. */
	// bi-directional many-to-one association to CustomerReviewModel
	@OneToMany(mappedBy = "customerModel", fetch = FetchType.LAZY)
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<CustomerReviewModel> customerReviewModels;

	/**
	 * Instantiates a new customer model.
	 */
	public CustomerModel()
	{
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId()
	{
		return this.emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId
	 *           the new email id
	 */
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return this.firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *           the new first name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Gets the folder name.
	 *
	 * @return the folder name
	 */
	public String getFolderName()
	{
		return this.folderName;
	}

	/**
	 * Sets the folder name.
	 *
	 * @param folderName
	 *           the new folder name
	 */
	public void setFolderName(String folderName)
	{
		this.folderName = folderName;
	}

	/**
	 * Gets the gcm id.
	 *
	 * @return the gcm id
	 */
	public String getGcmId()
	{
		return this.gcmId;
	}

	/**
	 * Sets the gcm id.
	 *
	 * @param gcmId
	 *           the new gcm id
	 */
	public void setGcmId(String gcmId)
	{
		this.gcmId = gcmId;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return this.lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *           the new last name
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * Gets the city model.
	 *
	 * @return the city model
	 */
	public CityModel getCityModel()
	{
		return this.cityModel;
	}

	/**
	 * Sets the city model.
	 *
	 * @param cityModel
	 *           the new city model
	 */
	public void setCityModel(CityModel cityModel)
	{
		this.cityModel = cityModel;
	}

	/**
	 * Gets the customer request models.
	 *
	 * @return the customer request models
	 */
	public List<CustomerRequestModel> getCustomerRequestModels()
	{
		return customerRequestModels;
	}

	/**
	 * Sets the customer request models.
	 *
	 * @param customerRequestModels
	 *           the new customer request models
	 */
	public void setCustomerRequestModels(List<CustomerRequestModel> customerRequestModels)
	{
		this.customerRequestModels = customerRequestModels;
	}

	/**
	 * Gets the customer review models.
	 *
	 * @return the customer review models
	 */
	public List<CustomerReviewModel> getCustomerReviewModels()
	{
		return customerReviewModels;
	}

	/**
	 * Sets the customer review models.
	 *
	 * @param customerReviewModels
	 *           the new customer review models
	 */
	public void setCustomerReviewModels(List<CustomerReviewModel> customerReviewModels)
	{
		this.customerReviewModels = customerReviewModels;
	}

	/**
	 * Adds the customer request model.
	 *
	 * @param customerRequestModel
	 *           the customer request model
	 * @return the customer request model
	 */
	public CustomerRequestModel addCustomerRequestModel(CustomerRequestModel customerRequestModel)
	{
		getCustomerRequestModels().add(customerRequestModel);
		customerRequestModel.setCustomerModel(this);
		return customerRequestModel;
	}

	/**
	 * Removes the customer request model.
	 *
	 * @param customerRequestModel
	 *           the customer request model
	 * @return the customer request model
	 */
	public CustomerRequestModel removeCustomerRequestModel(CustomerRequestModel customerRequestModel)
	{
		getCustomerRequestModels().remove(customerRequestModel);
		customerRequestModel.setCustomerModel(null);
		return customerRequestModel;
	}

	/**
	 * Adds the customer review model.
	 *
	 * @param customerReviewModel
	 *           the customer review model
	 * @return the customer review model
	 */
	public CustomerReviewModel addCustomerReviewModel(CustomerReviewModel customerReviewModel)
	{
		getCustomerReviewModels().add(customerReviewModel);
		customerReviewModel.setCustomerModel(this);
		return customerReviewModel;
	}

	/**
	 * Removes the customer review model.
	 *
	 * @param customerReviewModel
	 *           the customer review model
	 * @return the customer review model
	 */
	public CustomerReviewModel removeCustomerReviewModel(CustomerReviewModel customerReviewModel)
	{
		getCustomerReviewModels().remove(customerReviewModel);
		customerReviewModel.setCustomerModel(null);
		return customerReviewModel;
	}
}
