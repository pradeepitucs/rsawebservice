package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehicle_body_type_t database table.
 * 
 */
@Entity
@Table(name="vehicle_body_type_t")
@NamedQuery(name="VehicleBodyTypeModel.findAll", query="SELECT v FROM VehicleBodyTypeModel v")
public class VehicleBodyTypeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_body_type_id")
	private int vehicleBodyTypeId;

	@Column(name="is_enabled")
	private boolean isEnabled;

	@Column(name="vehicle_body_type_name")
	private String vehicleBodyTypeName;

	//bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy="vehicleBodyTypeModel", fetch=FetchType.EAGER)
	private List<VehicleInformationModel> vehicleInformationModels;

	public VehicleBodyTypeModel() {
	}

	public int getVehicleBodyTypeId() {
		return this.vehicleBodyTypeId;
	}

	public void setVehicleBodyTypeId(int vehicleBodyTypeId) {
		this.vehicleBodyTypeId = vehicleBodyTypeId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getVehicleBodyTypeName() {
		return this.vehicleBodyTypeName;
	}

	public void setVehicleBodyTypeName(String vehicleBodyTypeName) {
		this.vehicleBodyTypeName = vehicleBodyTypeName;
	}

	public List<VehicleInformationModel> getVehicleInformationModels() {
		return this.vehicleInformationModels;
	}

	public void setVehicleInformationModels(List<VehicleInformationModel> vehicleInformationModels) {
		this.vehicleInformationModels = vehicleInformationModels;
	}

	public VehicleInformationModel addVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().add(vehicleInformationModel);
		vehicleInformationModel.setVehicleBodyTypeModel(this);
		return vehicleInformationModel;
	}

	public VehicleInformationModel removeVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
		getVehicleInformationModels().remove(vehicleInformationModel);
		vehicleInformationModel.setVehicleBodyTypeModel(null);

		return vehicleInformationModel;
	}

}