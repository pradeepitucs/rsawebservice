package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleTypes", namespace = "com.ucs.rsa.common.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleTypesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<VehicleTypeDTO> vehicleTypeDTO;

	public List<VehicleTypeDTO> getVehicleTypeDTO() {
		return vehicleTypeDTO;
	}

	public void setVehicleTypeDTO(List<VehicleTypeDTO> vehicleTypeDTO) {
		this.vehicleTypeDTO = vehicleTypeDTO;
	}

	@Override
	public String toString() {
		return "VehicleTypesDTO [vehicleTypeDTO=" + vehicleTypeDTO + "]";
	}

}
