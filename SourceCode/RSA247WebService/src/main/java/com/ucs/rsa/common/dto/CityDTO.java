package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city", namespace = "com.ucs.rsa.common.dto")
public class CityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cityID;
	private String cityName;
	private String cityCode;
	private boolean isEnabled;

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "CityDTO [cityID=" + cityID + ", cityName=" + cityName + ", cityCode=" + cityCode + ", isEnabled="
				+ isEnabled + "]";
	}

}
