package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


/**
 * The persistent class for the vehicle_model_t database table.
 * 
 */
@Entity
@Table(name="vehicle_model_t")
@NamedQuery(name="VehicleModel.findAll", query="SELECT v FROM VehicleModel v")
public class VehicleModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	private int vehicleModelId;

	@Column(name="is_enabled")
	private boolean isEnabled;

	@Column(name="module_name")
	private String modelName;

	//bi-directional many-to-one association to VehicleManufacturerModel
	@ManyToOne
	@JoinColumn(name="manufacturer_id")
	private VehicleManufacturerModel vehicleManufacturerModel;

	//bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy="vehicleModel")
	private List<VehicleInformationModel> vehicleInformationModels;

	public VehicleModel() {
	}

	public int getVehicleModelId() {
		return this.vehicleModelId;
	}

	public void setVehicleModelId(int vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public VehicleManufacturerModel getVehicleManufacturerModel() {
		return this.vehicleManufacturerModel;
	}

	public void setVehicleManufacturerModel(VehicleManufacturerModel vehicleManufacturerModel) {
		this.vehicleManufacturerModel = vehicleManufacturerModel;
	}

	public List<VehicleInformationModel> getVehicleInformationModels() {
		return this.vehicleInformationModels;
	}

	public void setVehicleInformationModels(List<VehicleInformationModel> vehicleInformationModels) {
		this.vehicleInformationModels = vehicleInformationModels;
	}

	public VehicleInformationModel addVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().add(vehicleInformationModel);
		vehicleInformationModel.setVehicleModel(this);

		return vehicleInformationModel;
	}

	public VehicleInformationModel removeVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().remove(vehicleInformationModel);
		vehicleInformationModel.setVehicleModel(null);

		return vehicleInformationModel;
	}

}