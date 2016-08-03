package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "userVehicle", namespace = "com.ucs.rsa.common.dto")

public class UserVehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int vehicleId;
	private boolean isEnabled;
	private int userId;
	private String vehicleRegNo;
//	private VehicleDTO vehicleDTO;


	public int getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getVehicleRegNo() {
		return this.vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

//	public VehicleDTO getVehicleModelT() {
//		return this.vehicleDTO;
//	}
//
//	public void setVehicleModelT(VehicleDTO vehicleDTO) {
//		this.vehicleDTO = vehicleDTO;
//	}

}