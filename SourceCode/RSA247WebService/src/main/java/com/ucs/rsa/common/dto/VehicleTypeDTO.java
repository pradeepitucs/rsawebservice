package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleType", namespace = "com.ucs.rsa.common.dto")

public class VehicleTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int vehicleTypeId;
	private boolean isEnabled;
	private String vehicleTypeName;
//	private List<VehicleInformationModelDTO> vehicleInformationModelDTOs;


	public int getVehicleTypeId() {
		return this.vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getVehicleTypeName() {
		return this.vehicleTypeName;
	}

	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}

//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
//		return this.vehicleInformationModelDTOs;
//	}
//
//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationModelDTOs) {
//		this.vehicleInformationModelDTOs = vehicleInformationModelDTOs;
//	}

}