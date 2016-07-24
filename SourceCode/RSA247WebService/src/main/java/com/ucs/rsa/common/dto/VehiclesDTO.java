package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicles", namespace = "com.ucs.rsa.common.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehiclesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<VehicleDTO> vehiclesDTO;

	public List<VehicleDTO> getVehiclesDTO() {
		return vehiclesDTO;
	}

	public void setVehiclesDTO(List<VehicleDTO> vehiclesDTO) {
		this.vehiclesDTO = vehiclesDTO;
	}

	@Override
	public String toString() {
		return "VehiclesDTO [vehiclesDTO=" + vehiclesDTO + "]";
	}

}
