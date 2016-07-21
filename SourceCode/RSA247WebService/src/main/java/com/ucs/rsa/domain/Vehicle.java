package com.ucs.rsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_t")
public class Vehicle extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id", unique = true, insertable = true, updatable = false)
	private int vehicleID;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="vehicle_module_id")
	private String vehicleModuleID;
	
	@Column(name="vehicle_no")
	private String vehicleNo;
	
	@Column(name="isEnabled")
	private boolean isEnabled;

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getVehicleModuleID() {
		return vehicleModuleID;
	}

	public void setVehicleModuleID(String vehicleModuleID) {
		this.vehicleModuleID = vehicleModuleID;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", userId=" + userId + ", vehicleModuleID=" + vehicleModuleID
				+ ", vehicleNo=" + vehicleNo + ", isEnabled=" + isEnabled + "]";
	}

}
