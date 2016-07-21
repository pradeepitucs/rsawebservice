package com.ucs.rsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_type_t")
public class VehicleType extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_type", unique = true, insertable = true, updatable = false)
	private int vehicleType;
	
	@Column(name="vehicle_type_name")
	private String vehicleTypeName;
	
	@Column(name="fuel_type")	
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
		return "VehicleType [vehicleType=" + vehicleType + ", vehicleTypeName=" + vehicleTypeName + ", fuelType="
				+ fuelType + "]";
	}

}
