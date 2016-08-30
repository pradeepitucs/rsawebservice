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
 * The Class VehicleBodyTypeModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "vehicle_body_type_t")
@NamedQuery(name = "VehicleBodyTypeModel.findAll", query = "SELECT v FROM VehicleBodyTypeModel v")
public class VehicleBodyTypeModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle body type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_body_type_id")
	private int vehicleBodyTypeId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The vehicle body type name. */
	@Column(name = "vehicle_body_type_name")
	private String vehicleBodyTypeName;

	/** The vehicle information models. */
	//bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy = "vehicleBodyTypeModel", fetch = FetchType.EAGER)
	private List<VehicleInformationModel> vehicleInformationModels;

	/**
	 * Instantiates a new vehicle body type model.
	 */
	public VehicleBodyTypeModel()
	{
	}

	/**
	 * Gets the vehicle body type id.
	 *
	 * @return the vehicle body type id
	 */
	public int getVehicleBodyTypeId()
	{
		return this.vehicleBodyTypeId;
	}

	/**
	 * Sets the vehicle body type id.
	 *
	 * @param vehicleBodyTypeId
	 *           the new vehicle body type id
	 */
	public void setVehicleBodyTypeId(int vehicleBodyTypeId)
	{
		this.vehicleBodyTypeId = vehicleBodyTypeId;
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
	 * Gets the vehicle body type name.
	 *
	 * @return the vehicle body type name
	 */
	public String getVehicleBodyTypeName()
	{
		return this.vehicleBodyTypeName;
	}

	/**
	 * Sets the vehicle body type name.
	 *
	 * @param vehicleBodyTypeName
	 *           the new vehicle body type name
	 */
	public void setVehicleBodyTypeName(String vehicleBodyTypeName)
	{
		this.vehicleBodyTypeName = vehicleBodyTypeName;
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
		vehicleInformationModel.setVehicleBodyTypeModel(this);
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
		vehicleInformationModel.setVehicleBodyTypeModel(null);

		return vehicleInformationModel;
	}

}
