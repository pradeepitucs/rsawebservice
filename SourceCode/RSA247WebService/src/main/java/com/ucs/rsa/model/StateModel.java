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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * The Class StateModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "state_t")
@NamedQuery(name = "StateModel.findAll", query = "SELECT s FROM StateModel s")
public class StateModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The state id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private int stateId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The state code. */
	@Column(name = "state_code")
	private String stateCode;

	/** The state name. */
	@Column(name = "state_name")
	private String stateName;

	/** The city models. */
	//bi-directional many-to-one association to CityModel
	@OneToMany(mappedBy = "stateModel", fetch = FetchType.EAGER)
	private List<CityModel> cityModels;

	/**
	 * Instantiates a new state model.
	 */
	public StateModel()
	{
	}

	/**
	 * Gets the state id.
	 *
	 * @return the state id
	 */
	public int getStateId()
	{
		return this.stateId;
	}

	/**
	 * Sets the state id.
	 *
	 * @param stateId
	 *           the new state id
	 */
	public void setStateId(int stateId)
	{
		this.stateId = stateId;
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
	 * Gets the state code.
	 *
	 * @return the state code
	 */
	public String getStateCode()
	{
		return this.stateCode;
	}

	/**
	 * Sets the state code.
	 *
	 * @param stateCode
	 *           the new state code
	 */
	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}

	/**
	 * Gets the state name.
	 *
	 * @return the state name
	 */
	public String getStateName()
	{
		return this.stateName;
	}

	/**
	 * Sets the state name.
	 *
	 * @param stateName
	 *           the new state name
	 */
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	/**
	 * Gets the city models.
	 *
	 * @return the city models
	 */
	public List<CityModel> getCityModels()
	{
		return this.cityModels;
	}

	/**
	 * Sets the city models.
	 *
	 * @param cityModels
	 *           the new city models
	 */
	public void setCityModels(List<CityModel> cityModels)
	{
		this.cityModels = cityModels;
	}

	/**
	 * Adds the city model.
	 *
	 * @param cityModel
	 *           the city model
	 * @return the city model
	 */
	public CityModel addCityModel(CityModel cityModel)
	{
		getCityModels().add(cityModel);
		cityModel.setStateModel(this);

		return cityModel;
	}

	/**
	 * Removes the city model.
	 *
	 * @param cityModel
	 *           the city model
	 * @return the city model
	 */
	public CityModel removeCityModel(CityModel cityModel)
	{
		getCityModels().remove(cityModel);
		cityModel.setStateModel(null);

		return cityModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "StateModel [stateId=" + stateId + ", isEnabled=" + isEnabled + ", stateCode=" + stateCode + ", stateName="
				+ stateName + ", cityModels=" + cityModels + "]";
	}


}
