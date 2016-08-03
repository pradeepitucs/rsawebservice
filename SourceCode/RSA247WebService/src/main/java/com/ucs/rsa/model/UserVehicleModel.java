package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user_vehicle_t database table.
 * 
 */
@Entity
@Table(name = "user_vehicle_t")
@NamedQuery(name = "UserVehicleModel.findAll", query = "SELECT u FROM UserVehicleModel u")
public class UserVehicleModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_vehicle_id")
	private int vehicleId;

	@Column(name = "is_enabled")
	private boolean isEnabled;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "registration_number")
	private String vehicleRegNo;

	@Column(name = "year")
	private int year;

	// bi-directional many-to-one association to VehicleModel
	@ManyToOne
	@JoinColumn(name = "vehicle_information_id")
	private VehicleInformationModel vehicleInformationModel;

	public UserVehicleModel() {
	}

	public int getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getVehicleRegNo() {
		return this.vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public VehicleInformationModel getVehicleInformationModel() {
		return vehicleInformationModel;
	}

	public void setVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		this.vehicleInformationModel = vehicleInformationModel;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}