/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The persistent class for the vehicle_fuel_type_t database table.
 * 
 */
@Entity
@Table(name = "vehicle_fuel_type_t")
@NamedQuery(name = "VehicleFuelTypeModel.findAll", query = "SELECT v FROM VehicleFuelTypeModel v")
public class VehicleFuelTypeModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle fuel type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_fuel_type_id")
	private int vehicleFuelTypeId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The vehicle fuel type name. */
	@Column(name = "vehicle_fuel_type_name")
	private String vehicleFuelTypeName;

	/** The vehicle information models. */
	//bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy = "vehicleFuelTypeModel", fetch = FetchType.EAGER)
	private List<VehicleInformationModel> vehicleInformationModels;

	/**
	 * Instantiates a new vehicle fuel type model.
	 */
	public VehicleFuelTypeModel()
	{
	}

	/**
	 * Gets the vehicle fuel type id.
	 *
	 * @return the vehicle fuel type id
	 */
	public int getVehicleFuelTypeId()
	{
		return this.vehicleFuelTypeId;
	}

	/**
	 * Sets the vehicle fuel type id.
	 *
	 * @param vehicleFuelTypeId
	 *           the new vehicle fuel type id
	 */
	public void setVehicleFuelTypeId(int vehicleFuelTypeId)
	{
		this.vehicleFuelTypeId = vehicleFuelTypeId;
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

	/**
	 * Gets the vehicle fuel type name.
	 *
	 * @return the vehicle fuel type name
	 */
	public String getVehicleFuelTypeName()
	{
		return this.vehicleFuelTypeName;
	}

	/**
	 * Sets the vehicle fuel type name.
	 *
	 * @param vehicleFuelTypeName
	 *           the new vehicle fuel type name
	 */
	public void setVehicleFuelTypeName(String vehicleFuelTypeName)
	{
		this.vehicleFuelTypeName = vehicleFuelTypeName;
	}

	/**
	 * Gets the vehicle information models.
	 *
	 * @return the vehicle information models
	 */
	public List<VehicleInformationModel> getVehicleInformationModels()
	{
		return this.vehicleInformationModels;
	}

	/**
	 * Sets the vehicle information models.
	 *
	 * @param vehicleInformationModels
	 *           the new vehicle information models
	 */
	public void setVehicleInformationModels(List<VehicleInformationModel> vehicleInformationModels)
	{
		this.vehicleInformationModels = vehicleInformationModels;
	}

	/**
	 * Adds the vehicle information model.
	 *
	 * @param vehicleInformationModel
	 *           the vehicle information model
	 * @return the vehicle information model
	 */
	public VehicleInformationModel addVehicleInformationModel(VehicleInformationModel vehicleInformationModel)
	{
		getVehicleInformationModels().add(vehicleInformationModel);
		vehicleInformationModel.setVehicleFuelTypeModel(this);

		return vehicleInformationModel;
	}

	/**
	 * Removes the vehicle information model.
	 *
	 * @param vehicleInformationModel
	 *           the vehicle information model
	 * @return the vehicle information model
	 */
	public VehicleInformationModel removeVehicleInformationModel(VehicleInformationModel vehicleInformationModel)
	{
		getVehicleInformationModels().remove(vehicleInformationModel);
		vehicleInformationModel.setVehicleFuelTypeModel(null);

		return vehicleInformationModel;
	}

}
