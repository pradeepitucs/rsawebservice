package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleModuleDetail", namespace = "com.ucs.rsa.dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleModuleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int moduleDetailsID;
	private String manufacturer;
	private int moduleYear;
	private String moduleName;
	private String vehicleClass;
	private String vehicleCategory;
	private int vehicleTypeID;
	private boolean isEnabled;

	public int getModuleDetailsID() {
		return moduleDetailsID;
	}

	public void setModuleDetailsID(int moduleDetailsID) {
		this.moduleDetailsID = moduleDetailsID;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getModuleYear() {
		return moduleYear;
	}

	public void setModuleYear(int moduleYear) {
		this.moduleYear = moduleYear;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public int getVehicleTypeID() {
		return vehicleTypeID;
	}

	public void setVehicleTypeID(int vehicleTypeID) {
		this.vehicleTypeID = vehicleTypeID;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "VehicleModuleDetailsDTO [moduleDetailsID=" + moduleDetailsID + ", manufacturer=" + manufacturer
				+ ", moduleYear=" + moduleYear + ", moduleName=" + moduleName + ", vehicleClass=" + vehicleClass
				+ ", vehicleCategory=" + vehicleCategory + ", vehicleTypeID=" + vehicleTypeID + ", isEnabled="
				+ isEnabled + "]";
	}

}
