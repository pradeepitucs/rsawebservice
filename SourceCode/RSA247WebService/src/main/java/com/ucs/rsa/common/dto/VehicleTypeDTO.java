package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleType", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleTypeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int vehicleType;
	private String vehicleTypeName;
	private String fuelType;

	public int getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleTypeName() {
		return vehicleTypeName;
	}

	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "VehicleTypeDTO [vehicleType=" + vehicleType + ", vehicleTypeName=" + vehicleTypeName + ", fuelType="
				+ fuelType + "]";
	}

}
