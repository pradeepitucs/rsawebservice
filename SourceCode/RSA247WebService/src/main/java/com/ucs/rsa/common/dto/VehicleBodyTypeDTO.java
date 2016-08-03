package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VehicleBodyTypeDTO", namespace = "com.ucs.rsa.common.dto")
public class VehicleBodyTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int vehicleBodyTypeId;
	private boolean isEnabled;
	private String vehicleBodyTypeName;
//	private List<VehicleInformationModelDTO> vehicleInformationDTOs;


	public int getVehicleBodyTypeId() {
		return this.vehicleBodyTypeId;
	}

	public void setVehicleBodyTypeId(int vehicleBodyTypeId) {
		this.vehicleBodyTypeId = vehicleBodyTypeId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getVehicleBodyTypeName() {
		return this.vehicleBodyTypeName;
	}

	public void setVehicleBodyTypeName(String vehicleBodyTypeName) {
		this.vehicleBodyTypeName = vehicleBodyTypeName;
	}

	@Override
	public String toString() {
		return "VehicleBodyTypeDTO [vehicleBodyTypeId=" + vehicleBodyTypeId + ", isEnabled=" + isEnabled
				+ ", vehicleBodyTypeName=" + vehicleBodyTypeName + "]";
	}

//	public List<VehicleInformationModelDTO> getVehicleInformationModels() {
//		return this.vehicleInformationDTOs;
//	}
//
//	public void setVehicleInformationModels(List<VehicleInformationModelDTO> vehicleInformationDTOs) {
//		this.vehicleInformationDTOs = vehicleInformationDTOs;
//	}

	
}