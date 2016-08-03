package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "vehicleManufacturer", namespace = "com.ucs.rsa.common.dto")

public class VehicleManufacturerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int manufacturerId;
	private boolean isEnabled;
	private String manufacturerName;
//	private List<VehicleDTO> vehicleDTOs;
//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	public int getManufacturerId() {
		return this.manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

//	public List<VehicleDTO> getVehicleModels() {
//		return this.vehicleDTOs;
//	}
//
//	public void setVehicleModels(List<VehicleDTO> vehicleModels) {
//		this.vehicleDTOs = vehicleModels;
//	}
//
//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
//		return this.vehicleInformationDTOs;
//	}
//
//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationModels) {
//		this.vehicleInformationDTOs = vehicleInformationModels;
//	}

}