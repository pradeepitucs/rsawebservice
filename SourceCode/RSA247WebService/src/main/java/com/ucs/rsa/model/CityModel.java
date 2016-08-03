package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the city_t database table.
 * 
 */
@Entity
@Table(name = "city_t")
@NamedQuery(name = "CityModel.findAll", query = "SELECT c FROM CityModel c")
public class CityModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_code")
	private String cityCode;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "is_enabled")
	private boolean isEnabled;

	// bi-directional many-to-one association to StateModel
	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateModel stateModel;

	// bi-directional many-to-one association to CustomerModel
	@OneToMany(mappedBy = "cityModel", fetch = FetchType.EAGER)
	private List<CustomerModel> customerModels;

	public CityModel() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public StateModel getStateModel() {
		return this.stateModel;
	}

	public void setStateModel(StateModel stateModel) {
		this.stateModel = stateModel;
	}

	public List<CustomerModel> getCustomerModels() {
		return this.customerModels;
	}

	public void setCustomerModels(List<CustomerModel> customerModels) {
		this.customerModels = customerModels;
	}

	public CustomerModel addCustomerModel(CustomerModel CustomerModel) {
		getCustomerModels().add(CustomerModel);
		CustomerModel.setCityModel(this);

		return CustomerModel;
	}

	public CustomerModel removeCustomerModel(CustomerModel CustomerModel) {
		getCustomerModels().remove(CustomerModel);
		CustomerModel.setCityModel(null);

		return CustomerModel;
	}

	@Override
	public String toString() {
		return "CityModel [cityId=" + cityId + ", cityCode=" + cityCode + ", cityName=" + cityName + ", isEnabled="
				+ isEnabled + ", stateModel=" + stateModel + ", customerModels=" + customerModels + "]";
	}

}