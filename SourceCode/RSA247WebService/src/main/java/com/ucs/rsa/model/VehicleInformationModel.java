/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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
 * The Class VehicleInformationModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "vehicle_information_t")
@NamedQuery(name = "VehicleInformationModel.findAll", query = "SELECT v FROM VehicleInformationModel v")
public class VehicleInformationModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle information model id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_information_id")
	private int vehicleInformationModelId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	// @Column(name="vehicle_information_model_name")
	// private String vehicleInformationModelName;

	/** The vehicle body type model. */
	// bi-directional many-to-one association to VehicleBodyTypeModel
	@ManyToOne
	@JoinColumn(name = "vehicle_body_type_id")
	private VehicleBodyTypeModel vehicleBodyTypeModel;

	/** The vehicle fuel type model. */
	// bi-directional many-to-one association to VehicleFuelTypeModel
	@ManyToOne
	@JoinColumn(name = "vehicle_fuel_type_id")
	private VehicleFuelTypeModel vehicleFuelTypeModel;

	// //bi-directional many-to-one association to VehicleManufacturerModel
	// @ManyToOne
	// @JoinColumn(name="vehicle_manufacturer_id")
	// private VehicleManufacturerModel vehicleManufacturerModel;

	/** The vehicle model. */
	// bi-directional many-to-one association to VehicleModel
	@ManyToOne
	@JoinColumn(name = "vehicle_model_id")
	private VehicleModel vehicleModel;

	/** The vehicle type model. */
	// bi-directional many-to-one association to VehicleTypeModel
	@ManyToOne
	@JoinColumn(name = "vehicle_type_id")
	private VehicleTypeModel vehicleTypeModel;

	/** The user vehicle models. */
	// bi-directional many-to-one association to UserVehicleModel
	@OneToMany(mappedBy = "vehicleInformationModel")
	private List<UserVehicleModel> userVehicleModels;

	/**
	 * Instantiates a new vehicle information model.
	 */
	public VehicleInformationModel()
	{
	}

	/**
	 * Gets the vehicle information model id.
	 *
	 * @return the vehicle information model id
	 */
	public int getVehicleInformationModelId()
	{
		return this.vehicleInformationModelId;
	}

	/**
	 * Sets the vehicle information model id.
	 *
	 * @param vehicleInformationModelId
	 *           the new vehicle information model id
	 */
	public void setVehicleInformationModelId(int vehicleInformationModelId)
	{
		this.vehicleInformationModelId = vehicleInformationModelId;
	}

	/**
	 * Gets the checks if is enabled.
	 *
	 * @return the checks if is enabled
	 */
	public boolean getIsEnabled()
	{
		return this.isEnabled;
	}

	/**
	 * Sets the checks if is enabled.
	 *
	 * @param isEnabled
	 *           the new checks if is enabled
	 */
	public void setIsEnabled(boolean isEnabled)
	{
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

	/**
	 * Gets the vehicle body type model.
	 *
	 * @return the vehicle body type model
	 */
	public VehicleBodyTypeModel getVehicleBodyTypeModel()
	{
		return this.vehicleBodyTypeModel;
	}

	/**
	 * Sets the vehicle body type model.
	 *
	 * @param vehicleBodyTypeModel
	 *           the new vehicle body type model
	 */
	public void setVehicleBodyTypeModel(VehicleBodyTypeModel vehicleBodyTypeModel)
	{
		this.vehicleBodyTypeModel = vehicleBodyTypeModel;
	}

	/**
	 * Gets the vehicle fuel type model.
	 *
	 * @return the vehicle fuel type model
	 */
	public VehicleFuelTypeModel getVehicleFuelTypeModel()
	{
		return this.vehicleFuelTypeModel;
	}

	/**
	 * Sets the vehicle fuel type model.
	 *
	 * @param vehicleFuelTypeModel
	 *           the new vehicle fuel type model
	 */
	public void setVehicleFuelTypeModel(VehicleFuelTypeModel vehicleFuelTypeModel)
	{
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

	/**
	 * Gets the vehicle model.
	 *
	 * @return the vehicle model
	 */
	public VehicleModel getVehicleModel()
	{
		return this.vehicleModel;
	}

	/**
	 * Sets the vehicle model.
	 *
	 * @param vehicleModel
	 *           the new vehicle model
	 */
	public void setVehicleModel(VehicleModel vehicleModel)
	{
		this.vehicleModel = vehicleModel;
	}

	/**
	 * Gets the vehicle type model.
	 *
	 * @return the vehicle type model
	 */
	public VehicleTypeModel getVehicleTypeModel()
	{
		return this.vehicleTypeModel;
	}

	/**
	 * Sets the vehicle type model.
	 *
	 * @param vehicleTypeModel
	 *           the new vehicle type model
	 */
	public void setVehicleTypeModel(VehicleTypeModel vehicleTypeModel)
	{
		this.vehicleTypeModel = vehicleTypeModel;
	}

	/**
	 * Gets the user vehicle models.
	 *
	 * @return the user vehicle models
	 */
	public List<UserVehicleModel> getUserVehicleModels()
	{
		return this.userVehicleModels;
	}

	/**
	 * Sets the user vehicle models.
	 *
	 * @param userVehicleModels
	 *           the new user vehicle models
	 */
	public void setUserVehicleModels(List<UserVehicleModel> userVehicleModels)
	{
		this.userVehicleModels = userVehicleModels;
	}

	/**
	 * Adds the user vehicle model.
	 *
	 * @param userVehicleModel
	 *           the user vehicle model
	 * @return the user vehicle model
	 */
	public UserVehicleModel addUserVehicleModel(UserVehicleModel userVehicleModel)
	{
		getUserVehicleModels().add(userVehicleModel);
		userVehicleModel.setVehicleInformationModel(this);

		return userVehicleModel;
	}

	/**
	 * Removes the user vehicle model.
	 *
	 * @param userVehicleModel
	 *           the user vehicle model
	 * @return the user vehicle model
	 */
	public UserVehicleModel removeUserVehicleModel(UserVehicleModel userVehicleModel)
	{
		getUserVehicleModels().remove(userVehicleModel);
		userVehicleModel.setVehicleInformationModel(null);

		return userVehicleModel;
	}

}
