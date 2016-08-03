package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VehicleBodyTypesDTO", namespace = "com.ucs.rsa.common.dto")

public class VehicleBodyTypesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<VehicleBodyTypeDTO> vehicleBodyTypeDTOs;
	
	public List<VehicleBodyTypeDTO> getVehicleBodyTypeDTOs() {
		return vehicleBodyTypeDTOs;
	}

	public void setVehicleBodyTypeDTOs(List<VehicleBodyTypeDTO> vehicleBodyTypeDTOs) {
		this.vehicleBodyTypeDTOs = vehicleBodyTypeDTOs;
	}

}