package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userVehicles", namespace = "com.ucs.rsa.common.dto")

public class UserVehiclesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<UserVehicleDTO> userVehicleDTOs;

	@XmlElement(name = "userVehicle")
	public List<UserVehicleDTO> getUserVehicleDTOs() {
		return userVehicleDTOs;
	}

	public void setUserVehicleDTOs(List<UserVehicleDTO> userVehicleDTOs) {
		this.userVehicleDTOs = userVehicleDTOs;
	}

}