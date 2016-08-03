package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleTypes", namespace = "com.ucs.rsa.common.dto")

public class VehicleTypesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<VehicleTypeDTO> vehicleTypeDTOs;

	@XmlElement(name = "vehicleType")
	public List<VehicleTypeDTO> getVehicleTypeDTOs() {
		return vehicleTypeDTOs;
	}

	public void setVehicleTypeDTOs(List<VehicleTypeDTO> vehicleTypeDTOs) {
		this.vehicleTypeDTOs = vehicleTypeDTOs;
	}



}