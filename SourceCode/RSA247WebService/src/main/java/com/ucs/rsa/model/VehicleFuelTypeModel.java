package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehicle_fuel_type_t database table.
 * 
 */
@Entity
@Table(name="vehicle_fuel_type_t")
@NamedQuery(name="VehicleFuelTypeModel.findAll", query="SELECT v FROM VehicleFuelTypeModel v")
public class VehicleFuelTypeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_fuel_type_id")
	private int vehicleFuelTypeId;

	@Column(name="is_enabled")
	private boolean isEnabled;

	@Column(name="vehicle_fuel_type_name")
	private String vehicleFuelTypeName;

	//bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy="vehicleFuelTypeModel", fetch=FetchType.EAGER)
	private List<VehicleInformationModel> vehicleInformationModels;

	public VehicleFuelTypeModel() {
	}

	public int getVehicleFuelTypeId() {
		return this.vehicleFuelTypeId;
	}

	public void setVehicleFuelTypeId(int vehicleFuelTypeId) {
		this.vehicleFuelTypeId = vehicleFuelTypeId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getVehicleFuelTypeName() {
		return this.vehicleFuelTypeName;
	}

	public void setVehicleFuelTypeName(String vehicleFuelTypeName) {
		this.vehicleFuelTypeName = vehicleFuelTypeName;
	}

	public List<VehicleInformationModel> getVehicleInformationModels() {
		return this.vehicleInformationModels;
	}

	public void setVehicleInformationModels(List<VehicleInformationModel> vehicleInformationModels) {
		this.vehicleInformationModels = vehicleInformationModels;
	}

	public VehicleInformationModel addVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().add(vehicleInformationModel);
		vehicleInformationModel.setVehicleFuelTypeModel(this);

		return vehicleInformationModel;
	}

	public VehicleInformationModel removeVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().remove(vehicleInformationModel);
		vehicleInformationModel.setVehicleFuelTypeModel(null);

		return vehicleInformationModel;
	}

}