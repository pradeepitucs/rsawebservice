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
 * The Class VehicleModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "vehicle_model_t")
@NamedQuery(name = "VehicleModel.findAll", query = "SELECT v FROM VehicleModel v")
public class VehicleModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle model id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "model_id")
	private int vehicleModelId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The model name. */
	@Column(name = "module_name")
	private String modelName;

	/** The vehicle manufacturer model. */
	//bi-directional many-to-one association to VehicleManufacturerModel
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private VehicleManufacturerModel vehicleManufacturerModel;

	/** The vehicle information models. */
	//bi-directional many-to-one association to VehicleInformationModel
	@OneToMany(mappedBy = "vehicleModel")
	private List<VehicleInformationModel> vehicleInformationModels;

	/**
	 * Instantiates a new vehicle model.
	 */
	public VehicleModel()
	{
	}

	/**
	 * Gets the vehicle model id.
	 *
	 * @return the vehicle model id
	 */
	public int getVehicleModelId()
	{
		return this.vehicleModelId;
	}

	/**
	 * Sets the vehicle model id.
	 *
	 * @param vehicleModelId
	 *           the new vehicle model id
	 */
	public void setVehicleModelId(int vehicleModelId)
	{
		this.vehicleModelId = vehicleModelId;
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
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	public String getModelName()
	{
		return this.modelName;
	}

	/**
	 * Sets the model name.
	 *
	 * @param modelName
	 *           the new model name
	 */
	public void setModelName(String modelName)
	{
		this.modelName = modelName;
	}

	/**
	 * Gets the vehicle manufacturer model.
	 *
	 * @return the vehicle manufacturer model
	 */
	public VehicleManufacturerModel getVehicleManufacturerModel()
	{
		return this.vehicleManufacturerModel;
	}

	/**
	 * Sets the vehicle manufacturer model.
	 *
	 * @param vehicleManufacturerModel
	 *           the new vehicle manufacturer model
	 */
	public void setVehicleManufacturerModel(VehicleManufacturerModel vehicleManufacturerModel)
	{
		this.vehicleManufacturerModel = vehicleManufacturerModel;
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
		vehicleInformationModel.setVehicleModel(this);

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
		vehicleInformationModel.setVehicleModel(null);

		return vehicleInformationModel;
	}

}
