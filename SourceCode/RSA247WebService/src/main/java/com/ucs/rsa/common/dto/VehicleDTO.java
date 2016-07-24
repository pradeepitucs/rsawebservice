package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicle", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int vehicleID;
	private int userId;
	private String vehicleModuleID;
	private String vehicleNo;
	private boolean isEnabled;

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getVehicleModuleID() {
		return vehicleModuleID;
	}

	public void setVehicleModuleID(String vehicleModuleID) {
		this.vehicleModuleID = vehicleModuleID;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "VehicleDTO [vehicleID=" + vehicleID + ", userId=" + userId + ", vehicleModuleID=" + vehicleModuleID
				+ ", vehicleNo=" + vehicleNo + ", isEnabled=" + isEnabled + "]";
	}

}
