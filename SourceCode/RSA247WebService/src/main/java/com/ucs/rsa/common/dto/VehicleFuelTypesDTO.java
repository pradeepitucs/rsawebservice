package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleFuelTypes", namespace = "com.ucs.rsa.common.dto")

public class VehicleFuelTypesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<VehicleFuelTypeDTO> vehicleFuelTypeDTOs;

	@XmlElement(name = "vehicleFuelType")
	public List<VehicleFuelTypeDTO> getVehicleFuelTypeDTOs() {
		return vehicleFuelTypeDTOs;
	}

	public void setVehicleFuelTypeDTOs(List<VehicleFuelTypeDTO> vehicleFuelTypeDTOs) {
		this.vehicleFuelTypeDTOs = vehicleFuelTypeDTOs;
	}

}