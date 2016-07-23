package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VehicleManufacturer", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleManufacturersDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<VehicleManufacturerDTO> vehicleManufacturerDTOs;

	public List<VehicleManufacturerDTO> getVehicleManufacturerDTOs() {
		return vehicleManufacturerDTOs;
	}

	public void setVehicleManufacturerDTOs(List<VehicleManufacturerDTO> vehicleManufacturerDTOs) {
		this.vehicleManufacturerDTOs = vehicleManufacturerDTOs;
	}

	@Override
	public String toString() {
		return "VehicleManufacturersDTO [vehicleManufacturerDTOs=" + vehicleManufacturerDTOs + "]";
	}

}
