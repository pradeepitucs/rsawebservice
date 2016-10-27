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


// TODO: Auto-generated Javadoc
/**
 * The Class VehicleTypeModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "vehicle_type_t")
@NamedQuery(name = "VehicleTypeModel.findAll", query = "SELECT v FROM VehicleTypeModel v")
public class VehicleTypeModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_type")
	private int vehicleTypeId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The vehicle type name. */
	@Column(name = "vehicle_type_name")
	private String vehicleTypeName;

	/** The vehicle information models. */
	// bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy = "vehicleTypeModel", fetch = FetchType.EAGER)
	private List<VehicleInformationModel> vehicleInformationModels;

	/**
	 * Instantiates a new vehicle type model.
	 */
	public VehicleTypeModel()
	{
	}

	/**
	 * Gets the vehicle type id.
	 *
	 * @return the vehicle type id
	 */
	public int getVehicleTypeId()
	{
		return this.vehicleTypeId;
	}

	/**
	 * Sets the vehicle type id.
	 *
	 * @param vehicleTypeId
	 *           the new vehicle type id
	 */
	public void setVehicleTypeId(int vehicleTypeId)
	{
		this.vehicleTypeId = vehicleTypeId;
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
	 * Gets the vehicle type name.
	 *
	 * @return the vehicle type name
	 */
	public String getVehicleTypeName()
	{
		return this.vehicleTypeName;
	}

	/**
	 * Sets the vehicle type name.
	 *
	 * @param vehicleTypeName
	 *           the new vehicle type name
	 */
	public void setVehicleTypeName(String vehicleTypeName)
	{
		this.vehicleTypeName = vehicleTypeName;
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
		vehicleInformationModel.setVehicleTypeModel(this);

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
		vehicleInformationModel.setVehicleTypeModel(null);

		return vehicleInformationModel;
	}

}
