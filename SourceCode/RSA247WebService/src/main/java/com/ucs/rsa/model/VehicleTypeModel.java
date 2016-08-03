package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the vehicle_type_t database table.
 * 
 */
@Entity
@Table(name = "vehicle_type_t")
@NamedQuery(name = "VehicleTypeModel.findAll", query = "SELECT v FROM VehicleTypeModel v")
public class VehicleTypeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_type")
	private int vehicleTypeId;

	@Column(name = "is_enabled")
	private boolean isEnabled;

	@Column(name = "vehicle_type_name")
	private String vehicleTypeName;

	// bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy = "vehicleTypeModel", fetch = FetchType.EAGER)
	private List<VehicleInformationModel> vehicleInformationModels;

	public VehicleTypeModel() {
	}

	public int getVehicleTypeId() {
		return this.vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getVehicleTypeName() {
		return this.vehicleTypeName;
	}

	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}

	public List<VehicleInformationModel> getVehicleInformationModels() {
		return this.vehicleInformationModels;
	}

	public void setVehicleInformationModels(List<VehicleInformationModel> vehicleInformationModels) {
		this.vehicleInformationModels = vehicleInformationModels;
	}

	public VehicleInformationModel addVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().add(vehicleInformationModel);
		vehicleInformationModel.setVehicleTypeModel(this);

		return vehicleInformationModel;
	}

	public VehicleInformationModel removeVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().remove(vehicleInformationModel);
		vehicleInformationModel.setVehicleTypeModel(null);

		return vehicleInformationModel;
	}
	
}