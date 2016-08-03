package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicles", namespace = "com.ucs.rsa.common.dto")

public class VehiclesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<VehicleDTO> vehicleDTOs;

	@XmlElement(name = "vehicle")
	public List<VehicleDTO> getVehicleDTOs() {
		return vehicleDTOs;
	}

	public void setVehicleDTOs(List<VehicleDTO> vehicleDTOs) {
		this.vehicleDTOs = vehicleDTOs;
	}

}