package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicle", namespace = "com.ucs.rsa.common.dto")

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int vehicleModelId;
	private boolean isEnabled;
	private String modelName;
//	private List<UserVehicleDTO> userVehicleDTOs;
//	private VehicleManufacturerDTO vehicleManufacturerDTO;
//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	public int getVehicleModelId() {
		return this.vehicleModelId;
	}

	public void setVehicleModelId(int vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

//	public List<UserVehicleDTO> getUserVehicleModels() {
//		return this.userVehicleDTOs;
//	}
//
//	public void setUserVehicleModels(List<UserVehicleDTO> userVehicleDTOs) {
//		this.userVehicleDTOs = userVehicleDTOs;
//	}
//
//	public VehicleManufacturerDTO getVehicleManufacturerModel() {
//		return this.vehicleManufacturerDTO;
//	}
//
//	public void setVehicleManufacturerModel(VehicleManufacturerDTO vehicleManufacturerDTO) {
//		this.vehicleManufacturerDTO = vehicleManufacturerDTO;
//	}
//
//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
//		return this.vehicleInformationDTOs;
//	}
//
//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationDTOs) {
//		this.vehicleInformationDTOs = vehicleInformationDTOs;
//	}

}