package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the vehicle_information_model_t database table.
 * 
 */
@Entity
@Table(name = "vehicle_information_t")
@NamedQuery(name = "VehicleInformationModel.findAll", query = "SELECT v FROM VehicleInformationModel v")
public class VehicleInformationModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_information_id")
	private int vehicleInformationModelId;

	@Column(name = "is_enabled")
	private boolean isEnabled;

	// @Column(name="vehicle_information_model_name")
	// private String vehicleInformationModelName;

	// bi-directional many-to-one association to VehicleBodyTypeModel
	@ManyToOne
	@JoinColumn(name = "vehicle_body_type_id")
	private VehicleBodyTypeModel vehicleBodyTypeModel;

	// bi-directional many-to-one association to VehicleFuelTypeModel
	@ManyToOne
	@JoinColumn(name = "vehicle_fuel_type_id")
	private VehicleFuelTypeModel vehicleFuelTypeModel;

	// //bi-directional many-to-one association to VehicleManufacturerModel
	// @ManyToOne
	// @JoinColumn(name="vehicle_manufacturer_id")
	// private VehicleManufacturerModel vehicleManufacturerModel;

	// bi-directional many-to-one association to VehicleModel
	@ManyToOne
	@JoinColumn(name = "vehicle_model_id")
	private VehicleModel vehicleModel;

	// bi-directional many-to-one association to VehicleTypeModel
	@ManyToOne
	@JoinColumn(name = "vehicle_type_id")
	private VehicleTypeModel vehicleTypeModel;

	// bi-directional many-to-one association to UserVehicleModel
	@OneToMany(mappedBy = "vehicleInformationModel")
	private List<UserVehicleModel> userVehicleModels;

	public VehicleInformationModel() {
	}

	public int getVehicleInformationModelId() {
		return this.vehicleInformationModelId;
	}

	public void setVehicleInformationModelId(int vehicleInformationModelId) {
		this.vehicleInformationModelId = vehicleInformationModelId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	// public String getVehicleInformationModelName() {
	// return this.vehicleInformationModelName;
	// }
	//
	// public void setVehicleInformationModelName(String
	// vehicleInformationModelName) {
	// this.vehicleInformationModelName = vehicleInformationModelName;
	// }

	public VehicleBodyTypeModel getVehicleBodyTypeModel() {
		return this.vehicleBodyTypeModel;
	}

	public void setVehicleBodyTypeModel(VehicleBodyTypeModel vehicleBodyTypeModel) {
		this.vehicleBodyTypeModel = vehicleBodyTypeModel;
	}

	public VehicleFuelTypeModel getVehicleFuelTypeModel() {
		return this.vehicleFuelTypeModel;
	}

	public void setVehicleFuelTypeModel(VehicleFuelTypeModel vehicleFuelTypeModel) {
		this.vehicleFuelTypeModel = vehicleFuelTypeModel;
	}

	// public VehicleManufacturerModel getVehicleManufacturerModel() {
	// return this.vehicleManufacturerModel;
	// }
	//
	// public void setVehicleManufacturerModel(VehicleManufacturerModel
	// vehicleManufacturerModel) {
	// this.vehicleManufacturerModel = vehicleManufacturerModel;
	// }

	public VehicleModel getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public VehicleTypeModel getVehicleTypeModel() {
		return this.vehicleTypeModel;
	}

	public void setVehicleTypeModel(VehicleTypeModel vehicleTypeModel) {
		this.vehicleTypeModel = vehicleTypeModel;
	}

	public List<UserVehicleModel> getUserVehicleModels() {
		return this.userVehicleModels;
	}

	public void setUserVehicleModels(List<UserVehicleModel> userVehicleModels) {
		this.userVehicleModels = userVehicleModels;
	}

	public UserVehicleModel addUserVehicleModel(UserVehicleModel userVehicleModel) {
		getUserVehicleModels().add(userVehicleModel);
		userVehicleModel.setVehicleInformationModel(this);

		return userVehicleModel;
	}

	public UserVehicleModel removeUserVehicleModel(UserVehicleModel userVehicleModel) {
		getUserVehicleModels().remove(userVehicleModel);
		userVehicleModel.setVehicleInformationModel(null);

		return userVehicleModel;
	}

}