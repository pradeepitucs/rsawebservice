package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VehicleManufacturers", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleManufacturerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int manufacturesrID;
	private String manufacturerName;
	private boolean isEnabled;

	public int getManufacturesrID() {
		return manufacturesrID;
	}

	public void setManufacturesrID(int manufacturesrID) {
		this.manufacturesrID = manufacturesrID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "VehicleManufacturesrDTO [manufacturesrID=" + manufacturesrID + ", manufacturer=" + manufacturerName
				+ ", isEnabled=" + isEnabled + "]";
	}

}
