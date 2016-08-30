/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Class CityModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "city_t")
@NamedQuery(name = "CityModel.findAll", query = "SELECT c FROM CityModel c")
public class CityModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The city id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;

	/** The city code. */
	@Column(name = "city_code")
	private String cityCode;

	/** The city name. */
	@Column(name = "city_name")
	private String cityName;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The state model. */
	// bi-directional many-to-one association to StateModel
	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateModel stateModel;

	/** The customer models. */
	// bi-directional many-to-one association to CustomerModel
	@OneToMany(mappedBy = "cityModel", fetch = FetchType.EAGER)
	private List<CustomerModel> customerModels;

	/**
	 * Instantiates a new city model.
	 */
	public CityModel()
	{
	}

	/**
	 * Gets the city id.
	 *
	 * @return the city id
	 */
	public int getCityId()
	{
		return this.cityId;
	}

	/**
	 * Sets the city id.
	 *
	 * @param cityId
	 *           the new city id
	 */
	public void setCityId(int cityId)
	{
		this.cityId = cityId;
	}

	/**
	 * Gets the city code.
	 *
	 * @return the city code
	 */
	public String getCityCode()
	{
		return this.cityCode;
	}

	/**
	 * Sets the city code.
	 *
	 * @param cityCode
	 *           the new city code
	 */
	public void setCityCode(String cityCode)
	{
		this.cityCode = cityCode;
	}

	/**
	 * Gets the city name.
	 *
	 * @return the city name
	 */
	public String getCityName()
	{
		return this.cityName;
	}

	/**
	 * Sets the city name.
	 *
	 * @param cityName
	 *           the new city name
	 */
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	/**
	 * Gets the checks if is enabled.
	 *
	 * @return the checks if is enabled
	 */
	public boolean getIsEnabled()
	{
		return this.isEnabled;
	}

	/**
	 * Sets the checks if is enabled.
	 *
	 * @param isEnabled
	 *           the new checks if is enabled
	 */
	public void setIsEnabled(boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	/**
	 * Gets the state model.
	 *
	 * @return the state model
	 */
	public StateModel getStateModel()
	{
		return this.stateModel;
	}

	/**
	 * Sets the state model.
	 *
	 * @param stateModel
	 *           the new state model
	 */
	public void setStateModel(StateModel stateModel)
	{
		this.stateModel = stateModel;
	}

	/**
	 * Gets the customer models.
	 *
	 * @return the customer models
	 */
	public List<CustomerModel> getCustomerModels()
	{
		return this.customerModels;
	}

	/**
	 * Sets the customer models.
	 *
	 * @param customerModels
	 *           the new customer models
	 */
	public void setCustomerModels(List<CustomerModel> customerModels)
	{
		this.customerModels = customerModels;
	}

	/**
	 * Adds the customer model.
	 *
	 * @param customerModel
	 *           the customer model
	 * @return the customer model
	 */
	public CustomerModel addCustomerModel(CustomerModel customerModel)
	{
		getCustomerModels().add(customerModel);
		customerModel.setCityModel(this);

		return customerModel;
	}

	/**
	 * Removes the customer model.
	 *
	 * @param customerModel
	 *           the customer model
	 * @return the customer model
	 */
	public CustomerModel removeCustomerModel(CustomerModel customerModel)
	{
		getCustomerModels().remove(customerModel);
		customerModel.setCityModel(null);

		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CityModel [cityId=" + cityId + ", cityCode=" + cityCode + ", cityName=" + cityName + ", isEnabled=" + isEnabled
				+ ", stateModel=" + stateModel + ", customerModels=" + customerModels + "]";
	}

}
