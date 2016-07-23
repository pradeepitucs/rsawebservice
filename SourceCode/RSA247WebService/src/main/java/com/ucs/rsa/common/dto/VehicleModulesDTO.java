package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleModuleDetails", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleModulesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<VehicleModuleDTO> vehicleModuleDTO;

	public List<VehicleModuleDTO> getVehicleModuleDTO() {
		return vehicleModuleDTO;
	}

	public void setVehicleModuleDTO(List<VehicleModuleDTO> vehicleModuleDTO) {
		this.vehicleModuleDTO = vehicleModuleDTO;
	}

	@Override
	public String toString() {
		return "VehicleModulesDTO [vehicleModuleDTO=" + vehicleModuleDTO + "]";
	}

}
