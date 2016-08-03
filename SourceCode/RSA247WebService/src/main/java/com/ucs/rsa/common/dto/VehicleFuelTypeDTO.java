package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "vehicleFuelType", namespace = "com.ucs.rsa.common.dto")

public class VehicleFuelTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int vehicleFuelTypeId;
	private boolean isEnabled;
	private String vehicleFuelTypeName;
//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	public int getVehicleFuelTypeId() {
		return this.vehicleFuelTypeId;
	}

	public void setVehicleFuelTypeId(int vehicleFuelTypeId) {
		this.vehicleFuelTypeId = vehicleFuelTypeId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getVehicleFuelTypeName() {
		return this.vehicleFuelTypeName;
	}

	public void setVehicleFuelTypeName(String vehicleFuelTypeName) {
		this.vehicleFuelTypeName = vehicleFuelTypeName;
	}

//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
//		return this.vehicleInformationDTOs;
//	}
//
//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationModels) {
//		this.vehicleInformationDTOs = vehicleInformationModels;
//	}

}