package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleManufacturers", namespace = "com.ucs.rsa.common.dto")

public class VehicleManufacturersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<VehicleManufacturerDTO> vehicleManufacturerDTOs;

	@XmlElement(name = "vehicleManufacturers")
	public List<VehicleManufacturerDTO> getVehicleManufacturerDTOs() {
		return vehicleManufacturerDTOs;
	}

	public void setVehicleManufacturerDTOs(List<VehicleManufacturerDTO> vehicleManufacturerDTOs) {
		this.vehicleManufacturerDTOs = vehicleManufacturerDTOs;
	}

}