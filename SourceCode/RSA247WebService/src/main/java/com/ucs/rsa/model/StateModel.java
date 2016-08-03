package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state_t database table.
 * 
 */
@Entity
@Table(name="state_t")
@NamedQuery(name="StateModel.findAll", query="SELECT s FROM StateModel s")
public class StateModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="state_id")
	private int stateId;

	@Column(name="is_enabled")
	private boolean isEnabled;

	@Column(name="state_code")
	private String stateCode;

	@Column(name="state_name")
	private String stateName;

	//bi-directional many-to-one association to CityModel
	@OneToMany(mappedBy="stateModel", fetch=FetchType.EAGER)
	private List<CityModel> cityModels;

	public StateModel() {
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<CityModel> getCityModels() {
		return this.cityModels;
	}

	public void setCityModels(List<CityModel> cityModels) {
		this.cityModels = cityModels;
	}

	public CityModel addCityModel(CityModel cityModel) {
		getCityModels().add(cityModel);
		cityModel.setStateModel(this);

		return cityModel;
	}

	public CityModel removeCityModel(CityModel cityModel) {
		getCityModels().remove(cityModel);
		cityModel.setStateModel(null);

		return cityModel;
	}

	@Override
	public String toString() {
		return "StateModel [stateId=" + stateId + ", isEnabled=" + isEnabled + ", stateCode=" + stateCode
				+ ", stateName=" + stateName + ", cityModels=" + cityModels + "]";
	}
	
	
}