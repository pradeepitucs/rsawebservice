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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



/**
 * The Class VehicleManufacturerModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "vehicle_manufacturer_t")
@NamedQuery(name = "VehicleManufacturerModel.findAll", query = "SELECT v FROM VehicleManufacturerModel v")
public class VehicleManufacturerModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The manufacturer id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manufacturer_id")
	private int manufacturerId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The manufacturer name. */
	@Column(name = "manufacturer_name")
	private String manufacturerName;

	/** The vehicle models. */
	//bi-directional many-to-one association to VehicleModel
	@OneToMany(mappedBy = "vehicleManufacturerModel", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<VehicleModel> vehicleModels;

	//	//bi-directional many-to-one association to VehicleInformationModel
	//	@OneToMany(mappedBy="vehicleManufacturerModel", fetch=FetchType.EAGER)
	//	@Fetch(value = FetchMode.SUBSELECT)
	//	private List<VehicleInformationModel> vehicleInformationModels;

	/**
	 * Instantiates a new vehicle manufacturer model.
	 */
	public VehicleManufacturerModel()
	{
	}

	/**
	 * Gets the manufacturer id.
	 *
	 * @return the manufacturer id
	 */
	public int getManufacturerId()
	{
		return this.manufacturerId;
	}

	/**
	 * Sets the manufacturer id.
	 *
	 * @param manufacturerId
	 *           the new manufacturer id
	 */
	public void setManufacturerId(int manufacturerId)
	{
		this.manufacturerId = manufacturerId;
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
	 * Gets the manufacturer name.
	 *
	 * @return the manufacturer name
	 */
	public String getManufacturerName()
	{
		return this.manufacturerName;
	}

	/**
	 * Sets the manufacturer name.
	 *
	 * @param manufacturerName
	 *           the new manufacturer name
	 */
	public void setManufacturerName(String manufacturerName)
	{
		this.manufacturerName = manufacturerName;
	}

	/**
	 * Gets the vehicle models.
	 *
	 * @return the vehicle models
	 */
	public List<VehicleModel> getVehicleModels()
	{
		return this.vehicleModels;
	}

	/**
	 * Sets the vehicle models.
	 *
	 * @param vehicleModels
	 *           the new vehicle models
	 */
	public void setVehicleModels(List<VehicleModel> vehicleModels)
	{
		this.vehicleModels = vehicleModels;
	}

	/**
	 * Adds the vehicle model.
	 *
	 * @param vehicleModel
	 *           the vehicle model
	 * @return the vehicle model
	 */
	public VehicleModel addVehicleModel(VehicleModel vehicleModel)
	{
		getVehicleModels().add(vehicleModel);
		vehicleModel.setVehicleManufacturerModel(this);

		return vehicleModel;
	}

	/**
	 * Removes the vehicle model.
	 *
	 * @param vehicleModel
	 *           the vehicle model
	 * @return the vehicle model
	 */
	public VehicleModel removeVehicleModel(VehicleModel vehicleModel)
	{
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
