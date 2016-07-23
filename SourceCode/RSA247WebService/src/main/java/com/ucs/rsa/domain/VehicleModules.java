package com.ucs.rsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_module_t")
public class VehicleModules extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "module_details_id", unique = true, insertable = true, updatable = false)
	private int moduleDetailsID;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="module_year")
	private int moduleYear;
	
	@Column(name="module_name")
	private String moduleName;
	
	@Column(name="vehicle_class")
	private String vehicleClass;
	
	@Column(name="vehicle_category")
	private String vehicleCategory;
	
	@Column(name="vehicle_type_id")
	private int vehicleTypeID;
	
	@Column(name="isEnabled")
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
		return "VehicleModules [moduleDetailsID=" + moduleDetailsID + ", manufacturer=" + manufacturer
				+ ", moduleYear=" + moduleYear + ", moduleName=" + moduleName + ", vehicleClass=" + vehicleClass
				+ ", vehicleCategory=" + vehicleCategory + ", vehicleTypeID=" + vehicleTypeID + ", isEnabled="
				+ isEnabled + "]";
	}

}
