package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


/**
 * The persistent class for the vehicle_manufacturer_t database table.
 * 
 */
@Entity
@Table(name="vehicle_manufacturer_t")
@NamedQuery(name="VehicleManufacturerModel.findAll", query="SELECT v FROM VehicleManufacturerModel v")
public class VehicleManufacturerModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manufacturer_id")
	private int manufacturerId;

	@Column(name="is_enabled")
	private boolean isEnabled;

	@Column(name="manufacturer_name")
	private String manufacturerName;

	//bi-directional many-to-one association to VehicleModel
	@OneToMany(mappedBy="vehicleManufacturerModel", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<VehicleModel> vehicleModels;

//	//bi-directional many-to-one association to VehicleInformationModel
//	@OneToMany(mappedBy="vehicleManufacturerModel", fetch=FetchType.EAGER)
//	@Fetch(value = FetchMode.SUBSELECT)
//	private List<VehicleInformationModel> vehicleInformationModels;

	public VehicleManufacturerModel() {
	}

	public int getManufacturerId() {
		return this.manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public List<VehicleModel> getVehicleModels() {
		return this.vehicleModels;
	}

	public void setVehicleModels(List<VehicleModel> vehicleModels) {
		this.vehicleModels = vehicleModels;
	}

	public VehicleModel addVehicleModel(VehicleModel vehicleModel) {
		getVehicleModels().add(vehicleModel);
		vehicleModel.setVehicleManufacturerModel(this);

		return vehicleModel;
	}

	public VehicleModel removeVehicleModel(VehicleModel vehicleModel) {
		getVehicleModels().remove(vehicleModel);
		vehicleModel.setVehicleManufacturerModel(null);

		return vehicleModel;
	}

//	public List<VehicleInformationModel> getVehicleInformationModels() {
//		return this.vehicleInformationModels;
//	}
//
//	public void setVehicleInformationModels(List<VehicleInformationModel> vehicleInformationModels) {
//		this.vehicleInformationModels = vehicleInformationModels;
//	}

//	public VehicleInformationModel addVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
//		getVehicleInformationModels().add(vehicleInformationModel);
//		vehicleInformationModel.setVehicleManufacturerModel(this);
//
//		return vehicleInformationModel;
//	}
//
//	public VehicleInformationModel removeVehicleInformationModel(VehicleInformationModel vehicleInformationModel) {
//		getVehicleInformationModels().remove(vehicleInformationModel);
//		vehicleInformationModel.setVehicleManufacturerModel(null);
//
//		return vehicleInformationModel;
//	}
	
}