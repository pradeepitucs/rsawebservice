package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "vehicleInformationModel", namespace = "com.ucs.rsa.common.dto")

public class VehicleInformationModelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int vehicleInformationModelId;
	private boolean isEnabled;
	private String vehicleInformationModelName;
//	private int vehicleInformationModelYear;
//	private VehicleBodyTypeDTO vehicleBodyTypeDTO;
//	private VehicleFuelTypeDTO vehicleFuelTypeDTO;
//	private VehicleManufacturerDTO vehicleManufacturerDTO;
//	private VehicleDTO vehicleDTO;
//	private VehicleTypeDTO vehicleTypeDTO;


	public int getVehicleInformationModelId() {
		return this.vehicleInformationModelId;
	}

	public void setVehicleInformationModelId(int vehicleInformationModelId) {
		this.vehicleInformationModelId = vehicleInformationModelId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getVehicleInformationModelName() {
		return this.vehicleInformationModelName;
	}

	public void setVehicleInformationModelName(String vehicleInformationModelName) {
		this.vehicleInformationModelName = vehicleInformationModelName;
	}

//	public int getVehicleInformationModelYear() {
//		return this.vehicleInformationModelYear;
//	}
//
//	public void setVehicleInformationModelYear(int vehicleInformationModelYear) {
//		this.vehicleInformationModelYear = vehicleInformationModelYear;
//	}

//	public VehicleBodyTypeDTO getVehicleBodyTypeModel() {
//		return this.vehicleBodyTypeDTO;
//	}
//
//	public void setVehicleBodyTypeModel(VehicleBodyTypeDTO vehicleBodyTypeDTO) {
//		this.vehicleBodyTypeDTO = vehicleBodyTypeDTO;
//	}
//
//	public VehicleFuelTypeDTO getVehicleFuelTypeModel() {
//		return this.vehicleFuelTypeDTO;
//	}
//
//	public void setVehicleFuelTypeModel(VehicleFuelTypeDTO vehicleFuelTypeDTO) {
//		this.vehicleFuelTypeDTO = vehicleFuelTypeDTO;
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
//	public VehicleDTO getVehicleModel() {
//		return this.vehicleDTO;
//	}
//
//	public void setVehicleModel(VehicleDTO vehicleDTO) {
//		this.vehicleDTO = vehicleDTO;
//	}
//
//	public VehicleTypeDTO getVehicleTypeModel() {
//		return this.vehicleTypeDTO;
//	}
//
//	public void setVehicleTypeModel(VehicleTypeDTO vehicleTypeDTO) {
//		this.vehicleTypeDTO = vehicleTypeDTO;
//	}

}