package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleModuleDetails", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleModuleDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<VehicleModuleDetailDTO> vehicleModuleDetaislDTO;

	public List<VehicleModuleDetailDTO> getVehicleModuleDetaislDTO() {
		return vehicleModuleDetaislDTO;
	}

	public void setVehicleModuleDetaislDTO(List<VehicleModuleDetailDTO> vehicleModuleDetaislDTO) {
		this.vehicleModuleDetaislDTO = vehicleModuleDetaislDTO;
	}

	@Override
	public String toString() {
		return "VehicleModuleDetailsDTO [vehicleModuleDetaislDTO=" + vehicleModuleDetaislDTO + "]";
	}

}
