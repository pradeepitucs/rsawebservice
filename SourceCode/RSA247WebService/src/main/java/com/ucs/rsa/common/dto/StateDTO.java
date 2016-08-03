package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "state", namespace = "com.ucs.rsa.common.dto")

public class StateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int stateId;
	private boolean isEnabled;
	private String stateCode;
	private String stateName;
//	private List<CityDTO> cityDTOs;


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

//	public List<CityDTO> getCityModels() {
//		return this.cityDTOs;
//	}
//
//	public void setCityModels(List<CityDTO> cityDTOs) {
//		this.cityDTOs = cityDTOs;
//	}

}