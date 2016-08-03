package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleInformationModels", namespace = "com.ucs.rsa.common.dto")

public class VehicleInformationModelsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<VehicleInformationModelDTO> vehicleInformationModelDTOs;

	@XmlElement(name = "vehicleInformationModel")
	public List<VehicleInformationModelDTO> getVehicleInformationModelDTOs() {
		return vehicleInformationModelDTOs;
	}

	public void setVehicleInformationModelDTOs(List<VehicleInformationModelDTO> vehicleInformationModelDTOs) {
		this.vehicleInformationModelDTOs = vehicleInformationModelDTOs;
	}

}