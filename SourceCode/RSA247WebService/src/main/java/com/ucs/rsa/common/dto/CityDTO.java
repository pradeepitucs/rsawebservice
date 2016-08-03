package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city", namespace = "com.ucs.rsa.common.dto")
public class CityDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cityId;
	private String cityCode;
	private String cityName;
	private boolean isEnabled;

//	private StateDTO stateDTO;

//	private List<CustomerDTO> customerDTOs;

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

//	public StateDTO getStateModel() {
//		return this.stateDTO;
//	}
//
//	public void setStateModel(StateDTO stateDTO) {
//		this.stateDTO = stateDTO;
//	}
//
//	public List<CustomerDTO> getCustomerModels() {
//		return this.customerDTOs;
//	}
//
//	public void setCustomerModels(List<CustomerDTO> customerDTOs) {
//		this.customerDTOs = customerDTOs;
//	}

}