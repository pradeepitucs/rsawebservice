/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class UserVehicleModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "user_vehicle_t")
@NamedQuery(name = "UserVehicleModel.findAll", query = "SELECT u FROM UserVehicleModel u")
public class UserVehicleModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vehicle id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_vehicle_id")
	private int vehicleId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The user id. */
	@Column(name = "user_id")
	private int userId;

	/** The vehicle reg no. */
	@Column(name = "registration_number")
	private String vehicleRegNo;

	/** The year. */
	@Column(name = "year")
	private int year;

	/** The vehicle information model. */
	// bi-directional many-to-one association to VehicleModel
	@ManyToOne
	@JoinColumn(name = "vehicle_information_id")
	private VehicleInformationModel vehicleInformationModel;

	/**
	 * Instantiates a new user vehicle model.
	 */
	public UserVehicleModel()
	{
	}

	/**
	 * Gets the vehicle id.
	 *
	 * @return the vehicle id
	 */
	public int getVehicleId()
	{
		return this.vehicleId;
	}

	/**
	 * Sets the vehicle id.
	 *
	 * @param vehicleId
	 *           the new vehicle id
	 */
	public void setVehicleId(int vehicleId)
	{
		this.vehicleId = vehicleId;
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
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId()
	{
		return this.userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *           the new user id
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * Gets the vehicle reg no.
	 *
	 * @return the vehicle reg no
	 */
	public String getVehicleRegNo()
	{
		return this.vehicleRegNo;
	}

	/**
	 * Sets the vehicle reg no.
	 *
	 * @param vehicleRegNo
	 *           the new vehicle reg no
	 */
	public void setVehicleRegNo(String vehicleRegNo)
	{
		this.vehicleRegNo = vehicleRegNo;
	}

	/**
	 * Gets the vehicle information model.
	 *
	 * @return the vehicle information model
	 */
	public VehicleInformationModel getVehicleInformationModel()
	{
		return vehicleInformationModel;
	}

	/**
	 * Sets the vehicle information model.
	 *
	 * @param vehicleInformationModel
	 *           the new vehicle information model
	 */
	public void setVehicleInformationModel(VehicleInformationModel vehicleInformationModel)
	{
		this.vehicleInformationModel = vehicleInformationModel;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year
	 *           the new year
	 */
	public void setYear(int year)
	{
		this.year = year;
	}

}
