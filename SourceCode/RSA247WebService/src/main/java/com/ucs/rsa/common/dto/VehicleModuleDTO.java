/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class VehicleModuleDTO.
 */
@XmlRootElement(name = "vehicleModuleDetail", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleModuleDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The module details ID. */
	private int moduleDetailsID;

	/** The manufacturer ID. */
	private int manufacturerID;

	/** The module year. */
	private int moduleYear;

	/** The module name. */
	private String moduleName;

	/** The vehicle class. */
	private String vehicleClass;

	/** The vehicle category. */
	private String vehicleCategory;

	/** The vehicle type ID. */
	private int vehicleTypeID;

	/** The is enabled. */
	private boolean isEnabled;

	/**
	 * Gets the module details ID.
	 *
	 * @return the module details ID
	 */
	public int getModuleDetailsID()
	{
		return moduleDetailsID;
	}

	/**
	 * Sets the module details ID.
	 *
	 * @param moduleDetailsID
	 *           the new module details ID
	 */
	public void setModuleDetailsID(int moduleDetailsID)
	{
		this.moduleDetailsID = moduleDetailsID;
	}

	/**
	 * Gets the manufacturer ID.
	 *
	 * @return the manufacturer ID
	 */
	public int getManufacturerID()
	{
		return manufacturerID;
	}

	/**
	 * Sets the manufacturer ID.
	 *
	 * @param manufacturerID
	 *           the new manufacturer ID
	 */
	public void setManufacturerID(int manufacturerID)
	{
		this.manufacturerID = manufacturerID;
	}

	/**
	 * Gets the module year.
	 *
	 * @return the module year
	 */
	public int getModuleYear()
	{
		return moduleYear;
	}

	/**
	 * Sets the module year.
	 *
	 * @param moduleYear
	 *           the new module year
	 */
	public void setModuleYear(int moduleYear)
	{
		this.moduleYear = moduleYear;
	}

	/**
	 * Gets the module name.
	 *
	 * @return the module name
	 */
	public String getModuleName()
	{
		return moduleName;
	}

	/**
	 * Sets the module name.
	 *
	 * @param moduleName
	 *           the new module name
	 */
	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	/**
	 * Gets the vehicle class.
	 *
	 * @return the vehicle class
	 */
	public String getVehicleClass()
	{
		return vehicleClass;
	}

	/**
	 * Sets the vehicle class.
	 *
	 * @param vehicleClass
	 *           the new vehicle class
	 */
	public void setVehicleClass(String vehicleClass)
	{
		this.vehicleClass = vehicleClass;
	}

	/**
	 * Gets the vehicle category.
	 *
	 * @return the vehicle category
	 */
	public String getVehicleCategory()
	{
		return vehicleCategory;
	}

	/**
	 * Sets the vehicle category.
	 *
	 * @param vehicleCategory
	 *           the new vehicle category
	 */
	public void setVehicleCategory(String vehicleCategory)
	{
		this.vehicleCategory = vehicleCategory;
	}

	/**
	 * Gets the vehicle type ID.
	 *
	 * @return the vehicle type ID
	 */
	public int getVehicleTypeID()
	{
		return vehicleTypeID;
	}

	/**
	 * Sets the vehicle type ID.
	 *
	 * @param vehicleTypeID
	 *           the new vehicle type ID
	 */
	public void setVehicleTypeID(int vehicleTypeID)
	{
		this.vehicleTypeID = vehicleTypeID;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled()
	{
		return isEnabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param isEnabled
	 *           the new enabled
	 */
	public void setEnabled(boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "VehicleModuleDetailsDTO [moduleDetailsID=" + moduleDetailsID + ", manufacturerID=" + manufacturerID
				+ ", moduleYear=" + moduleYear + ", moduleName=" + moduleName + ", vehicleClass=" + vehicleClass
				+ ", vehicleCategory=" + vehicleCategory + ", vehicleTypeID=" + vehicleTypeID + ", isEnabled=" + isEnabled + "]";
	}

}
